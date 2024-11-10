function ChapterList(){

}
// 初始化时间选择框
ChapterList.prototype.initDatePicker = function(){
    var startPicker = $('#start-picker');
    var endPicker = $('#end-picker');
    var todayDate = new Date();
    var todayStr = todayDate.getFullYear() + '/' + (todayDate.getMonth()+1) + '/' + todayDate.getDate();
    var options = {
        'showButtonPanel': true,
        'format': 'yyyy/mm/dd',
        'startDate': '2019/11/1',
        'endDate': todayStr,
        'language': 'zh-CN',
        'todayBtn': 'linked',
        'todayHeightLight': true,
        'clearBtn': true,
        'autoclose': true,
    };

    startPicker.datepicker(options);
    endPicker.datepicker(options);
};
// 监听删除章节事件
ChapterList.prototype.listenDeleteChapterEvent = function(){
    var deleteBtn = $('.delete-btn');
    deleteBtn.click(function(){
        var chapterId = $(this).attr('data-chapter-id');
        xfzalert.alertConfirm({
            'text': '您确定要删除这篇新闻吗？',
            'confirmCallback': function(){
                myajax.post({
                    'url': '/cms/delete_chapter/',
                    'data': {
                        'chapter_id': chapterId
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast('删除成功');
                            setTimeout(function(){
                                window.location = window.location.href;
                            },1000);
                        }
                    }
                });
            }
        });
    });
};

ChapterList.prototype.run = function(){
    this.initDatePicker();
    this.listenDeleteChapterEvent();
};


$(function(){
    var chapterList = new ChapterList();
    chapterList.run();
});