<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <link rel="shortcut icon" href="#">

    <script>
        //롤링배너
        function bannerPrev(radioName){
            const radios = document.getElementsByName(radioName);
            let checkIndex;
            for(let i = 0; i<radios.length; i++){
                if(radios[i].checked === true){
                    checkIndex = i;
                }
            }
            if (checkIndex === 0){
                radios[radios.length-1].checked = true;
                bannerChange(radios[radios.length-1]);
            }
            else{
                radios[checkIndex-1].checked = true;
                bannerChange(radios[checkIndex-1]);
            }
                radios[checkIndex-1].checked=true;
        }
        function bannerNext(inputName){
            const radios = document.getElementsByName(inputName);
            let checkIndex;
            for(let i = 0; i<radios.length; i++){
                if(radios[i].checked === true){
                    checkIndex = i;
                }
            }
            if (checkIndex === radios.length-1) {
                radios[0].checked = true;
                bannerChange(radios[0]);
            }
            else{
                radios[checkIndex+1].checked=true;
                bannerChange(radios[checkIndex+1]);
            }
        }
        function bannerChange(radio){
            const imgContainers = radio.parentNode.parentNode.getElementsByClassName("image-container");
            const imgContainer = imgContainers.item(0);
            if(radio.checked)
                imgContainer.style.transform= "translateX(-"+radio.value+"00%)";
        }

    </script>
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
                <li class="alt"><a href="#">레시피</a></li>
                <li class="alt"><a href="#">레시피 전당</a></li>
                <li><a href="#">즐겨찾는 레시피</a></li>
                <li><a href="#">이벤트</a></li>
            </ul>
        </div>
        <div id="member">

            <ul>
                <li><a href="#">회원가입</a></li>
                <!-- <li><a href="#">로그아웃</a></li> -->
                <!-- 로그인시 로그아웃 변경 -->
                <li><a href="#">로그인</a></li>
                <!-- <li><a href="#">마이페이지</a></li> -->
                <!-- 로그인시 마이페이지로 변경 -->
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
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>
            <figure class="chef-profile">
                <img class="profile-img" alt="profile"
                     src="images/profile.png">
                <figcaption>일등셰프하나</figcaption>
                <!-- 한글 6자, 영문 10자 -->
            </figure>


        </div>
    </div>
</header>