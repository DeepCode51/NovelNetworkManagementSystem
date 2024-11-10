<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<!-- 模态对话框 -->
<div class="mask-wrapper">
    <div class="auth-wrapper">
        <div class="close-wrapper">
            <span class="close-btn icon-baseline-close-px iconfont"></span>
        </div>
        <div class="auth-inner-wrapper">
            <div class="scroll-wrapper">
                <!-- 登录面板 -->
                <div class="signin-group auth-group">
                    <div class="top-group">
                        <div class="title">请登录</div>
                        <a class="switch" href="javascript:;">立即注册》</a>
                    </div>
                    <!-- 表单 -->
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" class="form-control" name="telephone" placeholder="请输入手机号码">
                        </div>
                        <div class="input-group">
                            <input type="password" class="form-control" name="password" placeholder="请输入密码">
                        </div>
                        <div class="input-group">
                            <label class="remember-label">
                                <input type="checkbox" name="remember" value="1">
                                记住我
                            </label>
                        </div>
                        <div class="input-group">
                            <input class="submit-btn" type="submit" value="立即登录">
                        </div>
                    </div>
                </div>
                <!-- 注册面板 -->
                <div class="signup-group auth-group">
                    <div class="top-group">
                        <div class="title">请注册</div>
                        <a class="switch" href="javascript:;">《立即登录</a>
                    </div>
                    <!-- 表单 -->
                    <div class="form-group">
                        <div class="input-group">
                            <input type="text" class="form-control" name="telephone" placeholder="请输入手机号码">
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                        </div>
                        <div class="input-group">
                            <div class="short-input-group">
                                <input type="text" class="form-control"  name="img_captcha" placeholder="图形验证码">
                            </div>
                            <div class="input-group-addon">
                                <img src={% url 'xsauth:img_captcha' %} class="img-captcha" alt="" title="点击切换验证码">
                            </div>
                        </div>
                        <div class="input-group">
                            <input type="password" class="form-control" name="password1" placeholder="请输入密码">
                        </div>
                        <div class="input-group">
                            <input type="password" class="form-control" name="password2" placeholder="请输入重复密码">
                        </div>
                        <!-- 短信验证 -->
                        <div class="input-group">
                            <div class="short-input-group">
                                <input type="text" class="form-control" name="sms_captcha" placeholder="短信验证码">
                            </div>
                            <div class="input-group-addon">
                                <span class="sms-captcha-btn">发送验证码</span>
                            </div>
                        </div>
                        <div class="input-group">
                            <input class="submit-btn" type="submit" value="立即注册">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>