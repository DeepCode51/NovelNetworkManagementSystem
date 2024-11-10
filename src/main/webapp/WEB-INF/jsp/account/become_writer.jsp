<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>

<c:set var="title" value="开通作家" />

<%@include file="head.jsp"%>

</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
    <%@include file="header.jsp"%>
    <%@include file="aside.jsp"%>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>开通作家</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-8">
                    <div class="box box-success">
                        <div class="box-header">

                        </div>
                        <div class="box-body">
                            <form action="/account/submit_become_writer" method="post">
<%--                                {% csrf_token %}--%>
                                <div class="form-group">
                                    <label for="pen_name"><h3>请输入笔名</h3></label>
                                    <input type="text" class="form-control" id="pen_name" name="pen_name">
                                </div>
                                <div class="form-group">
                                    <input type="submit" value="开通" class="btn btn-success">
                                </div>
                                <div class="form-group">
                                    ${message}
                                </div>
                            </form>
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