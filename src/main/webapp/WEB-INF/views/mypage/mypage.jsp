<%--
  Created by IntelliJ IDEA.
  User: night
  Date: 2022-10-14
  Time: 오후 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../main/header.jsp" flush="false"/>

<link href="${pageContext.request.contextPath}/resources/css/category.css" rel="stylesheet" type="text/css">
<!-- 헤더-->

<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="
    width: 1100px;
    display: flex;
    justify-content: center;
    margin-left: auto;
    margin-right: auto;">
 <div class="mypagediv">
     <div class="div1"><!--회원정보창 -->
         <input type="radio" name="tabmenu" id="tab01" checked>
         <label for="tab01" style="border-top-left-radius: 30px; border-left:5px dotted mistyrose;">내 정보</label>

         <input type="radio" name="tabmenu" id="tab02">
         <label for="tab02" >나의 활동</label>

         <input type="radio" name="tabmenu" id="tab03">
         <label for="tab03">구독/즐겨찾기</label>

         <input type="radio" name="tabmenu" id="tab04">
         <label for="tab04" style="border-top-right-radius:30px; border-right:5px dotted mistyrose;">쪽지함</label>

         <div class="conbox con1">
             <div class="contbored">
             <div>내 아이디 : ${id}</div>
             <div>내 이름 : ${name}</div>
             <div style="margin-bottom: 0px;">내 비밀번호 : ${pw}</div>
             </div>

         </div>

         <div class="conbox con2">
             <div class="contbored">
             <div>내가 등록한 글 <br/>
                 <c:choose>
                     <c:when test="${!empty subscript}"> <!--등록글번호 컬럼으로 수정-->
                         ${subscript}
                     </c:when>
                     <c:otherwise>
                         내가 등록한 글이 없습니다.
                     </c:otherwise>
                 </c:choose>
             </div>
             <div>내가 쓴 댓글 <br/>
                 <c:choose>
                     <c:when test="${!empty subscript}"> <!--댓글 번호 컬럼으로 수정-->
                         ${subscript}
                     </c:when>
                     <c:otherwise>
                         내가 쓴 댓글이 없습니다.
                     </c:otherwise>
                 </c:choose>
             </div>
             <div>추천 한 글 <br/>
                 <c:choose>
                     <c:when test="${!empty subscript}"> <!--추천한 글 번호 컬럼으로 수정-->
                         ${subscript}
                     </c:when>
                     <c:otherwise>
                         추천 한 글이 없습니다.
                     </c:otherwise>
                 </c:choose>
             </div>
             </div>
         </div>

         <div class="conbox con3">
             <div class="contbored">
             <div>구독한 쉐프 <br/>

                 <c:choose>
                  <c:when test="${!empty subscript}">
                          <c:forTokens items="${subscript}" delims="," var="sub">
                                     쉐프 닉네임 : ${sub}<br/>
                          </c:forTokens>
                  </c:when>
                  <c:otherwise>
                     구독한 쉐프가 없습니다.
                  </c:otherwise>
                 </c:choose>
             </div>
             <div>즐겨 찾기  <br/>
                 <c:choose>
                     <c:when test="${!empty bookmark}">
                         ${bookmark}
                     </c:when>
                     <c:otherwise>
                         즐겨찾기 한 글이 없습니다.
                     </c:otherwise>
                 </c:choose>
             </div>
         </div>
         </div>

         <div class="conbox con4">
             <div class="contbored">
             <div>받은 쪽지 <br/>
                 <c:choose>
                     <c:when test="${!empty bookmark}"> <!--받은쪽지 컬럼으로 수정-->
                         ${bookmark}
                     </c:when>
                     <c:otherwise>
                         받은 쪽지가 없습니다.
                     </c:otherwise>
                 </c:choose>
             </div>
             <div>보낸 쪽지 <br/>
                 <c:choose>
                     <c:when test="${!empty bookmark}"> <!--보낸쪽지 컬럼으로 수정-->
                         ${bookmark}
                     </c:when>
                     <c:otherwise>
                         보낸 쪽지가 없습니다.
                     </c:otherwise>
                 </c:choose>
             </div>
         </div>
         </div>

     </div>
 </div>
</div>

</body>
</html>

<!-- 푸터 -->
<jsp:include page="../main/footer.jsp" flush="false"/>