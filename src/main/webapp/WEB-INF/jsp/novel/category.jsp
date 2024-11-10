<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--<meta name="csrf_token" comtent="{{ csrf_token }}">--%>
    <title>${category_cn_name}首页</title>
    <link rel="icon" type="image/x-ico" href="/dist/images/logo.ico" />
    <link rel="stylesheet" href="/dist/css/novel/index_category.min.css">
    <link rel="stylesheet" href="/dist/css/common/auth.min.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1538834_3o3u75p68n8.css">
    <script src="/dist/js/jquery-3.4.1.min.js"></script>
    <script src="/dist/js/myajax.min.js"></script>
    <script src="/dist/js/xfzalert.min.js"></script>
    <script src="/dist/js/message.min.js"></script>
    <script src="/dist/js/auth.min.js"></script>
    <script src="/dist/js/search.min.js"></script>
</head>
<body>
<header>
    <div class="header-top">
        <%@include file="base/black_header.jsp" %>
    </div>
    <div class="header-middle ${category_en_name}">
        <div class="middle-container">
            <div class="logo">
                <a href="#"></a>
            </div>
            <form action="/search/">
                <%--{% csrf_token %}--%>
                <input type="text" name="q" id="search-text">
                <span class="search-btn iconfont icon-baseline-search-px"></span>
                <input type="submit" id="search-submit" hidden>
            </form>
        </div>
    </div>
</header>
<div class="main">
    <div class="wrapper">
        <!-- 第一部分 -->
        <!-- 第二部分 推荐 新书 -->
        <div class="recommend-wrapper">
            <div class="left">
                <!-- 标签 -->
                <div class="category-tag">
                    <ul>
                        <c:forEach items="${tags}" var="tag">
                            <li><a href="#">${tag.name}</a></li>
                        </c:forEach>
                        <b>|</b>
                        <li><a href="/rank?category_id=${category.id}">${category.name}排行</a></li>
                        <li><a href="/whole?category_id=${category.id}&is_complete=1">${category.name}完本</a></li>
                        <li><a href="/whole?category_id=${category.id}&is_free=1">${category.name}免费</a></li>
                    </ul>
                </div>
                <div class="body">
                    <!-- 本周强推 -->
                    <div class="recommend-left">
                        <div class="left-header">
                            <h3>本周强推</h3>
                        </div>
                        <ul>
                            <c:forEach items="${recommend_novels_6_15}" var="novel">
                                <li>
                                    <span class="novel-name"><a href="/detail/${novel.id}" target="_blank">${func:truncate(novel.name,9)}</a></span>
                                    <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <!-- 编辑推荐 -->
                    <div class="recommend-body">
                        <!-- 上 -->
                        <div class="novel-media">
                            <ul>
                                <c:forEach items="${recommend_novels_1_5}" var="novel">
                                    <li>
                                        <div class="novel-img">
                                            <a href="/detail/${novel.id}" target="_blank">
                                                <img src="${novel.cover_url}" alt="">
                                            </a>
                                        </div>
                                        <div class="novel-info">
                                            <div class="novel-title">
                                                <a href="/detail/${novel.id}" target="_blank">${novel.name}</a>
                                            </div>
                                            <div class="novel-profile">
                                                ${func:profile_truncate(novel.profile,25)}
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <!-- 下 -->
                        <div class="novel-text">
                            <div class="hint">
                                <span>新书精选</span>
                                <cite></cite>
                            </div>
                            <ul>
                                <li>
                                    <span class="novel-name">科技巫师</span><i>·</i><span class="novel-profile">在巫师世界自造核武器</span>
                                </li>
                                <li>
                                    <span class="novel-name">我有一个庇护所</span><i>·</i><span class="novel-profile">灰雾世界唯一的秩序</span>
                                </li>
                                <li>
                                    <span class="novel-name">绝境长城上的王者</span><i>·</i><span class="novel-profile">穿越冰与火，却被守夜人抓了壮丁</span>
                                </li>
                                <li>
                                    <span class="novel-name">哈利波特之血猎者</span><i>·</i><span class="novel-profile">布劳德重生到了哈利波特的世界</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 排行榜 -->
            <div class="rank">
                <div class="rank-header">
                    <h2>${category_ch_name}·排行榜</h2>
                </div>
                <c:if test="${rank_novels != null}">
                    <ul>
                        <li class="unfold">
                            <div class="novel-info-box">
                                <span class="novel-1">NO.1</span>
                                <span class="novel-name">
                                            <a href="/detail/${rank_novels_1.id}" target="_blank">${rank_novels_1.name}</a>
                                        </span>
                                <p class="novel-author">
                                    <a href="/${category_en_name}">${rank_novels_1.category.name}</a><i>·</i><a href="#">${rank_novels_1.author.pen_name}</a>
                                </p>
                            </div>
                            <div class="novel-img-box">
                                <a href="/detail/${rank_novels_1.id}">
                                    <img src="${rank_novels_1.cover_url}" alt="">
                                </a>
                            </div>
                        </li>
                        <c:forEach items="${rank_novels}" var="novel" varStatus="st">
                            <li>
                                <div class="num-box">
                                    <%--{% if forloop == 1 %}--%>
                                    <c:choose>
                                        <c:when test="${st.count == 1}">
                                            <span class="num-2">2</span>
                                        </c:when>
                                        <c:when test="${st.count == 2}">
                                            <span class="num-3">3</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span>${st.count + 1}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="novel-box">
                                    <span class="novel-name"><a href="/detail/${novel.id}">${novel.name}</a></span>
                                    <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
        <!-- 第三部分 新书推荐 -->
        <div class="new-novel">
            <div class="new-left">
                <div class="rank-header">
                    <h2>${category_cn_name}新书</h2>
                </div>
                <div class="novel-media">
                    <div class="line line1"></div>
                    <div class="line line2"></div>
                    <ul>
                        <c:forEach items="${new_novels_11_19}" var="novel">
                            <li>
                                <div class="novel-img">
                                    <a href="/detail/${novel.id}">
                                        <img src="${novel.cover_url}" alt="">
                                    </a>
                                </div>
                                <div class="novel-info">
                                    <div class="novel-title">
                                        <a href="/detail/${novel.id}" target="_blank">${novel.name}</a>
                                    </div>
                                    <div class="novel-profile">
                                        ${func:profile_truncate(novel.profile,45)}
                                    </div>
                                    <div class="novel-author">
                                        <a href="#" class="author-name"><span>${novel.author.pen_name}</span></a>
                                        <span class="nav-number">${func:wordsNumFilter(novel.words_num)}万字</span>
                                        <span class="nav-tag">${novel.tag.name}</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="new-rank">
                <div class="rank-header">
                    <h2>新书榜</h2>
                </div>
                <c:if test="${new_novels_2_10 != null}">
                    <ul>
                        <li class="unfold">
                            <div class="novel-info-box">
                                <span class="novel-1">NO.1</span>
                                <span class="novel-name">
                                        <a href="/detail/${new_novels_1.id}" target="_blank">${new_novels_1.name}</a>
                                    </span>
                                <p class="novel-author">
                                    <a href="#">${new_novels_1.category.name}</a><i>·</i><a href="#">${new_novels_1.author.pen_name}</a>
                                </p>
                            </div>
                            <div class="novel-img-box">
                                <a href="/detail/${new_novels_1.id}" target="_blank">
                                    <img src="${new_novels_1.cover_url}" alt="">
                                </a>
                            </div>
                        </li>
                        <c:forEach items="${new_novels_2_10}" var="novel" varStatus="st">
                            <li>
                                <div class="num-box">
                                    <c:choose>
                                        <c:when test="${st.count == 1}">
                                            <span class="num-2">2</span>
                                        </c:when>
                                        <c:when test="${st.count == 2}">
                                            <span class="num-3">3</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="num-${st.count + 1}">${st.count + 1}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="novel-box">
                                    <span class="novel-name"><a href="/detail/${novel.id}" target="_blank">${func:truncate(novel.name,10)}</a></span>
                                    <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%@include file="base/footer.jsp"%>
<%@include file="base/auth.jsp"%>
</body>
</html>