<%--
  Created by IntelliJ IDEA.
  User: khm81712
  Date: 2022/10/18
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../main/header.jsp" />

<div class="wrap">
    <div class="main_image">
        <img src="/resources/images/content/orange.jpg" class="img">
    </div>

    <div class="title">
        <h1 id="cooking_title">요리 이름</h1>
        <div class="writer_container">
            <div class="writer">
                <a href="#"> <img class="writer_image"
                                  src="/resources/images/content/apple.png" alt="글쓴이 이미지" /></a> <a
                    class="writer_name" href="#"> <b>글쓴이</b></a>
                <p>2022.09.26 15:00</p>
            </div>
            <div class="subscribe">
                <i class="bi bi-bookmark-plus subscribe_item"></i>
                <!-- <i class="bi bi-bookmark-plus-fill sbuscribe_item"></i> -->
                <i class="bi bi-hand-thumbs-up subscribe_item"></i>
                <!-- <i class="bi bi-hand-thumbs-up-fill subscribe_item"></i> -->
            </div>
        </div>

    </div>

    <div class="tag">
        <ul>
            <c:forEach var="tag" items="${tagList}">
                <li><a href="#">#${tag}</a></li>
            </c:forEach>
<%--            <li><a href="#">#tag</a></li>--%>
        </ul>
    </div>

    <div class="ingredients">
        <div id="ingredients">
            <h2 style="font-size:35px">재료</h2>
        </div>

<%--        <div class="item">--%>
<%--            <a href="#">재료</a>--%>
<%--            <p>양</p>--%>
<%--        </div>--%>

    </div>

    <div class="recipe">
        <div id="carouselExampleIndicators" class="carousel slide"
             data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0"
                    class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active" data-interval="60000*10">
                    <img src="/resources/images/content/orange.jpg"
                         class="d-block w-100 image recipe_img" alt="123">
                </div>
                <div class="carousel-item" data-interval="60000*10">
                    <img src="/resources/images/content/orange.jpg"
                         class="d-block w-100 image recipe_img" alt="123">
                </div>
                <div class="carousel-item" data-interval="60000*10">
                    <img src="/resources/images/content/orange.jpg"
                         class="d-block w-100 image recipe_img" alt="123">
                </div>
            </div>
            <button class="carousel-control-prev" type="button"
                    data-target="#carouselExampleIndicators" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </button>
            <button class="carousel-control-next" type="button"
                    data-target="#carouselExampleIndicators" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </button>
        </div>
        <div class="recipe_content">
            <p>▶떡볶이소스 고추장 3큰술, 양조간장 1큰술, 황(유기농)설탕 1~1.5큰술, 올리고당 1큰술, 굴소스
                1/2큰술 --> 떡볶이양념이 많이 달지는 않으니 만들어서 찍어 먹어보고 단맛이 덜하면 올리고당이나 설탕을 약간 추가하셔도
                됩니다. [출처] 떡볶이 황금레시피 떡볶이소스 라볶이 레시피|작성자 잠꾸러기</p>
        </div>
    </div>

    <div class="comment">
        <div id="comments">
            <h2 style="font-size:35px">리뷰</h2>
        </div>
        <div class="comment_container">
            <c:if test="${!empty rlist}">
                <c:forEach var="r" items="${rlist}">
                    <div class="comment_content">
                        <div class="comment_writer">
                            <a href="#"><img class="comment_writer_image" src="/resources/images/content/apple.png" alt="글쓴이 이미지" /></a>
                            <a class="comment_writer_name" href="#"> <b>${r.reviewer}</b></a>
                            <p>${r.regdate}</p>
                        </div>
                        <div class="comment_text">
                            <div class="star_container">
                                <c:forEach begin="1" step="1" end="${r.score}">
                                    <label id="yellowStar">★</label>
                                </c:forEach>
                                <c:forEach begin="1" step="1" end="${5-r.score}">
                                    <label id="grayStar">★</label>
                                </c:forEach>
                            </div>
                            <br>
                            <p>${r.content}</p>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <!--
            <div id="add_comment_btn">
                <button type="button">더보기</button>
            </div>

            <script type="text/javascript">
                $(function() {
                    $(".comment_content").slice(0, 3).show(); // select the first ten
                    $("#add_comment_btn button").click(function(e) { // click event for load more
                        e.preventDefault();
                        $(".comment_content:hidden").slice(0, 10).show(); // select next 10 hidden divs and show them
                        if ($(".comment_content:hidden").length == 0) { // check if any hidden divs still exist
                            $("#add_comment_btn button").hide(); // alert if there are none left
                        }
                    });
                });
            </script>
             -->

            <form action="addreply" name="starForm" id="starForm" method="post">
                <input type="hidden" name="post_no" value="1">
                <input type="hidden" name="reviewer" value="홍길동">
                <div class="comment_star">
                    <fieldset>
                        <span class="text-bold">별점을 선택해주세요</span> <input type="radio"
                                                                         name="score" value="5" id="rate1"> <label
                            for="rate1">★</label> <input type="radio" name="score"
                                                         value="4" id="rate2"> <label for="rate2">★</label> <input
                            type="radio" name="score" value="3" id="rate3"> <label
                            for="rate3">★</label> <input type="radio" name="score"
                                                         value="2" id="rate4"> <label for="rate4">★</label> <input
                            type="radio" name="score" value="1" id="rate5"> <label
                            for="rate5">★</label>
                    </fieldset>
                </div>
                <div class="comment_write">
                    <div class="comment_text_write">
                        <textarea cols="93" name="content">댓글을 입력해주세요.</textarea>
                    </div>
                    <div class="comment_submit_btn">
                        <input type="submit" value="등록" />
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="../main/footer.jsp" />


