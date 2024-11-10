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
    <title>编辑员工</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>编辑员工权限</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3>员工权限</h3>
                        </div>
                        <div class="box-body">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>所属组</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${staff.username}</td>
                                    <td>${staff.telephone}</td>
                                    <form action="/cms/insert_staff" class="form-inline" method="post">
                                        <%--{% csrf_token %}--%>
                                        <input type="hidden" name="telephone" value="${staff.telephone}">
                                        <td>
                                            <c:forEach items="${groups}" var="group">
                                                <label class="checkbox-inline">
                                                    <c:choose>
                                                        <c:when test="${func:hasGroup(staff.groups,group)}">
                                                            <input type="checkbox" name="groups" checked value="${group.id}">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <input type="checkbox" name="groups" value="${group.id}">
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <span>${group.name}</span>
                                                </label>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <input type="submit" class="btn btn-primary pull-right" value="提交">
                                            </div>
                                        </td>
                                    </form>
                                </tr>
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
