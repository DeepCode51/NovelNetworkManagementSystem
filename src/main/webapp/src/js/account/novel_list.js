function NovelList(){

}
// 初始化时间选择框
NovelList.prototype.initDatePicker = function(){
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

// 监听更新事件
NovelList.prototype.listenUpdateEvent = function(){
    $('.update-btn').click(function(){
        var novelId = $(this).parents('tr').attr('data-novel-id');
        var isComplete = $(this).attr('data-finish');
        console.log(isComplete);
        var link_to = '/account/write_chapter/?novel_id=' + novelId;
        if(isComplete === 'True'){
            xfzalert.alertConfirm({
                'title': '更新',
                'text': '该小说已完结，确定要改为连载状态吗？',
                'confirmCallback': function(){
                    myajax.post({
                        'url': '/account/set_serialize/',
                        'data': {
                            'novel_id': novelId
                        },
                        'success': function(result){
                            if(result['code'] === 200){
                                window.location = link_to;
                            }
                        }
                    })
                }
            })
        } else{
            window.location = link_to;
        }
    })
};

// 监听删除小说事件
NovelList.prototype.listenDeleteNovelEvent = function(){
    var deleteBtn = $('.delete-btn');
    deleteBtn.click(function(){
        var novelId = $(this).parents('tr').attr('data-novel-id');
        xfzalert.alertConfirm({
            'text': '您确定要删除这个小说吗？',
            'confirmCallback': function(){
                myajax.post({
                    'url': '/account/delete_novel/',
                    'data': {
                        'novel_id': novelId
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

// 监听设置为完结事件
NovelList.prototype.listenSetFinishEvent = function(){
    $('.set-finish-btn').click(function(){
        var novelId = $(this).parents('tr').attr('data-novel-id');
        xfzalert.alertConfirm({
            'text': '您确定要将该小说设置为完结？',
            'confirmCallback': function(){
                myajax.post({
                    'url': '/account/set_finish/',
                    'data': {
                        'novel_id': novelId
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast('设置成功');
                            setTimeout(function(){
                                window.location = window.location.href;
                            },1000);
                        }
                    }
                });
            }
        });
    })
};

NovelList.prototype.run = function(){
    this.initDatePicker();
    this.listenDeleteNovelEvent();
    this.listenSetFinishEvent();
    this.listenUpdateEvent();
};


$(function(){
    var novelList = new NovelList();
    novelList.run();
});