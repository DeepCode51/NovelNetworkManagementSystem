function Collect(){

}

// 监听加入书架事件
Collect.prototype.listenCollectNovelEvent = function(){
    $('.collect-btn').click(function(){
        var self = $(this);
        var novelId = $(this).parents('.novel-group').attr('data-novel-id');
        myajax.post({
            'url': '/account/collect/',
            'data': {
                'novel_id': novelId
            },
            'success': function(result){
                if(result['code'] === 200){
                    window.messageBox.showSuccess('收藏成功');
                    self.text('已在书架');
                    self.removeClass('collect-btn');
                    self.addClass('collected');
                }
            }
        })
    });
};

Collect.prototype.run = function(){
    this.listenCollectNovelEvent();
};
$(function(){
    var collect = new Collect();
    collect.run();
});