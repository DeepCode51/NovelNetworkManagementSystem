function Chapter(){

}


// 修改章节
Chapter.prototype.listenSubmitEvent = function(){
    var submitBtn = $('#submit-btn');
    submitBtn.click(function(event){
        event.preventDefault();       // 阻止默认事件
        var btn = $(this);
        var chapterId = btn.attr('data-chapter-id');
        var title = $("input[name='title']").val();
        var content = window.ue.getContent();
        var number = $('#number').text();
        var url = '/cms/update_chapter/';
        var message = '第' + number + '章小说编辑成功！';

        myajax.post({
            'url': url,
            'data': {
                'title': title,
                'content': content,
                'id': chapterId,
                'number': number
            },
            'success': function(result){
                if(result['code'] === 200){
                    xfzalert.alertSuccess(message,function(){
                        console.log(result['data']['redirect']);
                        window.location = result['data']['redirect'];
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