<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../css/member.css" rel="stylesheet" type="text/css">
    <title>로그인</title>
</head>

<body>
<header>
    <div class="logo">로고</div>
</header>
<form>
    <div class="CheckArea">
        <input type="checkbox" name="keepLoginCheck">로그인 유지
    </div>
    <div class="inputArea">
        <input type="text" size="45" name="id" placeholder="아이디">
    </div>
    <div class="inputArea">
        <input type="password" size="45" name="pw" placeholder="비밀번호">
    </div>
    <div >
        <button type="submit" name="loginBtn" class="loginBtn">로그인</button>
    </div>
</form>
<div class="helpInfo">
    <a href="#">아이디 찾기</a> | <a href="#">비밀번호 찾기</a> | <a href="#">회원가입</a>
</div>
</body>


</html>
