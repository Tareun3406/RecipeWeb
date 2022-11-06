<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../../resources/css/member.css" rel="stylesheet" type="text/css">
    <title>로그인</title>
</head>

<body id="loginForm">
<header>

    <div class="logo"><a href="/">로고</a></div>
</header>
<form action="/login" method="post">
    <%-- 위조방지 토큰 --%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <div class="checkArea">
        <input type="checkbox" name="idSave" id="idSave"> 아이디 저장
        <input type="checkbox" name="remember-me" id="rememberMe"
               onchange="rememberMEOnChange(this)" style="margin-left: 20px">로그인 유지
    </div>
    <div class="inputArea">
        <input type="text" size="45" name="userid" id="userid" placeholder="아이디">
    </div>
    <div class="inputArea">
        <input type="password" size="45" name="userpw" placeholder="비밀번호">
    </div>
    <div>
        <button type="submit" name="loginBtn" class="loginBtn" onclick="loginOnClick()">로그인</button>
    </div>
    <div>
        <span style="margin: 20px; color: indianred">${error}</span>
    </div>

</form>
<div class="helpInfo">
    <a href="findID">아이디 찾기</a> | <a href="findPW">비밀번호 찾기</a> | <a href="join">회원가입</a>
</div>

<script>
    window.onload = function() {
        const userIdForm = document.getElementById('userid');
        const saveIdCheckBox = document.getElementById('idSave')
        if (getCookie("idSave")) { // getCookie함수로 id라는 이름의 쿠키를 불러와서 있을경우
            userIdForm.value = getCookie("idSave"); //input 이름이 id인곳에 getCookie("id")값을 넣어줌
            saveIdCheckBox.checked = true; // 체크는 체크됨으로
        }
    }

    function loginOnClick(){
        const checkIdSave = document.getElementById('idSave');
        const userId = document.getElementById('userid');
        if (checkIdSave.checked){
            setCookie("idSave",userId.value,7);
        }else{
            setCookie("idSave",userId.value,0);
        }
    }

    function setCookie(name, value, expiredays) //쿠키 저장함수
    {
        const todayDate = new Date();
        todayDate.setDate(todayDate.getDate() + expiredays);
        document.cookie = name + "=" + escape(value) + "; path=/; expires="
            + todayDate.toGMTString() + ";"
    }

    function getCookie(Name) { // 쿠키 불러오는 함수
        let search = Name + "=";
        if (document.cookie.length > 0) { // if there are any cookies
            let offset = document.cookie.indexOf(search);
            if (offset !== -1) { // if cookie exists
                offset += search.length; // set index of beginning of value
                let end = document.cookie.indexOf(";", offset); // set index of end of cookie value
                if (end === -1)
                    end = document.cookie.length;
                return unescape(document.cookie.substring(offset, end));
            }
        }
    }

    function rememberMEOnChange(checkBox){
        const idSaveCheckBox = document.getElementById('idSave');
        if(checkBox.checked){
            idSaveCheckBox.checked = true;
            idSaveCheckBox.disabled = true;
        }else{
            idSaveCheckBox.disabled = false;
        }
    }
</script>
</body>
</html>
