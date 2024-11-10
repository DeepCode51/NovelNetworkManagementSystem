<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%--<meta name="csrf_token" comtent="{{ csrf_token }}">--%>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="icon" type="image/x-ico" href="/dist/images/logo.ico" />
    <link rel="stylesheet" href="/dist/adminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/dist/adminLTE/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/dist/adminLTE/bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="/dist/adminLTE/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/dist/adminLTE/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="/dist/sweetalert/sweetalert.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1538834_3e6eghu470g.css">
    <script src="/dist/adminLTE/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="/dist/adminLTE/bower_components/jquery-ui/jquery-ui.min.js"></script>
    <script>$.widget.bridge('uibutton', $.ui.button);</script>
    <script src="/dist/adminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/dist/adminLTE/dist/js/adminlte.min.js"></script>
    <script src="/dist/adminLTE/dist/js/demo.js"></script>
    <script src="/dist/js/message.min.js"></script>
    <script src="/dist/sweetalert/sweetalert.min.js"></script>
    <script src="/dist/js/myajax.min.js"></script>
    <script src="/dist/js/xfzalert.min.js"></script>
    <style>
        header {
            position: fixed !important;
            width: 100%;
        }
        .main-sidebar{
            position: fixed;
        }
        .content-wrapper {
            margin-top:50px;
        }
    </style>