<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>

<c:set var="title" value="我的书架" />

<%@include file="head.jsp"%>

<script src="/dist/js/account/collect.min.js"></script>
<style>
    .size-sm {
        font-size: 15px;
    }
    .collect-group {
        min-height: 150px;
    }
</style>
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
    <%@include file="header.jsp"%>
    <%@include file="aside.jsp"%>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>我的书架</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header">

                        </div>
                        <div class="box-body">
                            <div class="row collect-group">
                                <c:choose>
                                    <c:when test="${collected_novels != null and !empty collected_novels}">
                                        <c:forEach items="${collected_novels}" var="novel">
                                            <div class="base-novel-div col-md-2 text-center" data-novel-id="${novel.id}">
                                                <div class="thumbnail">
                                                    <a href="/detail/${novel.id}">
                                                        <img src="${novel.cover_url}" style="width: 150px;" class="img-thumbnail" alt="">
                                                    </a>
                                                    <div class="caption">
                                                        <h4>
                                                            <c:choose>
                                                                <c:when test="${fn:length(novel.name) > 6}">
                                                                    <a href="/detail/${novel.id}" class="text-danger size-sm">${func:truncate(novel.name,8)}</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="/detail/${novel.id}" class="text-danger">${novel.name}</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </h4>
                                                        <h5>${novel.category.name} · ${novel.author.username}</h5>
                                                        <p class="clearfix">
                                                            <a href="/detail/${novel.id}" class="btn btn-danger pull-left">继续阅读</a>
                                                            <button type="button" class="btn btn-warning collent-btn pull-right" data-collected="true" data-toggle="tooltip" data-placement="bottom" title="已收藏">
                                                                <span class="glyphicon glyphicon-star-empty"></span>
                                                            </button>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-offset-4 col-md-4 text-center">
                                            <div class="page-header">
                                                <h1>空空如也&nbsp;&nbsp;&nbsp;<a href="/"><small>去看看 >></small></a></h1>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="box-footer">

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <%@include file="footer.jsp"%>

    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

</body>
</html>
