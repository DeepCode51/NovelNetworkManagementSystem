<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<c:set var="title" value="小说网|排行榜" scope="request" />

<%@include file="base/head.jsp"%>

<link rel="stylesheet" href="/dist/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/dist/css/novel/rank.min.css">
<script src="/dist/bootstrap/js/bootstrap.min.js"></script>
<style>
    .input-group-addon {
        padding: 0;

    }
    .input-group {
        display: block;
    }
</style>

<%@include file="base/header.jsp"%>

<div class="main">
    <div class="wrapper">
        <!-- 排行榜 -->
        <div class="rank-wrapper">
            <!-- 筛选条件 -->
            <div class="rank-header">
                <%--分类--%>
                <ul>
                    <li class="condition-name">类型:</li>
                    <li ${category_id eq 0 or category_id eq null ? "class='active'" : ""}>
                        <a href="/rank?${category_id_query}">全部</a>
                    </li>
                    <c:forEach items="${categories}" var="category" varStatus="st">
                        <li ${category_id eq category.id ? "class='active'" : ""} >
                            <a href="/rank?category_id=${category.id}&${category_id_query}">${category.name}</a>
                        </li>
                    </c:forEach>
                    <li><a href="#">轻小说</a></li>
                </ul>
            </div>
            <div class="rank-body">
                <%--该页所有小说--%>
                <div class="novel-media">
                    <ul>
                        <c:forEach items="${novels}" var="novel">
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
                                            ${func:profile_truncate(novel.profile,50)}
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
                <%--分页按钮--%>
                <div class="pagination-group text-center">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:choose>
                                <c:when test="${has_previous}">
                                    <li>
                                        <a href="/rank?p=${previous_page_number}&${url_query}" aria-label="Previous">
                                            <span aria-hidden="true">&lt;</span>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="disabled">
                                        <a href="javascript:void(0)" aria-label="Previous" class="disabled">
                                            <span aria-hidden="true">&lt;</span>
                                        </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                            <c:if test="${left_has_more}">
                                <li><a href="/rank?p=1&${url_query}">1</a></li>
                                <li class="disabled"><a href="javascript:void(0)">...</a></li>
                            </c:if>
                            <c:forEach items="${left_pages}" var="page">
                                <li><a href="/rank?p=${page}&${url_query}">${page}</a></li>
                            </c:forEach>
                            <li class="active"><a href="javascript:void(0)">${current_page}</a></li>
                            <c:forEach items="${right_pages}" var="page">
                                <li><a href="/rank?p=${page}&${url_query}">${page}</a></li>
                            </c:forEach>
                            <c:if test="${right_has_more}">
                                <li class="disabled"><a href="javascript:void(0)">...</a></li>
                                <li><a href="/rank?p=${num_pages}&${url_query}">${num_pages}</a></li>
                            </c:if>
                            <c:choose>
                                <c:when test="${has_next}">
                                    <li>
                                        <a href="/rank?p=${next_page_number}&${url_query}" aria-label="Next">
                                            <span aria-hidden="true">&gt;</span>
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="disabled">
                                        <a href="javascript:void(0)" aria-label="Next">
                                            <span aria-hidden="true">&gt;</span>
                                        </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- 本周强推 -->
        <div class="recommend-wrapper">
            <div class="recommend-header">
                <h2>本周强推</h2>
            </div>
            <ul>
                <c:forEach items="${recommend_novels}" var="novel">
                    <li>
                        <span class="novel-cate"><a href="#">「${novel.category.name}」</a></span>
                        <span class="novel-name"><a href="#">${func:truncate(novel.name,8)}</a></span>
                        <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<%@include file="base/footer.jsp"%>
<%@include file="base/auth.jsp"%>
</body>
</html>