function AdSet(){

}

// 初始化模态编辑框
AdSet.prototype.initModal = function(){
    myajax.get({
        'url': '/cms/get_ads/',
        'success': function(result){
            if(result['code'] === 200){
                var ads = result['data']['ads'];
                var arr = [0,0,0,0];
                // 将广告放入广告栏
                for(var i=0;i<ads.length;i++){
                    var html = template('adhtml',{'ad':ads[i]});
                    var location = ads[i].location;
                    arr[location-1] = 1;
                    $("[data-location='" + location + "']").append(html);
                }
                // 将广告栏为空的设置占位符
                for(var m=0;m<4;m++){
                    if(arr[m] === 0){
                        var blankAd = {
                            'location': m + 1,
                            'image_url': '/static/images/novel/advertisement/blank.png',
                            'link_to': '',
                            'hint': '',
                            'id':0
                        };
                        var bHtml = template('adhtml',{'ad':blankAd});
                        $("[data-location='" + (m+1) + "']").append(bHtml);
                    }
                }
            }
        }
    })
};

// 监听图片更改事件
AdSet.prototype.listenChangeImageEvent = function(){
    var thumbnailBtn = $('.thumbnail-btn');
    console.log(thumbnailBtn)
    thumbnailBtn.click(function(){
        var img = $(this).children('img');
        var fileTag = $(this).parents('.modal-body').find('.image-file');
        fileTag.change(function(){
            var file = $(this)[0].files[0];
            var formData = new FormData();
            formData.append('file',file);
            myajax.post({
                'url': '/cms/upload_file/',
                'data': formData,
                'processData': false,
                'contentType': false,
                'success': function(result){
                    if(result['code'] === 200){
                        var image_url = result['data']['url'];
                        img.attr('src',image_url);
                    }
                }
            })
        });
        fileTag.trigger("click");
    })
};

// 监听广告提交事件
AdSet.prototype.listenAddSubmitEvent = function(){
    var submitBtn = $('.submit-btn');
    submitBtn.click(function(){
        var submitBtn = $(this);
        var location = $(this).attr('data-location');
        var content = $(this).parents('.modal-content');
        var image_url = content.find('.thumbnail-btn').children('img').attr('src');
        var link_to = content.find('input[name="link_to"]').val();
        var hint = content.find('input[name="hint"]').val();
        var id = $(this).attr('data-ad-id');
        var url = null;
        var message = null;
        if(id === '0'){
            url = '/cms/add_ad/';
            message = '添加成功';
        } else{
            url = '/cms/edit_ad/';
            message = '编辑成功';
        }
        var data = {
            'image_url': image_url,
            'link_to': link_to,
            'hint': hint,
            'location': location,
        };
        if(id !== '0'){
            data['id'] = id
        }
        myajax.post({
            'url': url,
            'data': data,
            'success': function(result){
                if(result['code'] === 200){
                    var ad = result['data']['ad'];
                    window.messageBox.showSuccess(message);
                    submitBtn.parents('div.thumbnail').find('img.thumbnail').attr('src',ad.image_url);
                    submitBtn.parents('div.thumbnail').find('.thumbnail-btn').children('img').attr('src',ad.image_url);
                    submitBtn.parents('div.thumbnail').find('.text-center').text(ad['hint']);
                    submitBtn.siblings('.close-btn').trigger("click");
                }
            }
        })
    });
};

AdSet.prototype.run = function(){
    var self = this;
    self.initModal();
    setTimeout(function(){
        self.listenChangeImageEvent();
        self.listenAddSubmitEvent();
    },5000);
};

$(function(){
    var adSet = new AdSet();
    adSet.run();
});