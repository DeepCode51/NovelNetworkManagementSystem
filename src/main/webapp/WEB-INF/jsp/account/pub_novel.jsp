<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="func" uri="/WEB-INF/func.tld"%>


<%@include file="head.jsp"%>

<%--<script src="https://unpkg.com/qiniu-js@2.5.2/dist/qiniu.min.js"></script>--%>
<script src="/dist/js/account/pub_novel.min.js"></script>
<script src="/dist/ueditor/ueditor.config.js"></script>
<script src="/dist/ueditor/ueditor.all.min.js"></script>
</head>
<body class="hold-transition skin-green-light sidebar-mini">
<div class="wrapper">
    <%@include file="header.jsp"%>
    <%@include file="aside.jsp"%>

    <div class="content-wrapper">
        <section class="content-header">
            <c:choose>
                <c:when test="${novel != null}">
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
                    <div class="box box-primary">
                        <form action="" role="form">
                            <div class="box-body">
                                <%--书名--%>
                                <div class="form-group">
                                    <label for="title-form">书名</label>
                                    <input type="text" class="form-control" id="title-form" name="name" value="${novel.name}">
                                </div>
                                <%--分类--%>
                                <div class="form-group">
                                    <label for="category-form">分类</label>
                                    <select name="category_id" id="category-form" class="form-control" data-category-id="${novel.category.id}">

                                    </select>
                                </div>
                                <%--标签--%>
                                <div class="form-group">
                                    <label>标签</label>
                                    <div class="input-group radio-group" data-tag-id="${novel.tag.id}">

                                    </div>
                                </div>
                                <%--价格--%>
                                <div class="form-group">
                                    <label for="is_free">价格</label>
                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <select name="is_free" id="is_free" class="btn btn-default">
                                                <c:choose>
                                                    <c:when test="${novel != null and novel.price == 0}">
                                                        <option selected value="0">免费</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="0">免费</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${novel != null and novel.price > 0}">
                                                        <option selected value="1">付费</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="1">付费</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </select>
                                        </span>
                                        <input class="form-control" name="price" value="
                                        <c:choose>
                                            <c:when test="${novel != null}">${novel.price}</c:when>
                                            <c:otherwise>0</c:otherwise>
                                        </c:choose>
                                        " type="text" placeholder="请输入价格" style="display:none;">
                                    </div>
                                </div>
                                <%--缩略图--%>
                                <div class="form-group">
                                    <label for="cover_url-form">缩略图</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="cover_url-form" name="cover_url" value="${novel.cover_url}" readonly>
                                        <span class="input-group-btn">
                                    <label class="btn btn-default btn-file">
                                        上传图片<input hidden type="file" class="btn btn-default" id="thumbnail-btn">
                                    </label>
                                </span>
                                    </div>
                                </div>
                                <%--进度条--%>
                                <div id="progress-group" class="form-group" style="display:none;">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-success progress-bar-striped"
                                             role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                             style="width: 0">
                                            0%
                                        </div>
                                    </div>
                                </div>
                                <%--简介--%>
                                <div class="form-group">
                                    <label for="desc-form">简介</label>
                                    <script id="editor" type="text/plain">${novel.profile}</script>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button id="submit-btn" class="btn btn-primary fa-pull-right" data-novel-id="${novel.id}">发布小说</button>
                            </div>
                        </form>
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
