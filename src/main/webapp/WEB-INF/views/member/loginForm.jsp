<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/css/member.css" rel="stylesheet" type="text/css">
    <title>로그인</title>
</head>

<body id="loginForm">
<header>
    <div class="logo">로고</div>
</header>
<form action="/login" method="post">
    <%-- 위조방지 토큰 --%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <div class="checkArea">
        <input type="checkbox" name="keepLoginCheck">로그인 유지
    </div>
    <div class="inputArea">
        <input type="text" size="45" name="userid" placeholder="아이디">
    </div>
    <div class="inputArea">
        <input type="password" size="45" name="userpw" placeholder="비밀번호">
    </div>
    <div>
        <button type="submit" name="loginBtn" class="loginBtn">로그인</button>
    </div>

</form>
<div class="helpInfo">
    <a href="findID">아이디 찾기</a> | <a href="findPW">비밀번호 찾기</a> | <a href="join">회원가입</a>
</div>

</body>
</html>
