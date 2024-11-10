<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>

<c:set var="title" value="404页面不存在" scope="request" />

<%@include file="../novel/base/head.jsp"%>
<link rel="stylesheet" href="/dist/css/error/404.min.css" />
<%@include file="../novel/base/header.jsp"%>

<div class="main">
    <div class="wrapper">
        <!-- 404 -->
        <div class="content-wrapper">
            <div class="hint">
                <p class="p1">404</p>
                <p class="p2">您访问的页面跑到火星上去了</p>
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
                        <span class="novel-name"><a href="#">${func:truncate(novel.name,7)}</a></span>
                        <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<%@include file="../novel/base/footer.jsp"%>
<%@include file="../novel/base/auth.jsp"%>
</body>
</html>
