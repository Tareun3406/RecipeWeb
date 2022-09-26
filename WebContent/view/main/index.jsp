<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp" flush="false"/>
<!-- header -->


<!-- 레시피 랭킹 -->
<section id="main">
    <article class="recipe-rank">
        <h2>
            <a href="#" style="margin-left: 30px">인기 레시피</a>
        </h2>
        <div class="image-container">
            <img class="main-image" alt=""
                 src="../../images/recipeThum/food01.jpg">
            <div class="recipe-info">
                <ul>
                    <li class="recipe-title">레시피 이름</li>
                    <li>재료 1</li>
                    <li>재료 2</li>
                    <li>재료 3</li>
                    <li>재료 4</li>
                    <li>재료 5</li>
                    <li>재료 6</li>
                    <li>재료 7</li>
                    <li>재료 8</li>
                    <li>재료 9</li>
                </ul>
            </div>
            <img class="image" src="../../images/recipeThum/food01.jpg">
            <img class="image" src="../../images/recipeThum/food01.jpg">
            <img class="image" src="../../images/recipeThum/food01.jpg">
            <img class="image" src="../../images/recipeThum/food01.jpg">
        </div>
        <button type="button">
            <span class="material-symbols-outlined">arrow_back_ios_new</span>
        </button>
        <button type="button">
            <span class="material-symbols-outlined">arrow_forward_ios</span>
        </button>
    </article>

    <!-- 현재 많이 찾는 메뉴 -->
    <article class="popular-menu">
        <h2>
            <a href="#">지금 많이 찾는 메뉴</a>
        </h2>
        <ul>
            <li>
                <span class="menu-number"> 1 </span>
                <div class="menu-recipe">
                    <img src="../../images/recipeThum/food01.jpg">
                    <span class="menu-name"> 찜닭 </span>
                </div>
                <span class="material-symbols-outlined">star</span>
            </li>
            <li>
                <span class="menu-number"> 2 </span>
                <div class="menu-recipe">
                    <img src="../../images/recipeThum/food01.jpg">
                    <span class="menu-name"> 찜닭 </span>
                </div>
                <span class="material-symbols-outlined">star</span>
            </li>
            <li>
                <span class="menu-number"> 3 </span>
                <div class="menu-recipe">
                    <img src="../../images/recipeThum/food01.jpg">
                    <span class="menu-name"> 찜닭 </span>
                </div>
                <span class="material-symbols-outlined">star</span>
            </li>
            <li>
                <span class="menu-number"> 4 </span>
                <div class="menu-recipe">
                    <img src="../../images/recipeThum/food01.jpg">
                    <span class="menu-name"> 찜닭 </span>
                </div>
                <span class="material-symbols-outlined">star</span>
            </li>
            <li>
                <span class="menu-number"> 5 </span>
                <div class="menu-recipe">
                    <img src="../../images/recipeThum/food01.jpg">
                    <span class="menu-name"> 찜닭</span>
                </div>
                <span class="material-symbols-outlined">star</span>
            </li>
            <li>
                <span class="menu-number"> 6 </span>
                <div class="menu-recipe">
                    <img src="../../images/recipeThum/food01.jpg">
                    <span class="menu-name"> 찜닭 </span>
                </div>
                <span class="material-symbols-outlined">star</span>
            </li>
        </ul>
        <div class="add-view-list">
            <a href="#">
                <span class="material-symbols-outlined">add_circle</span> 더보기
            </a>
        </div>
    </article>


    <!-- 오늘의 추천 조합/재료 -->
    <article class="today-special">
        <h2>
            <a href="#">오늘의 추천</a>
        </h2>
        <div class="select-special">
            <button type="button">오늘의 추천 조합</button>
            <button type="button">오늘의 추천 재료</button>
        </div>
        <div style="display: flex">
            <div class="selected-main">
                <img src="../../images/recipeThum/food01.jpg" style="border-radius: 8px; height:330px; float: left;">
                <div>메뉴 이름<br> 설명aaaa aaaaa aaa a aaaaaa aaaaaa aa aa a a a</div>
            </div>

            <div class="select-main">
                <div class="recomand-special">
                    <img src="../../images/recipeThum/food01.jpg" style="height:130px;">
                    이름
                </div>
                <div class="recomand-special">
                    <img src="../../images/recipeThum/food01.jpg" style="height:130px;">
                    이름
                </div>
                <div class="recomand-special">
                    <img src="../../images/recipeThum/food01.jpg" style="height:130px;">
                    이름
                </div>
                <div class="recomand-special">
                    <img src="../../images/recipeThum/food01.jpg" style="height:130px;">
                    이름
                </div>
                <div class="recomand-special">
                    <img src="../../images/recipeThum/food01.jpg" style="height:130px;">
                    이름
                </div>
                <div class="recomand-special">
                    <img src="../../images/recipeThum/food01.jpg" style="height:130px;">
                    이름
                </div>
            </div>
        </div>
    </article>


    <!-- 이벤트 배너 -->
    <article class="rollingBanner">
        <ul class="image-container">
            <li class="banner_item">
                <a href="#"><img src="../../images/banner/event.jpg"></a>
            </li>
            <li class="banner_item">
                <a href="#"><img src="../../images/banner/eventAlt.jpg"></a>
            </li>

        </ul>
        <button type="button" class="banner_prev" onclick="bannerPrev('bannerSelect')">
            <span class="material-symbols-outlined">arrow_back_ios_new</span>
        </button>
        <button type="button" class="banner_next" onclick="bannerNext('bannerSelect')">
            <span class="material-symbols-outlined">arrow_forward_ios</span>
        </button>
        <div>
            <input type="radio" name="bannerSelect" value="0" onchange="bannerChange(this)" checked>
            <input type="radio" name="bannerSelect" value="1" onchange="bannerChange(this)">
        </div>
    </article>
    <!-- 배너 스크립트 -->
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


    <!-- 커뮤니티 간략글 -->
    <article class="index-board">
        <table>
            <caption><a href="#">요리연구소/팁</a></caption>
            <tr class="hotPost">
                <td class="border-tag">연구</td>
                <td class="border-title">제목</td>
                <td class="likes-number">13</td>
            </tr>
            <tr class="hotPost">
                <td class="border-tag">연구</td>
                <td class="border-title">제목</td>
                <td class="likes-number">13</td>
            </tr>
            <tr class="hotPost">
                <td class="border-tag">팁</td>
                <td class="border-title">제목</td>
                <td class="likes-number">13</td>
            </tr>
            <tr>
                <td class="border-tag">연구</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">팁</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">연구</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">팁</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">팁</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">연구</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">연구</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">팁</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">팁</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
        </table>
        <table>
            <caption><a href="#">자유게시판</a></caption>
            <tr class="hotPost">
                <td class="border-tag">QnA</td>
                <td class="border-title">제목</td>
                <td class="likes-number">13</td>
            </tr>
            <tr class="hotPost">
                <td class="border-tag">잡담</td>
                <td class="border-title">제목</td>
                <td class="likes-number">13</td>
            </tr>
            <tr class="hotPost">
                <td class="border-tag">QnA</td>
                <td class="border-title">제목</td>
                <td class="likes-number">13</td>
            </tr>
            <tr>
                <td class="border-tag">잡담</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">잡담</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">QnA</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">잡담</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">QnA</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">QnA</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">잡담</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">QnA</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>
            <tr>
                <td class="border-tag">잡담</td>
                <td class="border-title">제목</td>
                <td class="date">오늘</td>
            </tr>

        </table>
    </article>
</section>



<!-- footer -->
<jsp:include page="footer.jsp" flush="false"/>