<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<%@include file="head.jsp"%>

    {% block head %}
    {% endblock %}
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
  <%@include file="header.jsp"%>
  <%@include file="aside.jsp"%>

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
  <%@include file="footer.jsp"%>
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

</body>
</html>
