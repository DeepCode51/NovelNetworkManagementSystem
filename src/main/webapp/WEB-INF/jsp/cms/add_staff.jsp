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
    <title>添加员工</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>添加员工</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="box">
                        <form action="/cms/insert_staff" method="post">
                            <%--{% csrf_token %}--%>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="telephone-input">手机号</label>
                                    <input type="text" class="form-control" id="telephone-input" name="telephone">
                                </div>
                                <div class="form-group">
                                    <label>所属组</label>
                                    <div class="checkbox">
                                        <c:forEach items="${groups}" var="group">
                                            <label>
                                                <input type="checkbox" name="groups" value="${group.id}">
                                                <span>${group.name}</span>
                                            </label>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="form-group">
                                    ${message}
                                </div>
                            </div>
                            <div class="box-footer">
                                <button class="btn btn-primary pull-right">立即添加</button>
                            </div>
                        </form>
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
