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
    <title>选择小说</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="header.jsp"%>
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>${header_text}</h1>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3>请选择小说</h3>
                        </div>
                        <div class="box-body">
                            <table>
                                <c:forEach items="novels" var="novel">
                                    <tr>
                                        <td class="col-md-8">
                                            <div class="media"  style="margin:10px 0;">
                                                <div class="media-left">
                                                    <a href="#">
                                                        <img style="width:100px;" class="media-object" src="${novel.cover_url}" alt="...">
                                                    </a>
                                                </div>
                                                <div class="media-body">
                                                    <h2 class="media-heading">${novel.name}</h2>
                                                    <div class="row">
                                                        <h5 class="col-md-2">${novel.category.name}</h5>
                                                        <h5 class="col-md-3">当前共${novel.chapters_num}章</h5>
                                                        <h5 class="col-md-3">当前共${novel.words_num}字</h5>
                                                    </div>
                                                    <span>${func:truncate(novel.profile,100)}</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="col-md-4">
                                            <a href="${to_url}?novel_id=${novel.id}" class="btn btn-warning btn-lg">${btn_text}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
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
