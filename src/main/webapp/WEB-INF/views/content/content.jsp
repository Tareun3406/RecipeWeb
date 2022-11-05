<%--
  Created by IntelliJ IDEA.
  User: khm81712
  Date: 2022/10/18
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/header"/>
<link href="${pageContext.request.contextPath}/resources/css/content.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/129ea0b18b.js" crossorigin="anonymous"></script>
<script>
    function goLogin(){
        alert('로그인 후 이용해주세요.');
        location = '/member/login';
    }
    function duplicateRegistration(){
        alert('등록된 리뷰가 존재합니다.');
    }
    function reviewCheck(){
        if($('#review_text').val().length <= 0 || $('#review_text').val() == '댓글을 입력해주세요.'){
            alert('댓글을 입력해주세요.');
            return false;
        }else{
            document.getElementById('starForm').submit();
        }
    }
    function UnSubscribeable(){
        alert('본인은 구독할 수 없습니다.');
    }
    function UnReviewable(){
        alert('본인 글에는 리뷰를 등록할 수 없습니다.');
    }
</script>

<div class="wrap">
    <div class="main_image">
        <img src="/resources/images/content/${plist[0].thumnail}" class="img">
    </div>

    <div class="title">
        <div class="titleAndHit">
            <div id="cooking_title">
                <h1>${plist[0].title}</h1>
            </div>

            <c:if test="${userid == 'notlogin'}">

                <div class="report">
                    <button type="button" onclick="goLogin()">신고하기</button>
                </div>

            </c:if>

            <c:if test="${userid != 'notlogin'}">

                <c:if test="${report_state == 0}">
                    <form method="post" action="insert_report">
                        <input type="hidden" name="post_no" value="1">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                        <input type="hidden" name="userid" value="${userid}">
                        <div class="report">
                            <button type="submit">신고하기</button>
                        </div>
                    </form>
                </c:if>

                <c:if test="${report_state == 1}">
                    <form method="post" action="del_report">
                        <input type="hidden" name="post_no" value="1">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                        <input type="hidden" name="userid" value="${userid}">
                        <div class="report">
                            <button type="submit">신고취소</button>
                        </div>
                    </form>
                </c:if>

            </c:if>

            <div class="hit">
                <i class="fa-solid fa-eye" style="font-size:30px">${plist[0].hit}</i>
            </div>
        </div>
        <div class="writer_container">
            <div class="writer">
                <a href="#"> <img class="writer_image"
                                  src="/resources/images/content/apple.png" alt="글쓴이 이미지" /></a> <a
                    class="writer_name" href="#"> <b>${plist[0].member[0].nickname}</b></a>
                <c:if test="${!empty plist[0].updatedate}">
                    <p>${plist[0].updatedate}(수정됨)</p>
                </c:if>
                <c:if test="${empty plist[0].updatedate}">
                    <p>${plist[0].regdate}</p>
                </c:if>
            </div>

            <div class="subscribe">

            <!-- 비로그인 -->
                <c:if test="${userid == 'notlogin'}">
                    <button class="sub_btn" type="button" onclick="goLogin()" style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                        <i class="fa-regular fa-bookmark" style="font-size:30px"></i>
                    </button>
                    <button class="sub_btn" type="button" onclick="goLogin()" style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                        <i class="fa-regular fa-star" style="font-size:30px"></i>
                    </button>
                </c:if>

            <!-- 로그인 -->
                <c:if test="${userid != 'notlogin'}">

                    <!-- 로그인한 사람 == 글쓴이 -->
                    <c:if test="${userid == plist[0].member[0].userid}">
                        <button class="sub_btn" type="button" onclick="UnSubscribeable()" style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                            <i class="fa-regular fa-bookmark" style="font-size:30px"></i>
                        </button>
                    </c:if>

                    <!-- 로그인한 사람 != 글쓴이 -->
                    <c:if test="${userid != plist[0].member[0].userid}">
                        <!-- 비구독 -->
                        <c:if test="${subscribe_state == 0}">
                            <form method="post" action="insert_subscribe">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                                <input type="hidden" name="subscriber_id" value="${userid}">
                                <input type="hidden" name="target_id" value="${plist[0].member[0].userid}">
                                <div class="sub_btn">
                                    <button type="submit" style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                                        <i class="fa-regular fa-bookmark" style="font-size:30px"></i>
                                    </button>
                                </div>
                            </form>
                        </c:if>

                        <!-- 구독 -->
                        <c:if test="${subscribe_state == 1}">
                            <form method="post" action="del_subscribe">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                                <input type="hidden" name="subscriber_id" value="${userid}">
                                <input type="hidden" name="target_id" value="${plist[0].member[0].userid}">
                                <div class="sub_btn">
                                    <button type="submit" style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                                        <i class="fa-solid fa-bookmark" style="font-size:30px"></i>
                                    </button>
                                </div>
                            </form>
                        </c:if>
                    </c:if>

                    <!-- 비즐찾 -->
                    <c:if test="${bookmark_state == 0}">
                         <form method="post" action="insert_bookmark">
                             <input type="hidden" name="post_no" value="1">
                             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                             <input type="hidden" name="userid" value="${userid}">
                             <div class="sub_btn">
                                 <button type="submit" style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                                     <i class="fa-regular fa-star" style="font-size:30px"></i>
                                 </button>
                            </div>
                         </form>
                    </c:if>

                    <!-- 즐찾 -->
                    <c:if test="${bookmark_state == 1}">
                        <form method="post" action="del_bookmark">
                            <input type="hidden" name="post_no" value="1">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                            <input type="hidden" name="userid" value="${userid}">
                            <div class="sub_btn">
                                <button style="border:0px; background-image:url(/resources/images/content/backgroundimage.png);">
                                    <i class="fa-solid fa-star" style="font-size:30px"></i>
                                </button>
                            </div>
                        </form>
                    </c:if>

                </c:if>
            </div>
        </div>

    </div>

    <div class="tag">
        <ul>
            <c:forEach var="tag" items="${tagList}">
                <li><a href="#">#${tag}</a></li>
            </c:forEach>
        </ul>
    </div>

    <div class="ingredients">
        <div id="ingredients">
            <h2 style="font-size:35px">재료</h2>
        </div>
        <c:forEach var="name" items="${ingredient_names}" varStatus="status">
                    <div class="item">
                        <a href="#">${name}</a>
                        <p>${ingredient_amounts[status.index]}</p>
                    </div>
        </c:forEach>
    </div>

    <div class="tip">
        <div class="tip_title">
            <h2 style="font-size:35px">팁</h2>
        </div>
        <div class="tip_text">
            <p>${plist[0].tip}</p>
        </div>
    </div>

    <div class="recipe">
        <h2 style="font-size:35px">순서</h2>
        <c:forEach var="c" items="${plist[0].content}">
            <div class="recipeStep">
                <div class="recipeStep_manual">
                    <p>${c.manual}</p>
                </div>
                <div class="recipeStep_image">
                    <img width="299px" height="250px" src="/resources/images/content/${c.image}">
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="comment">
        <div id="comments">
            <h2 style="font-size:35px">리뷰 | ${replyCount}  <label id="yellowStar">★</label>
                <c:if test="${!empty averageScore}">
                    <fmt:formatNumber value="${averageScore}" pattern=".00"/>
                </c:if>
            </h2>
        </div>
        <div class="comment_container">
            <c:if test="${!empty rlist}">
                <c:forEach var="r" items="${rlist}">
                    <div class="comment_content">
                        <div class="comment_writer">
                            <a href="#"><img class="comment_writer_image" src="/resources/images/content/apple.png" alt="글쓴이 이미지" /></a>
                            <a class="comment_writer_name" href="#"> <b>${r.member.get(0).nickname}</b></a>
                            <c:if test="${!empty r.updatedate}">
                                <p>${r.updatedate}(수정됨)</p>
                            </c:if>
                            <c:if test="${empty r.updatedate}">
                                <p>${r.regdate}</p>
                            </c:if>
                            <c:if test="${userid == r.member.get(0).userid}">
                                <form action="edit_reply" style="float:left;">
                                    <input type="hidden" name="post_no" value="1">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                                    <input type="hidden" name="reviewer" value="${userid}">
                                    <button type="submit">수정</button>
                                </form>
                                <form action="del_reply" style="float:left;">
                                    <input type="hidden" name="post_no" value="1">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                                    <input type="hidden" name="reviewer" value="${userid}">
                                    <button type="submit">삭제</button>
                                </form>
                            </c:if>
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

            <form action="insert_reply" name="starForm" id="starForm" method="post">
                <input type="hidden" name="post_no" value="1">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token" >
                <c:if test="${userid != 'notlogin'}">
                    <input type="hidden" name="reviewer" value="${userid}">
                </c:if>
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
                        <textarea id="review_text" cols="93" name="content">댓글을 입력해주세요.</textarea>
                    </div>
                    <div class="comment_submit_btn">
                        <c:if test="${userid == 'notlogin'}">
                            <input type="button" onclick="goLogin()" value="등록" />
                        </c:if>
                        <c:if test="${userid != 'notlogin'}">
                            <c:if test="${userid == plist[0].member[0].userid}">
                                <input type="button" onclick="UnReviewable()" value="등록" />
                            </c:if>
                            <c:if test="${userid != plist[0].member[0].userid}">
                                <c:if test="${reply_state == 0}">
                                    <input type="button" onclick="reviewCheck()" value="등록" />
                                </c:if>
                                <c:if test="${reply_state == 1}">
                                    <input type="button" onclick="duplicateRegistration()" value="등록" />
                                </c:if>
                            </c:if>
                        </c:if>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="../main/footer.jsp" />


