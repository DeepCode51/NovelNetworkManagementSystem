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
    <title>编辑小说章节</title>
    <script src="/dist/js/cms/edit_chapter.min.js"></script>
    <script src="/dist/ueditor/ueditor.config.js"></script>
    <script src="/dist/ueditor/ueditor.all.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp" %>
<%@include file="aside.jsp" %>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>编辑小说章节</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <form action="" role="form">
                            <div class="box-header">
                                <h3>${chapter.novel.name}·第<span
                                        id="number">${chapter.novel.chapters_num + 1}</span>章</h3>
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
                                        data-chapter-id="${chapter.id}">发布
                                </button>
                            </div>
                        </form>
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
