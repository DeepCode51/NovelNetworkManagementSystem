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
    <title>广告位管理</title>
        <style>
            img.thumbnail{
                min-width:188px;
                min-height:148px;
                border:0px solid  #ffffff;
            }
        </style>
        <script type="text/html" id="adhtml">
            <div class="thumbnail">
                <img class="thumbnail" src="{{ ad.image_url }}" alt="..."  data-toggle="modal" data-target="#ad-{{ ad.location }}">
                <div class="caption">
                    <p class="text-center">{{ ad.hint }}</p>
                    <div class="clearfix">
                        <h4 class="pull-left">广告 {{ ad.location }}</h4>
                        <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#ad-{{ ad.location }}">
                            设置
                        </button>
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="ad-{{ ad.location }}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    广告4 右
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="">预览</label>
                                        <input class="image-file" type="file" hidden="hidden" name="image_url" style="display:none;">
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <a href="#" class="thumbnail thumbnail-btn">
                                                <img src="{{ ad.image_url }}" alt="...">
                                                点击切换
                                            </a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="">链接地址</label>
                                        <input type="text" class="form-control" name="link_to" value="{{ ad.link_to }}">
                                    </div>
                                    <div class="form-group">
                                        <label for="">备注</label>
                                        <input type="text" class="form-control" name="hint" value="{{ ad.hint }}">
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="close-btn btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="submit-btn btn btn-primary" data-location="{{ ad.location }}" data-ad-id="{{ ad.id }}">保存</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </script>
        <script src="/dist/arttemplate/template-web.js"></script>
        <script src="/dist/js/cms/ad_set.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<%@include file="aside.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>广告位管理</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">

                        </div>
                        <div class="box-body">
                            <div class="row">
                                <div class="ad-cell col-md-3" data-location="1">

                                </div>
                                <div class="ad-cell col-md-3" data-location="2">

                                </div>
                                <div class="ad-cell col-md-3" data-location="3">

                                </div>
                                <div class="ad-cell col-md-3" data-location="4">

                                </div>
                            </div>
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
