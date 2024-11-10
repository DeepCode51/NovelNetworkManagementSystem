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
    <title></title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
    <%@include file="header.jsp"%>
    <div class="wrapper">
        <div class="content-wrapper">
            <section class="content-header">
                {% block content-header %}

                {% endblock %}
            </section>

            <section class="content">
                {% block content %}

                {% endblock %}
            </section>
        </div>

        <div class="control-sidebar-bg"></div>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
