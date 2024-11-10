<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

</head>
<body>
<header>
    <div class="header-top">
        <div class="top-container">
            <ul>
                <li class="active"><a href="/">小说网</a></li>
<%--                <li><a href="https://www.qdmm.com/">起点女生网</a></li>--%>
<%--                <i>|</i>--%>
<%--                <li><a href="http://chuangshi.qq.com/">创世中文网</a></li>--%>
<%--                <i>|</i>--%>
<%--                <li><a href="http://yunqi.qq.com/">云起书院</a></li>--%>
<%--                <i>|</i>--%>
                <li><a href="/">繁体版</a></li>
            </ul>
            <div class="auth">
                <c:if test="${user != null}">
                    <a href="/account/index/">${user.username}</a>
                    <c:if test="${user.is_staff == true || user.is_superuser == true}">
                        <a href="/cms/index/">后台管理</a>
                    </c:if>
                    <a href="/xsauth/logout/">退出</a>
                </c:if>
                <c:if test="${user == null}">
                    <a href="javascript:void(0);" class="sign-in">登录</a>
                    <a href="javascript:void(0);" class="sign-up">注册</a>
                </c:if>
            </div>
        </div>
    </div>
    <div class="header-middle">
        <div class="middle-container">
<%--            <div class="logo">--%>
<%--                <a href="/"></a>--%>
<%--            </div>--%>
<%--            <form action="/novel/search/">--%>
<%--                <input type="text" name="q" id="search-text" value="">--%>
<%--                <span class="search-btn iconfont icon-baseline-search-px"></span>--%>
<%--                <input type="submit" id="search-submit" hidden>--%>
<%--            </form>--%>
            <div class="my-bookrack">
                <a href="/account/my_collect/" target="_blank">
                    <i class="iconfont icon-bookrack"></i>
                    <span>我的书架</span>
                </a>
            </div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="bottom-container">
            <ul>
                <li class="first">
                    <i class="iconfont icon-list"></i>
                    <a href="#">
                        作品分类
                    </a>
                </li>
                <li class="nav-li"><a href="/whole/">全部作品</a></li>
                <li class="nav-li"><a href="/rank/">排行</a></li>
                <li class="nav-li"><a href="/whole?is_complete=1">完本</a></li>
                <li class="nav-li"><a href="/whole?is_free=1">免费</a></li>
                <c:if test="${user.is_author}">
                    <li class="nav-li"><a target='_blank' href="/account/index/">作家专区</a></li>
                </c:if>
                <c:if test="${!user.is_author}">
                    <li class="nav-li"><a target='_blank' href="/account/become_writer/">作家专区</a></li>
                </c:if>
                <li class="nav-li"><a target='_blank' href="https://www.yuewen.com/app.html#appqd">客户端</a></li>
<%--                <li class="game-phone">--%>
<%--                    <a target='_blank' href="http://game.qidian.com/">--%>
<%--                        <i class="iconfont icon-shoubing"></i>--%>
<%--                        手游--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="game-web">--%>
<%--                    <a target='_blank' href="http://sy.qidian.com/Home/Pc/Index/index">--%>
<%--                        <i class="iconfont icon-shubiao"></i>--%>
<%--                        页游--%>
<%--                    </a>--%>
<%--                </li>--%>
            </ul>
        </div>
    </div>
</header>
