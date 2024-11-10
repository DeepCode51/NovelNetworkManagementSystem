function Search() {

}

// 监听搜索事件
Search.prototype.listenSearchEvent = function(){
    $('.search-btn').click(function(){
        $('#search-submit').trigger('click');
    })
};

Search.prototype.run = function(){
    this.listenSearchEvent();
};

$(function(){
    var search = new Search();
    search.run();
});