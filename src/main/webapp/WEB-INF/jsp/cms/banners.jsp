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
    <title>轮播图管理</title>
    <link rel="stylesheet" href="/dist/css/cms/banner.min.css">
    <script src="/dist/arttemplate/template-web.js"></script>
    <script src="/dist/js/banners.min.js"></script>
    <style>
    .img-thumbnail{
        width: 233.08px;
        height: 87.45px;
    }
    </style>

    <script type="text/html" id="banner-item">
        {{ if banner }}
        <div class="box box-primary box-outline banner-item" data-banner-id="{{ banner.id }}">
            {{ else }}
            <div class="box box-primary box-outline banner-item">
                {{ /if }}
                <div class="box-header">
                    {{ if banner }}
                    <span class="priority">优先级：{{ banner.priority }}</span>
                    {{ else }}
                    <span class="priority">优先级：0</span>
                    {{ /if }}
                    <button class="btn btn-default btn-xs fa-pull-right close-btn">
                        <i class="fa fa-close"></i>
                    </button>
                </div>
                <div class="box-body">
                    <div class="thumbnail-group col-md-4">
                        <input type="file" class="image-input" style="display:none;">
                        {{ if banner }}
                        <img  src="{{ banner.image_url }}" class="img-thumbnail thumbnail" alt="">
                        {{ else }}
                        <img  src="/dist/images/novel/banner/blank.png" class="img-thumbnail thumbnail" alt="">
                        {{ /if }}
                    </div>
                    <div class="more-group col-md-8">
                        <div class="form-group">
                            {{ if banner }}
                            <input type="number" class="form-control" name="priority" value="{{ banner.priority }}">
                            {{ else }}
                            <input type="number" class="form-control" name="priority">
                            {{ /if }}
                        </div>
                        <div class="form-group">
                            {{ if banner }}
                            <input type="text" class="form-control" name="link_to" value="{{ banner.link_to }}">
                            {{ else }}
                            <input type="text" class="form-control" name="link_to">
                            {{ /if }}
                        </div>
                    </div>
                </div>
                <div class="box-footer">
                    <button class="btn btn-primary fa-pull-right save-btn">保存</button>
                </div>
            </div>
    </script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>轮播图管理</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="btn-group pull-left">
                        <button class="btn btn-primary" id="add-banner-btn">
                            <i class="fa fa-plus">添加轮播图</i>
                        </button>
                    </div>
                    <ul class="tips pull-left">
                        <li>支持JPG,GIF,PNG格式，最多可上传6张</li>
                        <li>比例4:1，宽度在800px以上，5M以内</li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    <div class="banner-list-group">

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
