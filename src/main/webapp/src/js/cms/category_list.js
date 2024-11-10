function NovelCategory(){

}

// 监听添加分类事件
NovelCategory.prototype.listenAddCategoryEvent = function(){
    var addBtn = $("#add-btn");
    addBtn.click(function(){
        xfzalert.alertOneInput({
            'title': '添加分类',
            'text': '请输入分类名称',
            'placeholder': '分类名称',
            'confirmCallback': function(inputValue){
                myajax.post({
                    'url': '/cms/add_novel_category/',
                    'data': {
                        'name': inputValue,
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast("添加成功");
                            setTimeout(function(){
                                window.location.reload();
                            },1000)
                        } else{
                            xfzalert.close();
                        }
                    }
                })
            }
        })
    })
};

// 监听编辑分类事件
NovelCategory.prototype.listenEditCategoryEvent = function(){
    var editBtn = $('.edit-btn');
    editBtn.click(function(){
        var currentBtn = $(this);
        var tr = currentBtn.parent().parent();
        var id = tr.attr('data-id');
        var name = tr.attr('data-name');
        xfzalert.alertOneInput({
            'title': '修改分类名称',
            'text': '请输入分类的新名称',
            'value': name,
            'confirmCallback': function(inputValue){
                console.log('id: '+id);
                console.log('name: '+inputValue);
                myajax.post({
                    'url': '/cms/edit_novel_category/',
                    'data': {
                        'id': id,
                        'name': inputValue
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast('修改成功！');
                            setTimeout(function(){
                                window.location.reload()
                            },1000)
                        } else{
                            xfzalert.close()
                        }
                    }
                })
            }
        })
    })
};

// 监听删除分类事件
NovelCategory.prototype.listenDeleteCategoryEvent = function(){
    var deleteBtn = $('.delete-btn')
    deleteBtn.click(function(){
        var currentBtn = $(this);
        var tr = currentBtn.parent().parent();
        var id = tr.attr("data-id");
        xfzalert.alertConfirm({
            'title': '删除分类',
            'text': '您确定要删除该分类吗？',
            'confirmCallback': function(){
                myajax.post({
                    'url': '/cms/delete_novel_category/',
                    'data': {
                        'id': id
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast('删除成功');
                            setTimeout(function(){
                                window.location.reload();
                            },1000);
                        } else{
                            xfzalert.close();
                        }
                    }
                })
            },
            'cancelCallback': function(){
                xfzalert.close()
            }
        })
    })
};

NovelCategory.prototype.run = function(){
    this.listenAddCategoryEvent();
    this.listenEditCategoryEvent();
    this.listenDeleteCategoryEvent();
};

$(function(){
    var novelCategory = new  NovelCategory();
    novelCategory.run();
});