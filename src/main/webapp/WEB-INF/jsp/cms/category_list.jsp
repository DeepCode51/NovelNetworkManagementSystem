<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func" %>


<!DOCTYPE html>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>小说分类管理</title>
    <script src="/dist/js/cms/category_list.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp" %>
<%@include file="aside.jsp" %>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>小说分类管理</h1>
        </section>

        <section class="content">

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <button id="add-btn" class="btn btn-primary fa-pull-right">添加分类</button>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>分类名称</th>
                                    <th>小说数量</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${categories}" var="category" varStatus="st">
                                    <tr data-id="${category.id}" data-name="${category.name}">
                                        <td>${st.count}.</td>
                                        <td>${category.name}</td>
                                        <td>${category.novels_num}</td>
                                        <td>
                                            <button class="btn btn-warning btn-xs edit-btn">编辑</button>
                                            <button class="btn btn-danger btn-xs delete-btn">删除</button>
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
<%@include file="footer.jsp" %>
</body>
</html>
