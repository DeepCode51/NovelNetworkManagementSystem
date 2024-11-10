<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*,com.ykjzone.util.Filters"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/func.tld" prefix="func"%>

<c:set var="title" value="小说网|首页" scope="request" />

<%@include file="base/head.jsp"%>

<link rel="stylesheet" href="/dist/css/novel/detail.min.css">
<script src="/dist/js/detail.min.js"></script>

<%@include file="base/black_header.jsp"%>


<div class="main">
    <div class="background"></div>
    <div class="path">
        <div class="path-wrapper">
            <div class="">
                <a href="#">首页</a>
                <i>></i>
                <a href="#">${novel.category.name}</a>
                <i>></i>
                <a href="#">${novel.name}</a>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="body-wrapper">
            <div class="info-wrapper">
                <div class="novel-img">
                    <img src="${novel.cover_url}" alt="">
                </div>
                <div class="novel-info">
                    <div class="novel-name">
                        <h1>${novel.name}</h1>
                        <span class="author-name">${novel.author.pen_name} 著</span>
                    </div>
                    <div class="novel-tag">
                        <c:if test="${novel.is_complete == true}">
                            <span>完本</span>
                        </c:if>
                        <c:if test="${novel.is_complete == false}">
                            <span>连载</span>
                        </c:if>
                        <span>签约</span>
                        <c:if test="${novel.price > 0}">
                            <span>付费</span>
                        </c:if>
                        <c:if test="${novel.price == 0}">
                            <span>免费</span>
                        </c:if>
                        <span>${novel.category.name}</span>
                        <span>${novel.tag.name}</span>
                    </div>
                    <div class="novel-remark">
                        【起点仙侠神话征文第一期】参赛作品
                    </div>
                    <div class="novel-number">
                        <div class="num-words"><span>${func:wordsNumFilter(novel.words_num)}</span>万字</div>
                        <div class="num-recommend"><span>7.78</span>万总推荐</div>
                        <div class="num-recommend-week"><span>1238</span>周推荐</div>
                    </div>
                    <div class="novel-btn">
                        <a href="/chapter/${chapters[0].id}">免费试读</a>
                        <c:if test="${is_collect == true}">
                            <a href="javascript:void(0)">已收藏</a>
                        </c:if>
                        <c:if test="${is_collect == false}">
                            <a class="collect-btn" href="javascript:void(0)" data-novel-id="${novel.id}">加入书架</a>
                        </c:if>
                        <%--<a href="">投推荐票</a>--%>
<%--                        <a href="https://www.yuewen.com/app.html#appqd" target="_blank">手机App阅读</a>/--%>
                    </div>
                </div>
            </div>
            <div class="detail-wrapper">
                <!-- 切换标签 -->
                <ul class="switch">
                    <li class="profile-tag">作品信息</li>
                    <li class="catalogue-tag">目录<span class="small-text">(${novel.chapters_num}章)</span></li>
                </ul>
                <!-- 作品信息 -->
                <div class="profile">
                    <%--{# 左 #}--%>
                    <div class="profile-left">
                        <!-- 简介 -->
                        <div class="profile-text">
                            ${func:htmlRemoveTag(novel.profile)}
                        </div>
                        <!-- 标签/动态/更新 -->
                        <div class="profile-center">
                            <!-- 作者自定义标签 -->
                            <div class="">
                                <div class="left-title">作者自定义标签</div>
                                <div class="right-content"><span>洪荒流</span></div>
                            </div>
                            <!-- 作者自定义标签 -->
                            <div class="">
                                <div class="left-title">荣誉动态</div>
                                <div class="right-content">2019-11-18 累积获得三万个收藏</div>
                            </div>
                            <!-- 作者自定义标签 -->
                            <div class="">
                                <div class="left-title">最近更新</div>
                                <div class="right-content">
                                    ${recent_title}
                                    &nbsp;&nbsp;
                                    ${recent_date}</div>
                            </div>
                        </div>
                        <!-- 二维码 -->
<%--                        <div class="qr">--%>
<%--                            <div class="qr-group">--%>
<%--                                <div class="qr-img">--%>
<%--                                    <img src="https://qidian.qpic.cn/qidian_common/349573/652fa50e86cbf18faa086a44d8c62c1e/0" alt="">--%>
<%--                                </div>--%>
<%--                                <span class="hint">--%>
<%--                                    下载「起点读书」 获取更多内容--%>
<%--                                </span>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                    <%--右--%>
                    <div class="profile-right">
                        <!-- 作者信息 -->
                        <div class="author-info">
                            <!-- 头像 -->
                            <div class="avatar-group">
                                <div class="avatar-img">
                                    <img src="https://facepic.qidian.com/qd_face/349573/a429386960/0" alt="">
                                </div>
                                <div class="author-name">${novel.author.pen_name}</div>
                            </div>
                            <!-- 头像 -->
                            <div class="info-group">
                                <!-- 作品总数 -->
                                <div>
                                    <div class="div-img works">
                                    </div>
                                    <div class="div-title">
                                        作品总数
                                    </div>
                                    <div class="div-num">
                                        ${novel.words_num}
                                    </div>
                                </div>
                                <!-- 累计字数 -->
                                <div>
                                    <div class="div-img num-words">
                                    </div>
                                    <div class="div-title">
                                        累计字数
                                    </div>
                                    <div class="div-num">
                                        ${func:wordsNumFilter(novel.words_num)}万
                                    </div>
                                </div>
                                <!-- 创作天数 -->
                                <div>
                                    <div class="div-img days">
                                    </div>
                                    <div class="div-title">
                                        创作天数
                                    </div>
                                    <div class="div-num">
                                        54
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 当前分类 强推 -->
                        <div class="recommend">
                            <h3>本周强推·${novel.category.name}</h3>
                            <ul>
                                <c:forEach items="${recommend_novels}" var="novel" varStatus="st">
                                    <li>
                                        <a href="/detail/${novel.id}">${novel.name}</a>
                                        <span>${novel.author.pen_name}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- 目录 -->
                <div class="catalogue">
                    <!-- 头部 -->
                    <div class="catalogue-header">
                        <h3>正文卷·共${novel.chapters_num}章</h3>
                        <span class="pay-type">免费</span>
                        <span class="num-words">本卷共${func:wordsNumFilter(novel.words_num)}万字</span>
                        <span class="read-by-reel">
                            <i class="iconfont icon-text-page-"></i>
                            分卷阅读
                        </span>
                    </div>
                    <!-- 目录 -->
                    <ul>
                        <c:forEach items="${chapters}" var="chapter" varStatus="st">
                            <li>
                                <a href="/chapter/${chapter.id}">
                                    ${chapter.title}
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="base/footer.jsp"%>
<%@include file="base/auth.jsp"%>
</body>
</html>