function Chapter() {    // init

}
Chapter.prototype.listenScrollEvent = function (){
    var body = $('.body-wrapper');
    var bodyOffsetTop = body.offset().top;
    var leftSidebar = $('.left-sidebar');
    var rightSidebar = $('.right-sidebar');
    $(window).scroll(function(){
        var scrollPos = $(window).scrollTop();
        if(scrollPos > bodyOffsetTop) {
            leftSidebar.css({'position':'fixed','top':'0'});
        } else{
            leftSidebar.css({'position':'absolute','top':'0'});
        }
    })
};

// 收藏
Chapter.prototype.listenCollectEvent = function(){
    var novelId = $('#novel-id').attr('data-novel-id');
    $('.collect-btn').click(function(){
        myajax.post({
            'url': '/account/collect/',
            'data': {
                'novel_id': novelId,
            },
            'success': function(result){
                if(result['code'] === 200) {
                    window.messageBox.showSuccess('收藏成功');
                    $('.collect-btn').parent().html('<span class="collected">已在书架</span>');
                }
            }
        })
    })
};

Chapter.prototype.run = function(){
    this.listenScrollEvent();
    this.listenCollectEvent();
};

$(function(){
    var chapter = new Chapter();
    chapter.run();
});