function Staff(){

}

// 监听移除员工事件
Staff.prototype.listenDeleteStaffEvent = function(){
    $('.delete-btn').click(function(){
        var trTag = $(this).parent().parent();
        var staffId = trTag.attr('data-staff-id');
        var usernameTag = trTag.children().get(0);
        var username = $(usernameTag).text();
        xfzalert.alertConfirm({
            'title':'删除',
            'text': '确定要将员工“' + username + '”从员工表中移除吗？',
            'confirmCallback': function(){
                myajax.post({
                    'url': '/cms/delete_staff/',
                    'data': {
                        'staff_id': staffId
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast('删除成功');
                            setTimeout(function(){
                                window.location = window.location.href;
                            },1000)
                        }
                    }
                })
            }
        });
    });
};

Staff.prototype.run = function(){
    this.listenDeleteStaffEvent();
};

$(function(){
    var staff = new Staff();
    staff.run();
});