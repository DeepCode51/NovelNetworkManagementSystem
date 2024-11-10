function EditTag(){

}

// 监听提交标签事件    params:  node: 要提交的tr标签节点,  type: 'add' or 'edit'
EditTag.prototype.listenSubmitTagEvent = function(node,type){
    var self = this;
    var name = node.find('input[name="name"]').val();
    var url = null;
    var message = null;
    var data =  {
        'name': name,
    };
    if(type === 'edit'){
        data['id'] = node.attr('data-tag-id');
        url = '/cms/edit_tag/';
        message = '修改成功';
    } else if(type === 'add'){
        data['category_id'] = self.categoryId;
        url = '/cms/add_tag/';
        message = '添加成功';
    }
    myajax.post({
        'url': url,
        'data': data,
        'success': function(result){
            // 提交成功后将编辑状态改为默认状态，并初始化节点
            if(result['code'] === 200){
                window.messageBox.showSuccess(message);
                var html = template('tag-default',{'tag':result['data']['tag']});
                var defaultNode = $($.parseHTML(jQuery.trim(html))); // html >> dom >> jquery
                node.replaceWith(defaultNode);
                self.initDefaultNode(defaultNode);
            }
        }
    })
};

// 监听添加标签事件
EditTag.prototype.listenAddTagEvent = function(){
    var self = this;
    var html = template('add-tag',{});
    $('.add-btn').click(function(){
        // 如果之前为空，则取消‘暂无标签’文本
        if(self.tbody.hasClass('tag-empty')){
            self.tbody.empty();
            self.tbody.removeClass('tag-empty');
        }
        // 初始化‘添加节点’， 并添加到父节点的子元素的最前面
        var addNode = $($.parseHTML(jQuery.trim(html)));
        self.initAddNode(addNode);
        self.tbody.prepend(addNode);
    });
};

// 监听编辑标签事件
// 初始化’默认节点‘时已经绑定编辑事件

// 初始化‘默认节点’
EditTag.prototype.initDefaultNode = function(node){
    var self = this;
    // 监听编辑事件
    node.find('.edit-btn').click(function(){
        var tagId = node.attr('data-tag-id');
        myajax.post({
            'url':'/cms/get_tag/',
            'data':{
                'id':tagId
            },
            'success': function(result){
                if(result['code'] === 200){
                    var tag = result['data']['tag'];
                    var html = template('edit-tag',{'tag':tag});
                    var editNode = $($.parseHTML(jQuery.trim(html)));
                    self.initEditNode(editNode, node);
                    // 一旦发生替换，原元素所具备的事件都将消失。
                    node.replaceWith(editNode);
                }
            }
        });
    });
    // 监听删除事件
    node.find('.delete-btn').click(function(){
        var tagId = node.attr('data-tag-id');
        xfzalert.alertConfirm({
            'text': '确定要删除“' + node.find('.tag').text() + '”标签吗？',
            'confirmButtonText': '删除',
            'confirmCallback': function(){
                myajax.post({
                    'url': '/cms/delete_tag/',
                    'data': {
                        'id': tagId
                    },
                    'success': function(result){
                        if(result['code'] === 200){
                            xfzalert.alertSuccessToast('删除成功');
                            if(self.tbody.children().length === 0){
                                self.tbody.append("<tr><td><h2>暂无标签</h2></td></tr>");
                                self.tbody.addClass('tag-empty');
                            }
                            setTimeout(function(){
                                node.remove();
                            },1000)
                        }
                    }
                })
            }
        });

    })
};

// 初始化‘新建节点’
EditTag.prototype.initAddNode = function(node){
    var self = this;
    // 绑定取消事件
    node.find('.add-cancel').click(function(){
        node.remove();
        if(self.tbody.children().length === 0){
            self.tbody.append("<tr><td><h2>暂无标签</h2></td></tr>");
            self.tbody.addClass('tag-empty');
        }
    });
    // 绑定保存事件
    node.find('.add-submit').click(function(){
        self.listenSubmitTagEvent(node,'add');
    });
};

// 初始化‘编辑节点’  params: node: 编辑节点,  original: 点击取消后显示的原始节点
EditTag.prototype.initEditNode = function(node, original){
    var self = this;
    // 绑定保存事件
    node.find('.edit-submit').click(function(){
        self.listenSubmitTagEvent(node,'edit');
    });
    // 绑定取消事件
    node.find('.edit-cancel').click(function(){
        self.initDefaultNode(original);
        node.replaceWith(original);
    });
};


// 异步加载标签
EditTag.prototype.loadData = function(){
    var self = this;
    myajax.get({
        'url': '/cms/get_tags/?category_id=' + self.categoryId,
        'success': function(result){
            if(result['code'] === 200){
                // 初始化节点并添加到父节点
                var tags = result['data']['tags'];
                for(var i=0;i<tags.length;i++){
                    var html = template('tag-default',{'tag':tags[i]});
                    var defaultNode = $($.parseHTML(jQuery.trim(html)));  // 去掉空格 转为jquery对象
                    self.initDefaultNode(defaultNode);
                    self.tbody.append(defaultNode);
                }
                if(tags.length === 0){
                    self.tbody.append("<tr><td><h2>暂无标签</h2></td></tr>");
                    self.tbody.addClass('tag-empty');
                }
            }
        }
    });
};

EditTag.prototype.run = function(){
    this.tbody = $('tbody');
    this.categoryId = this.tbody.attr('data-cate-id');
    this.listenAddTagEvent();
    this.loadData();
};

$(function(){
    var editTag = new EditTag();
    editTag.run();
});