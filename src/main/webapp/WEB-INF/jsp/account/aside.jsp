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
            <li><a href="/account/index/"><i class="iconfont icon-home"></i> <span>首页</span></a></li>
            <li class="header">个人中心</li>
            <li><a href="/account/recently_read/"> <i class="iconfont icon-yuedu"></i> <span>最近阅读</span></a></li>
            <li><a href="/account/my_collect/"><i class="iconfont icon-books"></i> <span>我的书架</span></a></li>
            <%--<li><a href="#"><i class="iconfont icon-dingdan"></i> <span>我的订单</span></a></li>--%>
            <%--{% if not perms.novel.add_novel %}--%>
            <c:if test="${!user.is_author}">
                <li><a href="/account/become_writer/"><i class="iconfont icon-writerin-l"></i> <span>成为作家</span></a></li>
            </c:if>

            <c:if test="${user.is_author}">
                <li class="header">作家专区</li>
                <li><a href="/account/novel_list/"><i class="fa fa-list"></i><span>我的作品</span></a></li>
                <li><a href="/account/pub_novel/"><i class="iconfont icon-tianjiaxiangmu"></i> <span>添加小说</span></a></li>
                <li><a href="/account/choose_novel?operate=1"><i class="iconfont icon-xie"></i> <span>更新小说</span></a></li>
                <li><a href="/account/choose_novel?operate=2"><i class="fa fa-edit"></i><span>小说章节</span></a></li>
            </c:if>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>