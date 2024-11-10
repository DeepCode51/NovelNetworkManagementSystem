function Collect(){

}


// 监听收藏事件
Collect.prototype.listenCollectEvent = function(){
    $('.collent-btn').click(function(){
        var self = $(this);
        var novelId = self.parents('.base-novel-div').attr('data-novel-id');
        var collected = self.attr('data-collected');
        var url = '';
        var tooltipTitle = '';
        if(collected ==='true') {
            url = '/account/cancel_collect/';
            tooltipTitle = '点击收藏';
        } else{
            url = '/account/collect/';
            tooltipTitle = '已收藏';
        }
        myajax.post({
            'url': url,
            'data': {
                'novel_id': novelId
            },
            'success': function(result) {
                if(result['code'] === 200) {
                    if(collected ==='true') {
                        self.removeClass('btn-warning');
                        self.addClass('btn-default');
                        self.attr('data-collected','false');
                    } else{
                        self.removeClass('btn-default');
                        self.addClass('btn-warning');
                        self.attr('data-collected','true');
                    }
                    self.attr('data-original-title',tooltipTitle);
                }
            }
        })
    })
};

Collect.prototype.run = function(){
    this.listenCollectEvent();
};

$(function(){
    var collect = new Collect();
    collect.run();
});