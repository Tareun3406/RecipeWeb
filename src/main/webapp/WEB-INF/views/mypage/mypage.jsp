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
             <div>내 아이디 : ${userlist.userid}</div>
             <div>내 이름 : ${userlist.nickname}</div>
             <div style="margin-bottom: 0px;">내 이메일 : ${userlist.email}</div>
             </div>

         </div>

         <div class="conbox con2">
             <div class="contbored">
                 <div>내가 등록한 글<hr/>
                 <c:forEach items="${userlist.recipeList}" var="recipe" varStatus="i">
                  <span class="subbookspan" onclick="location.href='/content?post_no=${recipe.post_no}'"><c:out value="${recipe.post_no}"/>번 글</span>
                 </c:forEach>
                     <c:choose>
                         <c:when test="${empty userlist.recipeList[0].post_no}">
                             작성한 글이 없습니다.<hr/>
                         </c:when>
                     </c:choose>
             </div>
             <div>내가 쓴 댓글 <hr/>
                 <c:forEach items="${userlist.recipereplyList}" var="reply" varStatus="i">
                     <span class="subbookspan" onclick="location.href='/content?post_no=${reply.post_no}'">
                     댓글을 단 글번호:<c:out value="${reply.post_no}"/> /
                     댓글 내용:<c:out value="${reply.content}"/> /
                     작성 날짜:<c:out value="${reply.regdate}"/></span><hr/>
                 </c:forEach>
                 <c:choose>
                     <c:when test="${empty userlist.recipereplyList[0].post_no}">
                      작성한 댓글이 없습니다.<hr/>
                     </c:when>

                 </c:choose>
             </div>
             </div>
         </div>

         <div class="conbox con3">
             <div class="contbored">
                 <div>구독한 쉐프 : <hr/>
                     <c:forEach items="${userlist.subList}" var="sub" varStatus="i">
                         <span class="subbookspan" onclick="location.href='/category?find_name=${sub.target_id}'" ><c:out value="${sub.target_id}"/></span>
                     </c:forEach>
                     <c:choose>
                      <c:when test="${empty userlist.subList[0].target_id}">
                       구독한 쉐프가 없습니다.<hr/>
                      </c:when>
                     </c:choose>
                 </div>
             <div>북마크 한 글 :<hr/>
             <c:forEach items="${userlist.bookList}" var="book" varStatus="i">
                 <span class="subbookspan" onclick="location.href='/content?post_no=${book.post_no}'"><c:out value="${book.post_no}"/>번글</span>
             </c:forEach>
                 <c:choose>
                     <c:when test="${empty userlist.bookList[0].post_no}">
                         북마크 한 글이 없습니다.<hr/>
                     </c:when>
                 </c:choose>
             </div>
         </div>
         </div>

         <div class="conbox con4">
             <div class="contbored">
             <div>받은 쪽지<hr/>
             <c:forEach items="${userlist.messageList}" var="message" varStatus="i">
                 <c:if test="${userlist.userid == message.receiver}"><span class="subbookspan">
                  보낸사람 : <c:out value="${message.snickname}"/>  /
                     내용 : <c:out value="${message.message}"/>  /
                  받은 날짜 : <c:out value="${message.senddate}"/></span><hr/>
                 </c:if>
             </c:forEach>
                 <c:choose>
                     <c:when test="${empty userlist.messageList}">
                         받은 쪽지가 없습니다.<hr/>
                     </c:when>
                 </c:choose>

             </div>
             <div>보낸 쪽지<hr/>
                 <c:forEach items="${userlist.messageList2}" var="message2" varStatus="i">
                     <c:if test="${userlist.userid == message2.sender2}"><span class="subbookspan">
                   받은사람 : <c:out value="${message2.rnickname}"/>  /
                   내용 : <c:out value="${message2.message2}"/>  /
                   보낸 날짜 : <c:out value="${message2.senddate2}"/></span><hr/>
                     </c:if>
                 </c:forEach>
                 <c:choose>
                     <c:when test="${empty userlist.messageList2}">
                         보낸 쪽지가 없습니다.<hr/>
                     </c:when>
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