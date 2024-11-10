<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>

<c:set var="title" value="个人中心|起点中文网" />

<%@include file="head.jsp"%>

<script src="/dist/js/account/collect.min.js"></script>
<style>
    .size-sm {
        font-size: 15px;
    }
    .base-novel-div {
        min-width:153px;
    }
    .thumbnail {
        background: #efffff;
        min-width:153px;
    }
    .finish {
        font-size: 16px;
        padding: 5px 0;
        color: #aaaaaa;
    }
    .works-group, .read-group, .collect-group {
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
            <h1>个人首页</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <%--我的作品--%>
                    <c:if test="${user.is_author == true}">
                        <div class="box box-success">
                            <div class="box-header clearfix">
                                <h4 class="pull-left">我的作品</h4>
                                <c:if test="${!empty my_works}">
                                    <a href="/account/novel_list/" class="btn btn-default pull-right">查看更多</a>
                                </c:if>
                            </div>
                            <div class="box-body">
                                <div class="row works-group">
                                    <c:choose>
                                        <c:when test="${!empty my_works}">
                                            <c:forEach items="${my_works}" var="novel">
                                                <div class="base-novel-div col-xs-6 col-sm-4 col-md-2 text-center" data-novel-id="${novel.id}">
                                                    <div class="thumbnail">
                                                        <a href="/detail/${novel.id}">
                                                            <img style="width:143px;height:187px;" class="img-thumbnail" src="${novel.cover_url}" alt="">
                                                        </a>
                                                        <div class="caption">
                                                            <h4>
                                                                <c:if test="${fn:length(novel.name) > 6}">
                                                                    <a href="/detail/${novel.id}" class="text-danger size-sm">${func:truncate(novel.name,8)}</a>
                                                                </c:if>
                                                                <c:if test="${fn:length(novel.name) <= 6}">
                                                                    <a href="/detail/${novel.id}" class="text-danger">${novel.name}</a>
                                                                </c:if>
                                                            </h4>
                                                            <c:choose>
                                                                <c:when test="${novel.is_complete == true}">
                                                                    <h5>${novel.category.name} · 共${novel.chapters_num}章</h5>
                                                                    <div class="clearfix">
                                                                        <span class="pull-left finish">已完结</span>
                                                                        <a href="/account/chapter_list?novel_id=${novel.id}" class="btn btn-warning pull-right">查看</a>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <h5>${novel.category.name} · 更新至${novel.chapters_num}<c:if test="${novel.chapters_num < 1000}">章</c:if></h5>
                                                                    <div class="clearfix">
                                                                        <a href="/account/write_chapter?novel_id=${novel.id}" class="btn btn-success pull-left">更新</a>
                                                                        <a href="/account/chapter_list?novel_id=${novel.id}" class="btn btn-warning pull-right">查看</a>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-md-offset-4 col-md-4 text-center">
                                                <div class="page-header">
                                                    <h1>暂无作品&nbsp;&nbsp;&nbsp;<a href="#"><small>去发布 >></small></a></h1>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="box-footer"></div>
                        </div>
                    </c:if>
                    <%--最近阅读--%>
                    <div class="box box-success">
                        <div class="box-header clearfix">
                            <h4 class="pull-left">最近阅读</h4>
                            <c:if test="${readed_novels != null}">
                                <a href="/account/recently_read/" class="btn btn-default pull-right">查看更多</a>
                            </c:if>
                        </div>
                        <div class="box-body">
                            <div class="row read-group">
                                <c:choose>
                                    <c:when test="${readed_novels != null and !empty readed_novels}">
                                        <c:forEach items="${readed_novels}" var="novel_map">
                                            <div class="base-novel-div col-xs-6 col-sm-4 col-md-2 text-center" data-novel-id="${novel_map.novel.id}">
                                                <div class="thumbnail">
                                                    <a href="/detail/${novel_map.novel.id}">
                                                        <img style="width:150px;" class="img-thumbnail" src="${novel_map.novel.cover_url}" alt="">
                                                    </a>
                                                    <div class="caption">
                                                        <h4>
                                                            <c:choose>
                                                                <c:when test="${fn:length(novel_map.novel.name) > 6}">
                                                                    <a href="/detail/${novel_map.novel.id}" class="text-danger size-sm">${func:truncate(novel_map.novel.name,8)}</a>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="/detail/${novel_map.novel.id}" class="text-danger">${novel_map.novel.name}</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </h4>
                                                        <h5>${novel_map.novel.category.name} · ${novel_map.novel.author.username}</h5>
                                                        <p class="clearfix">
                                                            <a href="" class="btn btn-danger pull-left">继续阅读</a>
                                                            <c:choose>
                                                                <c:when test="${novel_map.is_collect}">
                                                                    <button type="button" class="btn btn-warning collent-btn pull-right" data-collected="true" data-toggle="tooltip" data-placement="bottom" title="已收藏">
                                                                        <span class="glyphicon glyphicon-star-empty"></span>
                                                                    </button>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <button type="button" class="btn btn-default collent-btn pull-right" data-collected="false" data-toggle="tooltip" data-placement="bottom" title="点击收藏">
                                                                        <span class="glyphicon glyphicon-star-empty"></span>
                                                                    </button>
                                                                </c:otherwise>
                                                            </c:choose>
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
                        <div class="box-footer"></div>
                    </div>
                    <%--收藏--%>
                    <div class="box box-success">
                        <div class="box-header clearfix">
                            <h4 class="pull-left">我的书架</h4>
                            <c:if test="${!empty collected_novels}">
                                <a href="/account/my_collect/" class="btn btn-default pull-right">查看更多</a>
                            </c:if>
                        </div>
                        <div class="box-body">
                            <div class="row collect-group">
                                <c:choose>
                                    <c:when test="${!empty collected_novels}">
                                        <%--{% for novel in collected_novels|slice:'0:6' %}--%>
                                        <c:forEach items="${collected_novels}" var="novel">
                                            <div class="base-novel-div col-xs-6 col-sm-4 col-md-2 text-center" data-novel-id="${novel.id}">
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
                        <div class="box-footer"></div>
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
