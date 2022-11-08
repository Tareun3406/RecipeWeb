<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/header"/>
<section id="main">
    <!-- 레시피 랭킹 -->
    <article class="recipe-rank">
        <h2>
            <a href="#" style="margin-left: 30px">인기 레시피</a>
        </h2>
        <div class="view-container">
            <ul class="rank-image-container">
                <c:forEach var="recipe" items="${rankedRecipeList}">
                    <li class="container-item">
                        <label>
                            <input type="radio" value="${recipe.RNum-1}" style="display: none;" onclick="rankOnClick(this)">
                            <img class="menu-image" alt="" src="${recipe.thumnail}"
                                 onclick="sendRedirect(${recipe.post_no},${recipe.RNum-1})">
                        </label>
                        <ul class="recipe-info" style="background:  #fffde4; border: 1px solid var(--point-color);">
                            <li class="recipe-title">${recipe.RNum}. ${recipe.title}</li>
                            <c:set var="notDone" value="true"/>
                            <c:forEach items="${recipe.ingredientList}" var="ingr">
                                <li>${ingr}</li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <button class="button_prev" type="button" onclick="rankPrev()">
            <span class="material-symbols-outlined">arrow_back_ios_new</span>
        </button>
        <button class="button_next" type="button" onclick="rankNext()">
            <span class="material-symbols-outlined">arrow_forward_ios</span>
        </button>
    </article>
    <script>
        const imageList = document.getElementsByClassName('menu-image');
        const infoList = document.getElementsByClassName('recipe-info');
        const rankImageContainer = document.getElementsByClassName('rank-image-container')[0]
        let num = 0;
        selectMenu(num)

        function selectMenu(num) {
            imageList[num].style.height = '240px';
            imageList[num].style.width = '240px';
            infoList[num].style.display = 'block';

            if (num <= 7)
                rankImageContainer.style.transform = "translateX(-" + num * 180 + "px)";
            else
                rankImageContainer.style.transform = "translateX(-" + 7 * 180 + "px)";
        }

        function unSelectMenu(num) {
            imageList[num].style.height = '180px';
            imageList[num].style.width = '180px';
            infoList[num].style.display = 'none';
        }

        function rankPrev() {
            if (num > 0) {
                unSelectMenu(num);
                selectMenu(num -= 1);
            } else {
                unSelectMenu(num);
                num = imageList.length - 1;
                selectMenu(num);
            }
            clearInterval(interval);
            interval = rankingInterval();
        }

        function rankNext() {
            if (num < imageList.length - 1) {
                unSelectMenu(num);
                selectMenu(num += 1);
            } else {
                unSelectMenu(num);
                num = 0
                selectMenu(num);
            }
            clearInterval(interval);
            interval = rankingInterval();
        }

        function rankOnClick(radio) {
            unSelectMenu(num);
            num = parseInt(radio.value);
            selectMenu(num);
            clearInterval(interval);
            interval = rankingInterval();
        }

        function sendRedirect(no,RNum){
            if (RNum === num){
                location.href='/content?post_no=' + no;
            }
        }
        let interval = rankingInterval();
        function rankingInterval() {
             return setInterval(function() {
                rankNext();
            }, 5000);
        }
    </script>
    <article class="popular-menu">
        <h2>
            <a href="#">다시 찾는 메뉴</a>
        </h2>
        <ul>
            <c:forEach var="recipe" items="${bookmarkRecipeList}">
                <c:if test="${recipe.RNum == 7}">
                    <div id="moreList" style="display: none; flex-wrap: wrap">
                </c:if>
                <li onclick="location.href='/content?post_no=${recipe.post_no}'">
                    <span class="menu-number"> ${recipe.RNum} </span>
                    <div class="menu-recipe">
                        <img src="${recipe.thumnail}">
                        <div>
                            <div class="menu-name">
                                <span class="bWriter">${recipe.writer}</span>
                                ${recipe.title}
                            </div>
                        </div>

                    </div>
                    <span class="material-symbols-outlined"></span> <%-- 즐겨찾기 이미지 추가 예정--%>
                </li>
                <c:if test="${recipe.RNum == 10}">
                    </div>
                </c:if>
            </c:forEach>
        </ul>
        <div class="add-view-list" style="background: var(--back-nomal-color);">
            <button href="#" style="border: none; background: var(--back-nomal-color);" onclick="moreList('moreList',this)">
                더보기
            </button>
        </div>
    </article>
    <script>
        function moreList(id, btn) {
            const list = document.getElementById(id);
            if (list.style.display == 'flex') {
                list.style.display = 'none';
                btn.innerText = "더보기";
            } else {
                list.style.display = 'flex';
                btn.innerText = "숨기기";
            }
        }
    </script>

    <!-- 게시글 요약 -->
    <article class="index-board">
        <table>
            <caption><a href="#">요리레시피</a></caption>
            <tr class="hotPost">
                <td class="border-no">번호</td>
                <td class="border-title">제목</td>
                <td class="border-writer">글쓴이</td>
                <td class="likes-number">조회수</td>
            </tr>
            <c:forEach var="recipe" items="${recentRecipeList}">
                <tr onclick="location.href='/content?post_no=${recipe.post_no}'">
                    <td class="border-no">${recipe.post_no}</td>
                    <td class="border-title">${recipe.title}</td>
                    <td class="border-writer">${recipe.writer}</td>
                    <td class="likes-number">${recipe.hit}</td> <%-- 조회수 --%>
                </tr>
            </c:forEach>
        </table>
        <table>
            <caption><a href="/commu_list">자유게시판</a></caption>
            <tr class="hotPost">
                <td class="border-no">번호</td>
                <td class="border-title">제목</td>
                <td class="border-writer">글쓴이</td>
                <td class="likes-number">조회수</td>
            </tr>
            <c:forEach var="commu" items="${recentCommuList}">
                <tr onclick="location.href='commu_cont?comu_no=${commu.comu_no}'">
                    <td class="border-no">${commu.comu_no}</td>
                    <td class="border-title">${commu.title}</td>
                    <td class="border-writer">${commu.writer}</td>
                    <td class="likes-number">${commu.viewcnt}</td>
                </tr>
            </c:forEach>
        </table>
    </article>
</section>
<jsp:include page="footer.jsp"/>