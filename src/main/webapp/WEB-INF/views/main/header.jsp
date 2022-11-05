<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/commu.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta charset="UTF-8">
    <title>non-title</title> <!-- 사이트 이름 -->
</head>
<body>
<header>
    <!--
     <div id="topBanner">이벤트/광고</div>
    -->
    <!-- 위 내용 추가시 css에서 header nav 부분 fixed를 sticky로 변경-->
    <nav id="headerTop">
        <div id="logo">
            <a href="/">로고</a>
        </div>

        <div id="header-menu">
            <ul>
                <li class="alt"><a href="/category">레시피</a></li>
                <li class="alt"><a href="/ranking">레시피 전당</a></li>
                <li><a href="#">즐겨찾는 레시피</a></li>
                <li><a href="/commu_list">커뮤니티</a></li>
            </ul>
        </div>
        <div id="member">

            <ul>
                <s:authorize access="isAnonymous()">
                    <li><a href="member/login">로그인</a></li>
                    <li><a href="member/join">회원가입</a></li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <li>
                        <form method="post" action="/member/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
                            <button type="submit" id="logoutBtn">로그아웃</button>
                        </form>
                    <li><a href="mypage">마이페이지</a></li>
                </s:authorize>
            </ul>
        </div>
    </nav>
    <div id="search-recipe-div">
        <div id="search-trans">
            <form id="search-border" action="/category" name="find_name">
                <input id="search-Input" name="find_name" type="text"
                       placeholder="#추천검색어">
                <button type="submit">
							<span class="material-symbols-outlined" style="font-size: 30px;">
								search </span>
                </button>
            </form>
            <!--  -->
            <button type="button" onclick="location.href='recipe_post';">레시피 등록</button>
            <a href="#">#추천검색어 를 검색해보세요</a>
        </div>
        <div id="chef-rank-list">
            <h3 style="margin-bottom: 10px;">인기 셰프
                Top10
            </h3>
            <c:forEach items="${chefList}" var="chef">
                <figure class="chef-profile">
                    <img class="profile-img" onerror=this.src="/resources/images/profile.png"
                         src="/resources/images/profile.png">
                    <figcaption>${chef.nickname}</figcaption>
                    <!-- 한글 6자, 영문 10자 -->
                </figure>
            </c:forEach>

        </div>
    </div>
</header>
