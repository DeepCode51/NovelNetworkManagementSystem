<%@ page language="java" contentType="text/html; charset=UTF-8"
         autoFlush="false" buffer="1000kb" pageEncoding="UTF-8"
         import="java.util.*,com.ykjzone.util.Filters,com.ykjzone.pojo.Advertisement"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/func.tld" prefix="func"%>


<c:set var="title" value="小说网|首页" scope="request" />


<%@include file="base/head.jsp"%>

<link rel="stylesheet" href="/dist/css/novel/index.min.css">
<script src="/dist/js/index.min.js"></script>
<style>
    .editor-recommend{
        text-indent: 2em;
    }
</style>

<%@include file="base/header.jsp"%>

<div class="main">
    <div class="wrapper">
        <!-- 第一部分 展示 -->
        <div class="exhibition-wrapper">
            <!-- 作品分类 -->
            <div class="exhibition-left">
                <dl>
                    <c:forEach items="${all_category_name}" var="category" varStatus="st">
                        <dd class="odd">
                            <a target='_blank' href="/${category[0]}">
                                <span class="cate-img ${category[0]}-img"></span>
                                <span class="cate-name">${category[1]}</span>
                                <span class="cate-quantity">3234232</span>
                            </a>
                        </dd>
                    </c:forEach>
                    <dd class="odd">
                        <a target='_blank' href="#">
                            <span class="cate-img nvshengwang-img"></span>
                            <span class="cate-name">女生网</span>
                            <span class="cate-quantity">153158</span>
                        </a>
                    </dd>
                    <dd class="odd">
                        <a target='_blank' href="#">
                            <span class="cate-img qingxiaoshuo-img"></span>
                            <span class="cate-name">轻小说</span>
                            <span class="cate-quantity">45328</span>
                        </a>
                    </dd>
                </dl>
            </div>
            <div class="exhibition-center">
                <!--轮播图-->
                <div class="banner-group" id="banner-group">
                    <ul class="banner-ul" id="banner-ul">
                        <c:forEach items="${banners}" var="banner" varStatus="st">
                            <li>
                                <a href="${banner.link_to}" target="_blank">
                                    <img src="${banner.image_url}" alt="">
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    <span class="arrow left-arrow">‹</span>
                    <span class="arrow right-arrow">›</span>
                    <div class="page-control-group">
                        <ul class="page-control">

                        </ul>
                    </div>
                </div>
                <!-- 广告 -->
                <ul class="center-advertisement">
                    <%--{% for ad in ads|slice:'0:3' %}--%>
                    <%
                        List<Advertisement> ads = (List<Advertisement>) request.getAttribute("ads");
                        List<Advertisement> ads_1_3 = new ArrayList<Advertisement>();
                        for(int i = 0; i < 3; i++){
                            ads_1_3.add(ads.get(i));
                        }
                        request.setAttribute("ads_1_3",ads_1_3);
                    %>
                    <c:forEach items="${ads_1_3}" var="ad" varStatus="st">
                        <li>
                            <a href="${ad.link_to}" target="_blank">
                                <img src="${ad.image_url}" alt="">
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="exhibition-right">
                <div class="works-show">
                    <h4>网络文学优秀作品展示</h4>
                    <ul>
                        <%--{% for works in excellent_workses|slice:'0:4' %}--%>
                        <c:forEach items="${excellent_workses}" var="works" varStatus="st">
                            <li>
                                <a href="${works.link_to}" target="_blank">「公告」${works.title}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="#">
                                <span class="game-web-tag">页游</span>
                                收尽天下尤物
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="game-web-tag">页游</span>
                                颠覆全服只靠神戒
                            </a>
                        </li>
                    </ul>
                    <div class="roll-message">
                        <i class="trumpet iconfont icon-broadcast"></i>
                        <marquee>
                            <a href="#">心语丶丶打赏从收租开始当大佬100W点，【成为该书白银大盟】</a>
                        </marquee>
                    </div>
                </div>
                <div class="right-advertisement">
                    <%--{% with ad=ads.3 %}--%>
                    <%
                        Advertisement ad4 = ads == null ? new Advertisement() : ads.get(3);
                        request.setAttribute("ad4",ad4);
                    %>
                    <a href="${ad4.link_to}" target="_blank">
                        <img src="${ad4.image_url}" alt="">
                    </a>
                </div>
            </div>
        </div>
        <!-- 第二部分 推荐 新书 -->
        <div class="recommend-wrapper">
            <!-- 本周强推 -->
            <div class="recommend-left">
                <div class="left-header">
                    <h2>本周强推</h2>
                </div>
                <ul>
                    <%--{% for novel in recommend_novels|slice:'6:17' %}--%>
                    <c:forEach items="${rec_novels_7_17}" var="novel" varStatus="st">
                        <li>
                            <span class="novel-cate">
                                <a href='/index_category/${func:getCategoryName(novel.category.id,"en")}' target="_blank">「${novel.category.name}」</a>
                            </span>
                            <span class="novel-name">
                                <a href="/detail/${novel.id}" target="_blank">${func:truncate(novel.name,7)}</a>
                            </span>
                            <span class="novel-author">
                                <a href="#" target="_blank">${novel.author.pen_name}</a>
                            </span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- 编辑推荐 -->
            <div class="recommend-body">
                <div class="body-header">
                    <h2>编辑推荐</h2>
                </div>
                <div class="novel-media">
                    <div class="line line1"></div>
                    <div class="line line2"></div>
                    <ul>
                        <c:forEach items="${rec_novels_1_6}" var="novel" varStatus="st">
                            <li>
                                <div class="novel-img">
                                    <a href="/detail/${novel.id}" target="_blank">
                                        <img src="${novel.cover_url}" alt="">
                                    </a>
                                </div>
                                <div class="novel-info">
                                    <h4 class="novel-title">
                                        <a href="/detail/${novel.id}" target="_blank">${novel.name}</a>
                                    </h4>
                                    <div class="novel-profile editor-recommend">
                                            <%--{{ novel.profile|striptags|strip|truncatechars:50 }}--%>
                                            ${func:profile_truncate(novel.profile,57)}
                                    </div>
                                    <div class="novel-author">
                                        <a href="#" class="author-name" target="_blank"><span>${novel.author.pen_name}</span></a>
                                        <span class="nav-number">${func:wordsNumFilter(novel.words_num)}万字</span>
                                        <span class="nav-tag">${novel.tag.name}</span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!-- 新书推荐 -->
            <div class="recommend-right">
                <div class="right-header">
                    <h2>新书推荐</h2>
                </div>
                <ul>
                    <%--{% for novel in new_novels|slice:'0:11' %}--%>
                    <c:forEach items="${new_novels_1_11}" var="novel" varStatus="st">
                        <li>
                            <span class="novel-cate"><a href='/index_category/${func:getCategoryName(novel.category.id,"en")}' target="_blank">「${novel.category.name}」</a></span>
                            <span class="novel-name"><a href="/detail/${novel.id}">${func:truncate(novel.name,7)}</a></span>
                            <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!-- 第三部分 热门 -->
        <div class="hot-wrapper">
            <!-- 分类排行 -->
            <div class="hot">
                <%--{% cache 172800 cate_rank  %}--%>
                <c:forEach items="${cate_hot_novels}" var="novels" varStatus="st">
                    <c:if test="${st.count > 4}">
                        <div class="cate-novel under">
                    </c:if>
                    <c:if test="${st.count <= 4}">
                        <div class="cate-novel">
                    </c:if>
                        <h3>
                            ${all_category_name[st.count*2-2][1]}·${all_category_name[st.count*2-1][1]}
                            <b class="icon-tag icon${st.count}"></b>
                        </h3>
                        <ul>
                            <%--{% for novel in novels.2 %}--%>
                            <c:forEach items="${novels}" var="novel" varStatus="st0">
                                <li>
                                    <span class="novel-cate"><a href="#" target="_blank">「${novel.category.name}」</a></span>
                                    <span class="novel-name"><a href="/detail/${novel.id}" target="_blank">${novel.name}</a></span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:forEach>
                <%--{% endcache %}--%>
                <!-- 轻小说 -->
                <div class="cate-novel under">
                    <h3>
                        轻小说
                        <b class="icon-tag icon7"></b>
                    </h3>
                    <ul>
                        <li>
                            <span class="novel-cate"><a href="#">「轻小说」</a></span>
                            <span class="novel-name"><a href="#">缔造最强职业者</a></span>
                        </li>
                        <li>
                            <span class="novel-cate"><a href="#">「轻小说」</a></span>
                            <span class="novel-name"><a href="#">从渡鸦开始进化成神</a></span>
                        </li>
                        <li>
                            <span class="novel-cate"><a href="#">「轻小说」</a></span>
                            <span class="novel-name"><a href="#">成为火影养成系统</a></span>
                        </li>
                        <li>
                            <span class="novel-cate"><a href="#">「轻小说」</a></span>
                            <span class="novel-name"><a href="#">我在漫威当法神</a></span>
                        </li>
                        <li>
                            <span class="novel-cate"><a href="#">「轻小说」</a></span>
                            <span class="novel-name"><a href="#">游戏王里的宝可梦</a></span>
                        </li>
                    </ul>
                </div>
                <!-- 特别推荐 -->
                <div class="alone under">
                    <div class="alone-one">
                        <div class="novel-info">
                            <span class="novel-tag">体育赛事</span>
                            <span class="novel-name"><a href="#">大国体育</a></span>
                            <span class="novel-number">4516212人次</span>
                            <span class="novel-profile">新任务：世界杯出线！</span>
                        </div>
                        <div class="novel-img">
                            <a href="#">
                                <img src="/dist/images/novel/novel/alone-one.jpg" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="alone-two">
                        <div class="novel-info">
                            <span class="novel-tag">军旅生涯</span>
                            <span class="novel-name"><a href="#">特种岁月</a></span>
                            <span class="novel-number">6,543,340人气</span>
                            <span class="novel-profile">奉献青春流血流汗</span>
                        </div>
                        <div class="novel-img">
                            <a href="#">
                                <img src="/dist/images/novel/novel/alone-two.jpg" alt="">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 排行榜 -->
            <div class="rank">
                <div class="rank-header">
                    <h2>排行榜</h2>
                </div>
                <ul>
                    <c:forEach items="${rank_novels}" var="novel" varStatus="st">
                        <c:if test="${st.count == 1}">
                            <li class="unfold">
                                <div class="novel-info-box">
                                    <span class="novel-1">NO.1</span>
                                    <span class="novel-name">
                                    <a href="/detail/${novel.id}" target="_blank">${novel.name}</a>
                                </span>
                                    <p class="novel-author">
                                        <a href="#">${novel.category.name}</a><i>·</i><a href="#">${novel.author.pen_name}</a>
                                    </p>
                                </div>
                                <div class="novel-img-box">
                                    <a href="/novel:detail/${novel.id}">
                                        <img src="https://bookcover.yuewen.com/qdbimg/349573/1016811796/90" alt="">
                                    </a>
                                </div>
                            </li>
                        </c:if>
                        <c:if test="${st.count > 1}">
                            <li>
                                <div class="num-box">
                                    <c:if test="${st.count == 2}">
                                        <span class="num-2">2</span>
                                    </c:if>
                                    <c:if test="${st.count == 3}">
                                        <span class="num-3">3</span>
                                    </c:if>
                                    <c:if test="${st.count > 3}">
                                        <span>${st.count}</span>
                                    </c:if>
                                </div>
                                <div class="novel-box">
                                    <span class="novel-cate">
                                        <a href='/index_category/${func:getCategoryName(novel.category.id,"en")}'>
                                        「${novel.category.name}」</a>
                                    </span>
                                    <span class="novel-name"><a href="/detail/${novel.id} ">${func:truncate(novel.name,7)}</a></span>
                                    <span class="novel-author"><a href="#">${novel.author.pen_name}</a></span>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </div>
        </div>
        </div>
    </div>
</div>

<%@include file="base/footer.jsp"%>
<%@include file="base/auth.jsp"%>
</body>
</html>