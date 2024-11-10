// 用来处理登录和注册
function Auth(){
    this.maskWrapper = $('.mask-wrapper');
    this.scrollWrapper = $('.scroll-wrapper');
    this.SmsCaptchaBtn = $('.sms-captcha-btn');
    this.imgCaptcha = $(".img-captcha");
}

// 显示模态对话框
Auth.prototype.showEvent = function(){
    this.maskWrapper.show()
};

// 隐藏模态对话框
Auth.prototype.hideEvent = function(){
    this.maskWrapper.hide()
};

// 短信验证码发送成功
Auth.prototype.smsSuccessEvent = function(){
    var self = this
    messageBox.showSuccess("短信验证码发送成功")
    self.SmsCaptchaBtn.unbind('click')
    self.SmsCaptchaBtn.addClass('disabled')
    var count = 60
    // 添加定时器，每秒执行一次，60秒后终止
    var timer = setInterval(function(){
        self.SmsCaptchaBtn.text('已发送('+count+'s)')
        count--
        if(count<=0){
            clearInterval(timer)
            self.SmsCaptchaBtn.text('发送验证码')
            self.SmsCaptchaBtn.removeClass('disabled')
            self.listenSmsCaptchaEvent()
        }
    },1000)
};

// 监听模态对话框显示与隐藏事件
Auth.prototype.listenShowHideEvent = function(){
    var self = this
    self.signIn = $('.sign-in')
    self.signUp = $('.sign-up')
    var closeBtn = $('.close-btn')
    self.signIn.click(function(){
        self.scrollWrapper.css({'left':'0px'})
        self.showEvent()
    })
    self.signUp.click(function(){
        self.scrollWrapper.css({'left':'-400px'});
        self.imgCaptchaRefresh();
        self.showEvent();
    })
    closeBtn.click(function(){
        self.hideEvent()
    })
};

// 监听模态对话框切换事件
Auth.prototype.listenSwitchEvent = function(){
    var self = this
    var switcher = $('.switch')

    switcher.click(function(){
        var currentLeft = self.scrollWrapper.css('left')
        currentLeft = parseInt(currentLeft)
        if(currentLeft < 0){
            self.scrollWrapper.animate({'left':'0'})
        } else{
            self.imgCaptchaRefresh();
            self.scrollWrapper.animate({'left':'-400px'})
        }
    })
};

// 监听登录事件
Auth.prototype.listenSignInEvent = function(){
    var self = this
    var signInGroup = $('.signin-group')
    var telephoneInput = signInGroup.find("input[name='telephone']")
    var passwordInput = signInGroup.find("input[name='password']")
    var rememberInput = signInGroup.find("input[name='remember']")

    var signInBtn = signInGroup.find('.submit-btn');
    signInBtn.click(function(){
        var telephone = telephoneInput.val()
        var password = passwordInput.val()
        // 获取复选框是否勾选  True/False
        var remember = rememberInput.prop("checked")
        myajax.post({
            'url': '/xsauth/login/',
            'data': {
                'telephone': telephone,
                'password': password,
                'remember': remember?1:0,
            },
            'success': function(result){
                if(result['code'] === 200){
                    // 隐藏模态框
                    self.hideEvent();
                    // 刷新页面

                    if(self.hasOwnProperty('next')){
                        var next = self.next;
                        var protocol = window.location.protocol;     // 请求协议
                        var host = window.location.host;            // 主机名
                        var domain = protocol + '//' + host;         // 域名
                        window.location.href = domain + next
                        console.log(domain + next)
                    } else{
                        window.location.reload()
                    }
                }
            }
        })
    })
};

// 获取图形验证码
Auth.prototype.listenImgCaptchaEvent = function(){
    var self = this;
    self.imgCaptcha.click(function(){
        // 图片地址改变图片就会更新
        self.imgCaptchaRefresh();
    })
};

// 刷新图形验证码
Auth.prototype.imgCaptchaRefresh = function(){
    this.imgCaptcha.attr('src','/xsauth/img_captcha/'+'?random='+Math.random())
};

// 监听发送短信验证码
Auth.prototype.listenSmsCaptchaEvent = function(){
    var self = this
    var inputTelephone = $(".signup-group input[name='telephone']");
    var inputSmsCode = $(".signup-group input[name='sms_captcha']");
    self.SmsCaptchaBtn.click(function(){
        var telephone = inputTelephone.val()
        if(!telephone){
            messageBox.showInfo("请输入手机号码")
        } else{
            myajax.get({
                'url': '/xsauth/sms_captcha/',
                'data': {
                    'telephone': telephone
                },
                'success': function(result){
                    if(result["code"] === 200){
                        self.smsSuccessEvent();
                        var code = result['data']['code'];
                        inputSmsCode.val(code);
                        console.log(code);
                    }
                },
                'fail': function(error){
                    console.log(error)
                }
            })
        }
    })
};

// 监听注册事件
Auth.prototype.listenSignUpEvent = function(){
    var signUpGroup = $('.signup-group')
    var telephoneInput = signUpGroup.find("input[name='telephone']")
    var usernameInput = signUpGroup.find("input[name='username']")
    var imgCaptchaInput = signUpGroup.find("input[name='img_captcha']")
    var password1Input = signUpGroup.find("input[name='password1']")
    var password2Input = signUpGroup.find("input[name='password2']")
    var smsCaptchaInput = signUpGroup.find("input[name='sms_captcha']")

    var submitBtn = signUpGroup.find(".submit-btn")
    submitBtn.click(function(){
        var telephone = telephoneInput.val()
        var username = usernameInput.val()
        var img_captcha = imgCaptchaInput.val()
        var password1 = password1Input.val()
        var password2 = password2Input.val()
        var sms_captcha = smsCaptchaInput.val()

        myajax.post({
            'url': '/xsauth/register/',
            'data': {
                'telephone': telephone,
                'username': username,
                'img_captcha': img_captcha,
                'password1': password1,
                'password2': password2,
                'sms_captcha': sms_captcha
            },
            'success': function(result){
                if(result['code'] === 200){
                    window.location.reload()
                }
            }
        })
    })
};

// 根据查询字符串判断是否需要弹出登录框  该方法需要在“监听模态对话框显示与隐藏事件”之后
Auth.prototype.needAuth = function(){
    var self = this;
    //获取URL查询字符串参数值，可以抽取每个参数和参数值
    var queryString = function(){
        var q = location.search.substring(1);	//获取查询字符串
        var a = q.split("&");
        console.log(a);
        var o = {};
        for (var i = 0, len = a.length; i < len; i++){
            var n = a[i].indexOf("=");
            if (n == -1) continue;
            var v1 = a[i].substring(0, n);
            var v2 = a[i].substring(n + 1);
            o[v1] = unescape(v2);				//以名/值对的形式存储在对象中
        }
        return o;
    };
    var qs = queryString();
    if(qs.hasOwnProperty('next')){
        self.next = qs['next'];
        self.signIn.trigger('click');
    }
};

Auth.prototype.run = function(){
    this.listenShowHideEvent()
    this.listenSwitchEvent()
    this.listenSignInEvent()
    this.listenImgCaptchaEvent()
    this.listenSmsCaptchaEvent()
    this.listenSignUpEvent()
    this.needAuth()
};


$(function(){
    var auth = new Auth()
    auth.run()
});