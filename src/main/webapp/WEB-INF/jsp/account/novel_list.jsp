<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="func" uri="/WEB-INF/func.tld" %>


<c:set var="title" value="我的作品" />

<%@include file="head.jsp"%>

<link rel="stylesheet" href="/dist/adminLTE/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<script src="/dist/adminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="/dist/adminLTE/bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<script src="/dist/js/account/novel_list.min.js"></script>
<style>
    .dropdown-menu {
        min-width: 0;
    }
    .search-btn {
        margin-left: 20px;
    }
</style>
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
    <%@include file="header.jsp"%>
    <%@include file="aside.jsp"%>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>我的作品</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <div class="box-header">
                            <%--搜索条件--%>
                            <form action="" method="get" class="form-inline">
                                <%--{% csrf_token %}--%>
                                <div class="form-group left-group">
                                    <label>时间：</label>
                                    <input type="text" name="start" id="start-picker" placeholder="起始时间" class="form-control" value="${start}" readonly>
                                    <span> - </span>
                                    <input type="text" name="end" id="end-picker" placeholder="结束时间" class="form-control" value="${end}" readonly>
                                </div>
                                <div class="form-group left-group">
                                    <label for="name-input">书名：</label>
                                    <input type="text" id="name-input" name="name" class="form-control" value="${name}">
                                </div>
                                <div class="form-group left-group">
                                    <label for="">分类：</label>
                                    <select name="category_id" id="" class="form-control">
                                        <c:choose>
                                            <c:when test="${category_id != null || category_id != 0}">
                                                <option value="">所有分类</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="" selected>所有分类</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:forEach items="${categories}" var="category">
                                            <c:choose>
                                                <c:when test="${category_id == category.id}">
                                                    <option value="${category.id}" selected>${category.name}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${category.id}">${category.name}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group left-group">
                                    <button class="btn btn-primary">查询</button>
                                </div>
                                <div class="form-group">
                                    <a href="/account/novel_list/">清除查询</a>
                                </div>
                            </form>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>封面图</th>
                                    <th>书名</th>
                                    <th>分类</th>
                                    <th>章数</th>
                                    <th>字数</th>
                                    <th>价格</th>
                                    <th>发布时间</th>
                                    <th>是否完本</th>
                                    <th>是否推荐</th>
                                    <th>作者</th>
                                    <th>简介</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${novels}" var="novel">
                                    <tr data-novel-id="${novel.id}" >
                                        <td style="width:76px;height:96px;">
                                            <a href="/account/chapter_list?novel_id=${novel.id}">
                                                <img style="width:60px;" src="${novel.cover_url}" alt="">
                                            </a>
                                        </td>
                                        <td style="width:130px;">
                                            <a href="/account/chapter_list?novel_id=${novel.id}">
                                                    ${novel.name}
                                            </a>
                                        </td>
                                        <td>${novel.category.name}</td>
                                        <td>${novel.chapters_num}</td>
                                        <td>${novel.words_num}</td>
                                        <td>${novel.price}</td>
                                        <td style="width:100px;">
                                            <fmt:formatDate value="${novel.pub_date}" pattern="yyyy/MM/dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${novel.is_complete}">完本</c:when>
                                                <c:otherwise>连载</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${novel.is_recommend}">是</c:when>
                                                <c:otherwise>否</c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>${novel.author.pen_name}</td>
                                        <td style="width: 250px;">
                                            <div style="height:80px;overflow: hidden;text-overflow: ellipsis">${func:truncate(novel.profile,100)}</div>
                                        </td>
                                        <td style="width:60px;">
                                            <div class="dropdown">
                                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                                    <span class="glyphicon glyphicon-cog"></span>
                                                    <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                                                    <li><a class="update-btn" href="javascript:void(0)" data-finish="${novel.is_complete}">更新</a></li>
                                                    <c:if test="${!novel.is_complete}">
                                                        <li><a href="javascript:void(0)" class="set-finish-btn">完结</a></li>
                                                    </c:if>
                                                    <li><a href="/account/edit_novel?novel_id=${novel.id}">编辑</a></li>
                                                    <li><a href="javascript:void(0)" class="delete-btn">删除</a></li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="box-footer">
                            <ul class="pagination pagination-sm no-margin pull-right">
                                <c:choose>
                                    <c:when test="${has_previous}">
                                        <li><a href="/account/novel_list?p=${previous_page_number}${url_query}">«</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="disabled"><a href="javascript:void(0);">«</a></li>
                                    </c:otherwise>
                                </c:choose>
                                <c:if test="${left_has_more}">
                                    <li><a href="/account/novel_list/${url_query}">1</a></li>
                                    <li><a href="javascript:void(0);" style="cursor:default;">...</a></li>
                                </c:if>
                                <c:forEach items="${left_pages}" var="left_page">
                                    <li><a href="/account/novel_list?p=${left_page}${url_query}">${left_page}</a></li>
                                </c:forEach>
                                <li class="active"><a href="javascript:void(0)">${current_page}</a></li>
                                <c:forEach items="${right_pages}" var="right_page">
                                    <li><a href="/account/novel_list?p=${right_page}${url_query}">${right_page}</a></li>
                                </c:forEach>
                                <c:if test="${right_has_more}">
                                    <li><a href="javascript:void(0);" style="cursor:default;">...</a></li>
                                    <li><a href="/account/novel_list?p=${num_pages}${url_query}">${num_pages}</a></li>
                                </c:if>
                                <c:choose>
                                    <c:when test="${has_next}">
                                        <li><a href="/account/novel_list?p=${next_page_number}${url_query}">»</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="disabled"><a href="javascript:void(0)">»</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
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
