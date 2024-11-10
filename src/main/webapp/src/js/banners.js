function Banners(){

}

Banners.prototype.run = function(){
    this.listenAddBannerEvent();
    this.loadData();
};


// 添加图片事件
Banners.prototype.addImageSelectEvent = function(bannerItem){
    var image = bannerItem.find('.thumbnail');
    var imageInput = bannerItem.find('.image-input');
    image.click(function(){
        imageInput.click();
    });
    imageInput.change(function(){
        var file = this.files[0];
        var formData = new FormData();
        formData.append('image',file);
        myajax.post({
            'url': '/cms/upload_file/',
            'data':formData,
            'processData': false,
            'contentType': false,
            'success': function(result){
                if(result['code'] === 200){
                    var url = result['data']['url'];
                    image.attr('src',url);
                }
            }
        })
    });
};

// 监听删除事件
Banners.prototype.addRemoveBannerEvent = function(bannerItem){
    var closeBtn = bannerItem.find('.close-btn');
    var bannerId = null;
    closeBtn.click(function(){
        bannerId = bannerItem.attr('data-banner-id');
        if(bannerId){
            xfzalert.alertConfirm({
                'text': '确定要删除该轮播图吗？',
                'confirmCallback': function(){
                    myajax.post({
                        'url': '/cms/delete_banner/',
                        'data': {
                            'id': bannerId,
                        },
                        'success': function(result){
                            if(result['code'] === 200){
                                xfzalert.alertSuccess('删除成功');
                                bannerItem.remove();
                            } else{
                                xfzalert.alertError('删除失败');
                            }
                        }
                    })
                }
            })
        } else{
            bannerItem.remove();
        }
    });
};

// 监听保存事件
Banners.prototype.addSaveBannerEvent = function(bannerItem){
    var self = this;
    var saveBtn = bannerItem.find('.save-btn');
    var image = bannerItem.find('.thumbnail');
    var priorityInput = bannerItem.find("input[name='priority']");
    var linkToInput = bannerItem.find("input[name='link_to']");
    var prioritySpan = bannerItem.find("span[class='priority']");
    var bannerId = bannerItem.attr('data-banner-id');
    var url = "";
    if(bannerId){
        url = '/cms/edit_banner/';
    } else{
        url = '/cms/add_banner/';
    }
    saveBtn.click(function(){
        var priority = priorityInput.val();
        var linkTo = linkToInput.val();
        var imageUrl = image.attr('src');
        myajax.post({
            'url': url,
            'data': {
                'priority': priority,
                'image_url': imageUrl,
                'link_to': linkTo,
                'id': bannerId
            },
            'success': function(result){
                if(result['code'] === 200){
                    if(bannerId){
                        window.messageBox.showSuccess('缩略图修改成功');
                    } else{
                        bannerId = result['data']['banner_id'];
                        bannerItem.attr('data-banner-id',bannerId);
                        window.messageBox.showSuccess('缩略图添加成功');
                    }
                    prioritySpan.text('优先级：'+priority);
                }
            }
        })
    })
};

// HTML加入轮播图框架box
Banners.prototype.createBannerItem = function(banner){
    var self = this;
    var html = template('banner-item',{'banner':banner});
    var bannerListGroup = $('.banner-list-group');
    var bannerItem = null;
    if(banner){
        bannerListGroup.append(html);
        bannerItem = bannerListGroup.find('.banner-item:last');
    } else{
        bannerListGroup.prepend(html);
        bannerItem = bannerListGroup.find('.banner-item:first');
    }
    self.addImageSelectEvent(bannerItem);
    self.addRemoveBannerEvent(bannerItem);
    self.addSaveBannerEvent(bannerItem);
};

// 监听添加轮播图事件
Banners.prototype.listenAddBannerEvent = function(){
    var self = this;
    var addBannerBtn = $('#add-banner-btn');
    var bannerListGroup = $('.banner-list-group');
    addBannerBtn.click(function(){
        var length = bannerListGroup.children().length;
        if(length >= 6){
            window.messageBox.showInfo('轮播图最多不能超过6张！');
            return;
        }
        self.createBannerItem();
    })
};

// 异步加载数据
Banners.prototype.loadData = function(){
    var self = this;
    myajax.get({
        'url': '/cms/banner_list/',
        'success': function(result){
            if(result['code'] === 200){
                var banners = result['data']['banners'];
                for(var i=0;i<banners.length;i++){
                    var banner = banners[i];
                    self.createBannerItem(banner);
                }
            }
        }
    })
};

$(function(){
    var banners = new Banners();
    banners.run();
});