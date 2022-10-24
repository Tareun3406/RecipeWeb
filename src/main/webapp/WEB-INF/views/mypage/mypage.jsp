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
             <div>내가 등록한 글 <br/>

             </div>
             <div>내가 쓴 댓글 <br/>

             </div>
             <div>추천 한 글 <br/>

             </div>
             </div>
         </div>

         <div class="conbox con3">
             <div class="contbored">
                 <div>구독한 쉐프 :
                     <c:forEach items="${userlist.subList}" var="item" varStatus="i">
                         <span class="subbookspan"><c:out value="${item.target_id}"/></span>
                     </c:forEach>
                 </div>
             <div>즐겨 찾기 : ${userlist.bookList[0].post_no}
                 ${userlist.bookList[1].post_no}
                 ${userlist.bookList[2].post_no}
                 ${book[0].post_no}
                 ${book[0].userid}<br/>

             </div>
         </div>
         </div>

         <div class="conbox con4">
             <div class="contbored">
             <div>받은 쪽지 <br/>

             </div>
             <div>보낸 쪽지 <br/>

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