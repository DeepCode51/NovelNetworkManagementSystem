<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp"%>
    <%@include file="aside.jsp"%>
    <title>标签列表</title>
    <style>
        span.btn{
            border-radius: 20px;
            background: #fff;
            display: inline-block;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1 class="">所有分类</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <a href="/cms/category_list/" class="btn btn-primary pull-right">添加类别</a>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>类别</th>
                                    <th>标签</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><span class="text-warning">通用</span></td>
                                    <td>
                                        <c:forEach items="${common_tags}" var="tag">
                                            <span class="btn btn-default btn-sm">${tag.name}</span>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <a href="/cms/tag_detail/" class="btn btn-warning btn-sm">编辑</a>
                                        <a href="#" class="btn btn-danger btn-sm">删除</a>
                                    </td>
                                </tr>
                                <c:forEach items="${cate_tags}" var="cate_tag">
                                    <tr>
                                        <td><span class="text-warning">${cate_tag.name}</span></td>
                                        <td>
                                            <c:forEach items="${cate_tag.tags}" var="tag">
                                                <span class="btn btn-default btn-sm">${tag.name}</span>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <a href="/cms/tag_detail?category_id=${cate_tag.id}" class="btn btn-warning btn-sm">编辑</a>
                                            <a href="#" class="btn btn-danger btn-sm">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="box-footer">

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <div class="control-sidebar-bg"></div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
