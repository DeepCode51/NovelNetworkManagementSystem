<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/func.tld" prefix="func"%>


<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <%--{% csrf_token %}--%>
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li><a href="/cms/index/"><i class="fa fa-home"></i><span>首页</span></a></li>
            <c:if test="${func:hasPermission(user, 'change_all_novel') or user.is_superuser}">
                <li class="header">小说管理</li>
                <li><a href="/cms/novel_list/"><i class="fa fa-list"></i><span>小说列表</span></a></li>
            </c:if>
            <c:if test="${func:hasPermission(user, 'change_novelcategory') or user.is_superuser}">
                <li class="header">分类管理</li>
                <li><a href="/cms/category_list/"><i class="iconfont icon-category"></i> <span>分类列表</span></a></li>
                <li><a href="/cms/tag_list/"><i class="iconfont icon-tag"></i> <span>标签列表</span></a></li>
            </c:if>
            <c:if test="${func:hasPermission(user, 'change_advertisement') or user.is_superuser}">
                <li class="header">广告管理</li>
                <li><a href="/cms/ad_set/"><i class="iconfont icon-guanggaogongguan"></i> <span>广告位</span></a></li>
                <li><a href="/cms/banners/"><i class="iconfont icon-shouyelunbotu"></i> <span>轮播图</span></a></li>
                <li><a href="/cms/excellent/"><i class="iconfont icon-show"></i> <span>优秀作品展示</span></a></li>
            </c:if>
            <c:if test="${func:hasPermission(user, 'change_group') or user.is_superuser}">
                <li class="header">权限管理</li>
                <li><a href="/cms/staffs/"><i class="fa fa-group"></i><span>员工管理</span></a></li>
            </c:if>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>