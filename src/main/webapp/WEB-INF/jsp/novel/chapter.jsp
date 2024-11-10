<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/func.tld" prefix="func"%>

<%@include file="base/head.jsp"%>
<%--<meta name="csrf_token" comtent="{{ csrf_token }}">--%>
<c:set var="title" value="${chapter.title}" scope="request" />

    <link rel="stylesheet" href="/dist/css/novel/chapter.min.css">
    <script src="/dist/js/chapter.min.js"></script>
</head>
<body oncontextmenu='return false' ondragstart='return false' onselectstart ='return false' onselect='document.selection.empty()' oncopy='document.selection.empty()' onbeforecopy='return false' onmouseup='document.selection.empty()'>
<header>
    <div>
        <ul>
            <li>
                <a href="/">起点中文网</a>
                <div class="dropdown">
                    <a href="https://www.qdmm.com/">起点女生网</a>
                    <a href="http://chuangshi.qq.com/">创世中文网</a>
                    <a href="http://yunqi.qq.com/">云起书院</a>
                </div>
            </li>
            <li>
                <a href="#">手机阅读</a>
            </li>
            <li>
                <a href="/account/recently_read/">最近阅读</a>
            </li>
            <li>
                <a href="/">快速导航</a>
                <div class="dropdown">
                    <a target="_blank" href="/whole/">全部作品</a>
                    <%
                        // 获取分类名称1-8
                        String[][] all_category_name = (String[][]) request.getAttribute("all_category_name");
                        String[][] all_category_name_1_8 = new String[8][2];
                        for(int i = 0; i < 8; i++){
                            all_category_name_1_8[i] = all_category_name[i];
                        }
                        request.setAttribute("all_category_name_1_8",all_category_name_1_8);
                    %>
                    <c:forEach items="${all_category_name_1_8}" var="category" varStatus="st">
                        <a target="_blank" href="/${category[0]}">${category[1]}</a>
                    </c:forEach>
                </div>
            </li>
        </ul>
        <div class="my-book">
            <a href="/account/my_collect/">
                <i class="iconfont icon-bookrack"></i>
                <span>我的书架</span>
            </a>
        </div>
        <div class="auth-group">
            <c:if test="${user != null}">
                <a href="/account/index/">${user.username}</a>
                <c:if test="${user.is_staff == true}">
                    <a href="/account/index/">后台管理</a>
                </c:if>
                <a href="/xsauth/logout/">退出</a>
            </c:if>
            <c:if test="${user == null}">
                <a href="javascript:void(0);" class="sign-in">登录</a>
                <a href="javascript:void(0);" class="sign-up">注册</a>
            </c:if>
        </div>
        <div class="search">
            <form action="/search/">
                <%--{% csrf_token %}--%>
                <input type="text" name="q" value="${query}" id="text" class="text" placeholder="你的灵兽看起来很好吃">
                <label class="submit-btn iconfont icon-baseline-search-px" for="submit"></label>
                <input type="submit" id="submit" hidden>
            </form>
        </div>
    </div>
</header>
<div class="main">
    <div class="wrapper">
        <!-- 路径 -->
        <div class="path-wrapper">
            <div class="path">
                <a href="/">首页</a>
                <i>></i>
                <a href="/index_category/${category_en_name}/">${chapter.novel.category.name}</a>
                <i>></i>
                <a href="javascript:void(0)">${chapter.novel.name}</a>
            </div>
        </div>
        <!-- body -->
        <div class="body-wrapper">
            <!-- 左侧边栏 -->
            <div class="left-sidebar">
                <ul>
                    <li>
                        <a href="/detail/${chapter.novel.id}">
                            <i class="iconfont icon-list"></i>
                            <span>目录</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-settings"></i>
                            <span>设置</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-shouji"></i>
                            <span>手机</span>
                        </a>
                    </li>
                    <li>
                        <c:if test="${is_collect == true}">
                            <span class="collected">已在书架</span>
                        </c:if>
                        <c:if test="${is_collect == false}">
                            <a href="javascript:void(0);" class="collect-btn">
                                <i class="iconfont icon-books"></i>
                                <span>书架</span>
                            </a>
                        </c:if>
                    </li>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-fanhui"></i>
                            <span>书页</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-youxi"></i>
                            <span>游戏</span>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- 右侧边栏 -->
            <div class="right-sidebar">
                <ul>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-dashang"></i>
                            <span>打赏</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-navicon-tp"></i>
                            <span>投票</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="iconfont icon-huidaodingbu"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- 封面 -->
            <c:if test="${chapter.number == 1}">
                <div class="novel-cover">
                    <div class="novel-cover-core">
                        <!-- 图片 -->
                        <div class="novel-img">
                            <img src="${chapter.novel.cover_url}" alt="">
                        </div>
                        <!-- 书名 -->
                        <div class="novel-name">
                            <h1>${chapter.novel.name}</h1>
                        </div>
                        <!-- 作者 -->
                        <div class="novel-author">
                            ${chapter.novel.author.pen_name} 著
                        </div>
                        <!-- 图书信息 -->
                        <div class="novel-info-wrapper">
                            <div class="novel-info">
                                <!-- 类型 -->
                                <div class="novel-category">
                                    <span class="info category">${chapter.novel.category.name}</span>
                                    <span class="hint category-hint">类型</span>
                                </div>
                                <!-- 上架时间 -->
                                <div class="novel-pubdate">
                                    <span class="info pubdate">${func:formatDate(chapter.novel.pub_date,'yyyy-MM-dd')}</span>
                                    <span class="hint pubdate-hint">上架</span>
                                </div>
                                <!-- 字数 -->
                                <div class="novel-num-words">
                                    <span class="info num-words">${func:wordsNumFilter(chapter.novel.words_num)}万</span>
                                    <span class="hint num-words-hint">连载（字） </span>
                                </div>
                            </div>
                        </div>
                        <!-- 备注 -->
                        <div class="remark">
                            <h4>与<span>1.88万</span>位书友共同开启《儒雅随和的我不是魔头》的玄幻之旅</h4>
                        </div>
                        <!-- 其他 -->
                        <div class="other-wrapper">
                            <div class="other">
                                <span class="zhishi">「执事」wosjjhg</span>
                                <span class="dizi">「弟子」Iw再入江湖</span>
                            </div>
                        </div>
                        <!-- 声明 -->
                        <div class="statement">
                            本书由起点中文网进行电子制作与发行
                        </div>
                        <!-- 版权 -->
                        <div class="copyright">
                            ©版权所有 侵权必究
                        </div>
                    </div>
                </div>
            </c:if>
            <!-- 内容 -->
            <div class="novel-content">
                <span id="novel-id" data-novel-id="${chapter.novel.id}"></span>
                <!-- 头部 -->
                <div class="header">
                    <h2 class="chapter-title">
                        <span class="title">${chapter.title}</span>
                    </h2>
                    <div class="chapter-info">
                        <div class="novel-name">
                            <a href="/detail/${chapter.novel.id}">
                                <i class="iconfont icon-book"></i>
                                ${chapter.novel.name}
                            </a>
                        </div>
                        <div class="novel-author">
                            <a href="#">
                                <i class="iconfont icon-pen"></i>
                                ${chapter.novel.author.pen_name}
                            </a>
                        </div>
                        <div class="novel-num-words">
                            <i class="iconfont icon-shuzi"></i>
                            ${chapter.words_num}字
                        </div>
                        <div class="novel-pubtime">
                            <i class="iconfont icon-time"></i>
                            ${func:formatDate(chapter.pub_date,'yyyy-MM-dd HH:mm')}
                        </div>
                    </div>
                </div>
                <!-- 文字 -->
                <div class="content">
                    ${chapter.content}
                </div>
            </div>
            <!-- 翻页按钮 -->
            <div class="novel-switch">
                <div class="switch-btn previous">
                    <c:if test="${previous_id != null and previous_id != ''}">
                        <a href="/chapter/${previous_id}">
                    </c:if>
                    <c:if test="${previous_id == null or previous_id == ''}">
                        <a href="javascript:void(0);" class="disabled">
                    </c:if>
                        <span>上一章</span>
                    </a>
                </div>
                <div class="switch-btn catalogue">
                    <a href="/detail/${chapter.novel.id}" class="border-a">
                        <span>目录</span>
                    </a>
                </div>
                <div class="switch-btn next">
                    <c:if test="${next_id != null and next_id != ''}">
                        <a href="/chapter/${next_id}">
                    </c:if>
                    <c:if test="${next_id == null or next_id == ''}">
                        <a href="javascript:void(0);" class="disabled">
                    </c:if>
                        <span>下一章</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<footer></footer>

<%@include file="base/auth.jsp"%>
</body>
</html>