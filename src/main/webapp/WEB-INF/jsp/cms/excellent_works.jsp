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
    <title>网络文学优秀作品联展</title>
    <script src="/dist/js/cms/excellent_works.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>网络文学优秀作品联展</h1>
        </section>

        <section class="content">
            <div class="row">
                <c:forEach items="${excellent_workses}" var="works" varStatus="st">
                    <div class="col-md-8">
                        <div class="box box-primary" data-works-id="${works.id}" data-location="${st.count}">
                            <div class="box-header">
                                <span>${st.count}</span>
                            </div>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="">标题</label>
                                    <input type="text" name="title" value="${works.title}" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">链接</label>
                                    <input type="text" name="link_to" value="${works.link_to}" class="form-control">
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="submit-btn btn btn-info pull-right">保存</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </div>

    <div class="control-sidebar-bg"></div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
