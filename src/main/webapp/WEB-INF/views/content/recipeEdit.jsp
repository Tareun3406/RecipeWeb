<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header -->
<c:import url="/header"/>

<script src="https://cdn.jsdelivr.net/npm/@yaireo/tagify"></script>
<script src="https://cdn.jsdelivr.net/npm/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="../../../resources/css/registration.css"/>
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/recipePost.js"></script>

<style>
  .tagify{
    height: 40px;
    width: 600px;
    margin: -30px 0px 0px 100px;
    border-radius: 5px;
    border: 2px solid rgba(0,0,0,0.1);
    color: black;
    background: white;
  }
</style>




<script>

</script>

<section id="backimg">
  <article>
    <div id="r9">
      <form name="ck" action="recipeEditUpload" id="cK_form" onsubmit="return onSubmitCheck();"
            method="post" enctype="multipart/form-data">
        <input type="hidden" name="post_no" value="${plist.get(0).post_no}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
        <div id="re">
          <div id="re_1">
            <h1>레시피 등록</h1>
          </div>
          <ul id="rs">
            <li><span style="font-size:16px">요리 제목 </span>
              <input id="ck_title" name="title" placeholder=" 요리제목을 입력해주세요." value="${plist.get(0).title}">
            </li>
            <br/>
          </ul>
          <div class="content">
            <div>
              <ul>
                <li>
                  <span style="font-size:16px">썸네일</span>
                  <input type='file' name='thumnailImg' id="thumnail"/>
                </li>
              </ul>
            </div>
            <div>
              <ul>
                <li>
                  <span style="font-size:16px">태그</span>
                  <input type="hidden" id="post_tag" name="post_tag" placeholder="예) 장조림"/>
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
              <input type="hidden" id="ck_ing" name="ingredient"
                     placeholder="예) 설탕:한 큰술">
            </li>
            <br/>
          </ul>
        </div>
        <div id="img_num">
          <ul>
            <p></p>
            <li><span style="font-size:16px">요리순서</span>
              <div id="box">
                <div id="addedContent"></div>
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
                                                                  placeholder=" 나만의 꿀팁을 적어보세요."
                                                                  value="<c:if test="${!empty plist.get(0).tip}">${plist.get(0).tip}</c:if>"></li>
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
