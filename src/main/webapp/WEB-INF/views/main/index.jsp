<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false"/>
<!-- header -->


<section id="main">

    <!-- 레시피 랭킹 -->
    <article class="recipe-rank">
        <h2>
            <a href="#" style="margin-left: 30px">인기 레시피</a>
        </h2>

        <div class="view-container">
            <ul class="rank-image-container">
                <c:forEach var="recipe" items="${recipeList}">
                <li class="container-item">
                        <input type="radio" value="${recipe.RNum}" style="display: none;" onclick="rankOnClick(this)">
                        <img class="menu-image" alt=""
                             src="${recipe.thumnail}">
                        <ul class="recipe-info">
                            <li class="recipe-title">${recipe.RNum}. ${recipe.title}</li>
                            <li>재료 1</li>
                            <li>재료 2</li>
                            <li>재료 3</li>
                            <li>재료 4</li>
                            <li>재료 5</li>
                            <li>재료 6</li>
                            <li>재료 7</li>
                            <li>재료 8</li>
                            <li>재료 9</li>
                            <li>재료 10</li>
                            <li>&#8942;</li>
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
            infoList[num].style.display = 'block';

            rankImageContainer.style.transform = "translateX(-" + num * 180 + "px)";
            // rankImageContainer.style.transform = "translateX(-" + parseInt(num/4) * 180*4 + "px)";
        }

        function unSelectMenu(num) {
            imageList[num].style.height = '180px';
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
        }

        function rankOnClick(radio) {
            unSelectMenu(num);
            num = parseInt(radio.value);
            selectMenu(num);
        }
    </script>
</section>
    <!-- footer -->
<jsp:include page="footer.jsp" flush="false"/>