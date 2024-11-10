<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func" %>


<%@include file="head.jsp" %>

<script src="/dist/js/account/write_chapter.min.js"></script>
<script src="/dist/ueditor/ueditor.config.js"></script>
<script src="/dist/ueditor/ueditor.all.min.js"></script>
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
    <%@include file="header.jsp" %>
    <%@include file="aside.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <c:choose>
                <c:when test="${chapter != null}">
                    <h1>编辑小说</h1>
                </c:when>
                <c:otherwise>
                    <h1>发布小说</h1>
                </c:otherwise>
            </c:choose>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-success">
                        <form action="" role="form">
                            <div class="box-header">
                                <h3>${novel.name}·第<span id="number">${novel.chapters_num + 1}</span>章</h3>
                            </div>
                            <div class="box-body">
                                <%--标题--%>
                                <div class="form-group">
                                    <label for="title-form">标题</label>
                                    <input type="text" class="form-control" id="title-form" name="title"
                                           value="${chapter.title}">
                                </div>
                                <%--内容--%>
                                <div class="form-group">
                                    <label for="desc-form">内容</label>
                                    <script id="editor" type="text/plain">${chapter.content}</script>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button id="submit-btn" class="btn btn-primary fa-pull-right"
                                        data-novel-id="${novel.id}"
                                        data-chapter-id="${chapter.id}">发布
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <%@include file="footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

</body>
</html>
