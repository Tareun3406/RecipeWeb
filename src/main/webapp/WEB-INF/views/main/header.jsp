<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/commu.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <link href="/resources/css/content.css" rel="stylesheet" type="text/css">
    <script src="/resources/js/jquery.js"></script>
    <!-- content -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">


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
            <a href="#">로고</a>
        </div>

        <div id="header-menu">
            <ul>
                <li class="alt"><a href="/category">레시피</a></li>
                <li class="alt"><a href="/ranking">레시피 전당</a></li>
                <li><a href="#">즐겨찾는 레시피</a></li>
                <li><a href="#">커뮤니티</a></li>
            </ul>
        </div>
        <div id="member">

            <ul>
                <s:authorize access="isAnonymous()">
                    <li><a href="member/login">로그인</a></li>
                    <li><a href="member/join">회원가입</a></li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <li><a href="member/logout">로그아웃</a>
                    <li><a href="#">마이페이지</a></li>
                </s:authorize>
            </ul>
        </div>
    </nav>
    <div id="search-recipe-div">
        <div id="search-trans">
            <form id="search-border" action="#">
                <input id="search-Input" name="search" type="text"
                       placeholder="#추천검색어">
                <button type="submit">
							<span class="material-symbols-outlined" style="font-size: 30px;">
								search </span>
                </button>
            </form>
            <!--  -->
            <button type="button">레시피 등록</button>
            <a href="#">#추천검색어 를 검색해보세요</a>
        </div>
        <div id="chef-rank-list">
            <h3 style="margin-bottom: 10px;">인기 셰프
                Top10
            </h3>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="/resources/images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>


        </div>
    </div>
</header>