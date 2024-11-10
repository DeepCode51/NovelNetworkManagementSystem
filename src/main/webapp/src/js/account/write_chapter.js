function Chapter(){

}


// 提交章节
Chapter.prototype.listenSubmitEvent = function(){
    var submitBtn = $('#submit-btn');
    submitBtn.click(function(event){
        event.preventDefault();       // 阻止默认事件
        var btn = $(this);
        var chapterId = btn.attr('data-chapter-id');
        var novelId = btn.attr('data-novel-id');
        var title = $("input[name='title']").val();
        var content = window.ue.getContent();
        var number = $('#number').text();
        var url = "";
        var message = "";
        if(chapterId){
            url = '/account/update_chapter/';
            message = '第' + number + '章小说编辑成功！'
        } else{
            url = '/account/add_chapter/';
            message = '第' + number + '章小说发布成功！'
        }
        myajax.post({
            'url': url,
            'data': {
                'title': title,
                'content': content,
                'novel_id': novelId,
                'number': number,
                'id': chapterId
            },
            'success': function(result){
                if(result['code'] === 200){
                    xfzalert.alertSuccess(message,function(){
                        window.location = '../../../..';
                    })
                } else{
                    console.log(result)
                }
            }
        })
    })
};

// 初始化UEditor
Chapter.prototype.initUEditor = function(){
    window.ue = UE.getEditor("editor",{
        'initialFrameHeight': 400,
        'serverUrl': '/ueditor/upload/',
    })
};

Chapter.prototype.run = function(){
    this.initUEditor();
    this.listenSubmitEvent();
};

$(function(){
    var chapter = new Chapter();
    chapter.run();
    Chapter.progressGroup = $('#progress-group');
    Chapter.progressBar = $('.progress-bar');
});