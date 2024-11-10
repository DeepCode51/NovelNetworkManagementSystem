function ExcellentWorks(){

}

ExcellentWorks.prototype.listenSubmitWorks = function() {
    $('.submit-btn').click(function(){
        var box = $(this).parents('.box');
        console.log(box);
        var worksId = box.attr('data-works-id');
        var location = box.attr('data-location');
        var title = box.find('input[name="title"]').val();
        var linkTo = box.find('input[name="link_to"]').val();
        var message = '';
        if(worksId) {
            message = '修改成功';
        } else{
            message = '添加成功';
        }
        myajax.post({
            'url': '/cms/edit_excellent_works/',
            'data': {
                'id': worksId,
                'location': location,
                'title': title,
                'link_to': linkTo
            },
            'success': function(result){
                if(result['code'] === 200){
                    window.messageBox.showSuccess(message)
                }
            }
        })
    })
};

ExcellentWorks.prototype.run = function(){
    this.listenSubmitWorks();
};

$(function(){
    var excellentWorks = new ExcellentWorks();
    excellentWorks.run();
});