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
    <title>标签详情</title>
    <style>
        span.btn{
            border-radius: 20px;
            background: #fff;
            display: inline-block;
        }
        .tag {
            display: inline-block;
            font-size: 18px;
            line-height: 34px;
        }
    </style>
    <script type="text/html" id="tag-default">
        <tr data-tag-id="{{ tag.id }}">
            <td>
                <span class="tag">{{ tag.name }}</span>
            </td>
            <td>
                <button class="edit-btn btn btn-warning btn-sm">编辑</button>
                <button class="delete-btn btn btn-danger btn-sm">删除</button>
            </td>
        </tr>
    </script>
    <script type="text/html" id="add-tag">
        <tr>
            <td>
                <input class="form-control" name="name" type="text">
            </td>
            <td>
                <button class="add-submit btn btn-success btn-sm">保存</button>
                <button class="add-cancel btn btn-warning btn-sm">取消</button>
            </td>
        </tr>
    </script>
    <script type="text/html" id="edit-tag">
        <tr data-tag-id="{{ tag.id }}">
            <td>
                <input class="form-control" type="text" name="name" value="{{ tag.name }}">
            </td>
            <td>
                <button class="edit-submit btn btn-success btn-sm">保存</button>
                <button class="edit-cancel btn btn-default btn-sm">取消</button>
                <span class="text-danger">正在编辑：{{ tag.name }}</span>
            </td>
        </tr>
    </script>
    <script src="/dist/arttemplate/template-web.js"></script>
    <script src="/dist/js/cms/tag_detail.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>编辑标签</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <%--返回--%>
                            <a href="/cms/tag_list/" class="btn btn-default"><< 返回</a>
                            <span style="margin-left:50px;">
                                类别：
                                <c:choose>
                                    <c:when test="${category != null}">
                                        ${category.name}
                                    </c:when>
                                    <c:otherwise>
                                        通用
                                    </c:otherwise>
                                </c:choose>
                            </span>
                            <a href="#" class="add-btn btn btn-info btn-sm pull-right">
                                <i class="iconfont icon-add" style="font-size: 15px;"></i>
                                添加标签
                            </a>
                        </div>
                        <div class="box-body">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="col-md-8">标签</th>
                                    <th class="col-md-4">操作</th>
                                </tr>
                                </thead>
                                <tbody data-cate-id="${category.id}">

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
