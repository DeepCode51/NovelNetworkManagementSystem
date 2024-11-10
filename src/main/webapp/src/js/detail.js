function Detail(){

}

// 监听信息和目录切换事件
Detail.prototype.listenSwitchClickEvent = function(){
    var self = this;

    self.profileTag.click(function(){
        self.profileTag.css({'color':'#ff3300','border-bottom':'2px solid #ff3300'});
        self.catalogueTag.css({'color':'#999999','border-bottom':'2px solid #ffffff'});
        self.smallText.css({'color':'#999999'});
        self.profile.show();
        self.catalogue.hide();
        $(this).unbind('mouseenter').unbind('mouseleave');
        self.catalogueTag.hover(
            function(){
                $(this).css({'color':'#ff3300'});
                self.smallText.css({'color':'#ff3300'});
            },
            function(){
                $(this).css({'color':'#999999'});
                self.smallText.css({'color':'#999999'});
            }
        );
    });
    self.catalogueTag.click(function(){
        self.catalogueTag.css({'color':'#ff3300','border-bottom':'2px solid #ff3300'});
        self.smallText.css({'color':'#ff3300'});
        self.profileTag.css({'color':'#999999','border-bottom':'2px solid #ffffff'});
        self.catalogue.show();
        self.profile.hide();
        $(this).unbind('mouseenter').unbind('mouseleave');
        self.profileTag.hover(
            function(){
                $(this).css({'color':'#ff3300'});
            },
            function(){
                $(this).css({'color':'#999999'});

            }
        );
    });
};

// 监听鼠标悬停事件
Detail.prototype.listenSwitchHoverEvent = function(){
    var self = this;
    self.catalogueTag.hover(
        function(){
            $(this).css({'color':'#ff3300'});
            self.smallText.css({'color':'#ff3300'});
        },
        function(){
            $(this).css({'color':'#999999'});
            self.smallText.css({'color':'#999999'});
        }
    );
};

// 监听加入书架事件
Detail.prototype.listenCollectNovelEvent = function(){
    $('.collect-btn').click(function(){
        var self = $(this);
        var novelId = $(this).attr('data-novel-id');
        myajax.post({
            'url': '/account/collect/',
            'data': {
                'novel_id': novelId
            },
            'success': function(result){
                if(result['code'] === 200){
                    window.messageBox.showSuccess('收藏成功');
                    self.text('已收藏');
                }
            }
        })
    });
};
Detail.prototype.run = function(){
    this.profileTag = $('.profile-tag');
    this.profile = $('.profile');
    this.catalogueTag = $('.catalogue-tag');
    this.catalogue = $('.catalogue');
    this.smallText = $('.small-text');
    this.listenSwitchHoverEvent();
    this.listenSwitchClickEvent();
    this.listenCollectNovelEvent();
};

$(function(){
    var detail = new Detail();
    detail.run();
});