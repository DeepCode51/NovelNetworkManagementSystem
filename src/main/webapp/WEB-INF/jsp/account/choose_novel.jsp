<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<%@include file="head.jsp"%>

<script src="/dist/ueditor/ueditor.config.js"></script>
<script src="/dist/ueditor/ueditor.all.min.js"></script>
<style>
    .media-left{
        padding-right: 30px;
    }
    .finish {
        color: #bebebe;
    }
</style>
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
    <%@include file="header.jsp"%>
    <%@include file="aside.jsp"%>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>${header_text}</h1>
        </section>

        <section class="content">

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <span  class="box-title">请选择小说</span>
                        </div>
                        <div class="box-body">
                            <table class="table">
                                <c:forEach items="${novels}" var="novel">
                                    <tr>
                                        <td class="col-md-8">
                                            <div class="media"  style="margin:10px 0;">
                                                <div class="media-left">
                                                    <a href="#">
                                                        <img style="width:100px;" class="media-object" src="${novel.cover_url}" alt="...">
                                                    </a>
                                                </div>
                                                <div class="media-body">
                                                    <h3 class="media-heading">
                                                        <div class="clearfix">
                                                            <span class="pull-left">${novel.name}</span>
                                                            <c:choose>
                                                                <c:when test="${operate == 1}">
                                                                    <c:choose>
                                                                        <c:when test="${novel.is_complete}">
                                                                            <span class="pull-right finish">已完结</span>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <a href="/account/write_chapter?novel_id=${novel.id}" class="btn btn-warning btn-md pull-right">更新小说</a>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="/account/chapter_list?novel_id=${novel.id}" class="btn btn-warning btn-md pull-right">查看章节</a>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </h3>
                                                    <div class="row">
                                                        <h5 class="col-md-2"><i class="iconfont icon-fenlei"></i> ${novel.category.name}</h5>
                                                        <h5 class="col-md-3"><i class="iconfont icon-zhangjiechuti"></i> 当前共${novel.chapters_num}章</h5>
                                                        <h5 class="col-md-3"><i class="iconfont icon-shuzi"></i> 当前共${func:wordsNumFilter(novel.words_num)}万字</h5>
                                                    </div>
                                                    <span>${func:truncate(novel.profile,100)}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="col-md-4"></td>
                                    </tr>
                                </c:forEach>
                            </table>
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
