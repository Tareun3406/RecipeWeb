<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<link href="${pageContext.request.contextPath}/resources/css/member.css" rel="stylesheet" type="text/css">

<script>
</script>
<div>
  <form>
    <input type="text" name="idSearch">
  </form>
  <article class="memberEdit">
    <form id="editForm" method="post" action="editUpdate">
      <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
        <span class="rowName">아이디</span>
        <span class="inputArea">
            <input type="hidden" name="userid" id="userid" value="${member.userid}">
            <span style="font-size: 18px">${member.userid}</span>
        </span>
      </div>
      <div>
        <span class="rowName">비밀번호</span>
        <span class="inputArea">
            <input type="password" size="45" name="userpw">
        </span>
      </div>
      <div>
        <span class="rowName">비밀번호 확인</span>
        <span class="inputArea">
            <input type="password" size="45" name="pwCheck">
        </span>
      </div>
      <div>
        <span class="rowName">닉네임</span>
        <span class="inputArea">
            <input type="text" size="45" name="nickname" value="${member.nickname}">
        </span>
      </div>
      <div>
        <span class="rowName">이메일</span>
        <span class="inputArea">
            <input type="text" size="45" name="email" value="${member.email}">
        </span>
      </div>
      <div class="joinBtnDiv">
        <button type="button" onclick="location.href='/admin/member'">목록으로</button>
        <button type="submit" style="float: right">정보수정</button>
      </div>
    </form>
  </article>
</div>

<jsp:include page="footer.jsp"/>