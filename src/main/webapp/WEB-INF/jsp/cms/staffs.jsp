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
    <title>员工管理</title>
    <script src="/dist/js/cms/staff.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h2>员工管理</h2>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header">
                            <a href="/cms/add_staff/" class="btn btn-primary pull-right">添加员工</a>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>所属组</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${staffs}" var="staff">
                                    <tr data-staff-id="${staff.id}">
                                        <td>${staff.username}</td>
                                        <td>${staff.telephone}</td>
                                        <td>${staff.email}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${staff.is_superuser}">
                                                    超级管理员
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${staff.groups}" var="group" varStatus="st">
                                                        ${group.name}
                                                        <c:if test="${st.end}">
                                                            /
                                                        </c:if>
                                                        <%--{% if not forloop.last %} / {% endif %}--%>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="/cms/edit_staff?staff_id=${staff.id}" class="btn btn-info btn-xs">编辑</a>
                                            <button class="delete-btn btn btn-danger btn-xs">删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="box-footer"></div>
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
