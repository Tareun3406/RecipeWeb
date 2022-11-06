<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header -->
<c:import url="/header"/>
<link rel="stylesheet" type="text/css" href="../../../resources/css/registration.css"/>
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/recipePost.js"></script>

<section id="backimg">
    <article>
        <div id="r9">
            <form name="ck" action="recipeUpload" id="cK_form" onsubmit="return onSubmitCheck();"
                  method="post" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
                <div id="re">
                    <div id="re_1">
                        <h1>레시피 등록</h1>
                    </div>
                    <ul id="rs">
                        <li><span style="font-size:16px">요리 제목 </span>
                            <input id="ck_title" name="title" placeholder=" 요리제목을 입력해주세요.">
                        </li>
                        <br/>
                    </ul>
                    <div class="content">
                        <div>
                            <ul>
                                <li>
                                    <span style="font-size:16px">썸네일</span>
                                    <input type='file' name='thumnailImg' id="thumnail" accept="image/*"/>
                                </li>
                            </ul>
                        </div>
                        <div>
                            <ul>
                                <li>
                                    <span style="font-size:16px">태그</span>
                                    <input type="text" id="post_tag" name="post_tag"
                                           placeholder=" #을 사용하고 태그를 등록할때는 스페이스바를 눌러주세요. 예) #한식,#떡볶이"/>
                                </li>
                            </ul>
                        </div>
                        <ul id="tag-list">
                        </ul>
                    </div>
                </div>
                <div id="ing_wrap">
                    <ul>
                        <li>
                            <span style="font-size:16px"> 재료 </span>
                            <input id="ck_ing" name="ingredient"
                                   placeholder="콜론(:)을 사용하여 재료와 분량을 구분하고 스페이스바로 등록해주세요 . 예) 설탕:한큰술">
                        </li>
                        <br/>
                    </ul>
                </div>
                <div id="img_num">
                    <ul>
                        <p></p>
                        <li><span style="font-size:16px">요리순서</span>
                            <div id="box">
                                <input type="button" id="btn_blue" value="추가" onclick="add_textbox()">
                                <input type='button' id='btn_orange' value='삭제' onclick='remove()'>
                            </div>
                        </li>
                    </ul>
                </div>
                <ul id="ing-list">
                </ul>
                <div id="tip_wrap">
                    <ul>
                        <li><span style="font-size:16px"> 나만의 팁 </span><input id="ck_tip" name="tip"
                                                                              placeholder=" 나만의 꿀팁을 적어보세요."></li>
                        <br/>
                    </ul>
                </div>
        <div>
            <input type="reset" class="btn red rounded" value="취소" onclick="ck.title.focus()">
            <input type="submit" class="btn green rounded" value="등록">
        </div>
        </form>
        </div>
    </article>
</section>


<!-- footer -->
<jsp:include page="../main/footer.jsp" flush="false"/>