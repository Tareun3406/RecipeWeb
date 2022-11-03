<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/member.css" rel="stylesheet" type="text/css">
</head>
<body onload="onLoadInvalidCheck()">
<form id="joinForm" action="editUpdate" method="post" onsubmit="return joinCheck()">
    <div class="caption" style="margin: 20px">
        <h3 style="display: inline-block">회원수정</h3>
        <span style="display:inline-block;border: solid 1px; width: 100px; height: 50px; float: right">
                로고
        </span>
    </div>
    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
        <span class="rowName">아이디</span>
        <span class="inputArea">
            <input type="text" size="45" name="userid" id="userid" value="${member.userid}" readonly/>
    </span>
    </div>
    <div>
        <span class="rowName">비밀번호</span>
        <span class="inputArea">
            <input type="password" size="45" name="userpw" id="userpw" onchange="pwCheckOnChange()">
        </span>
    </div>
    <div>
        <span class="rowName">비밀번호 확인</span>
        <span class="inputArea">
            <input type="password" size="45" name="pwCheck" id="pwCheck" onchange="pwCheckOnChange()">
        </span>
        <span id="pwCheckMessage" style="margin-top: 5px; display: inline-block">&nbsp;</span>
    </div>
    <div>
        <span class="rowName">닉네임</span>
        <span class="inputArea">
            <input type="text" size="45" name="nickname" id="nickname"
                   value="${member.nickname}" onchange="nickNameOnChange()">
        </span>
        <span id="nickNameCheckMessage" style="margin-top: 5px; display: inline-block">&nbsp;</span>
    </div>
    <div>
        <span class="rowName">이메일</span>
        <span class="inputArea">
            <input type="text" size="45" name="email" id="email"
                   value="${member.email}" onchange="emailOnChangeCheck()">
        </span>
        <span id="emailCheckMessage" style="margin-top: 5px; display: inline-block">&nbsp;</span>
    </div>
    <div class="joinBtnDiv">
        <button type="button" onclick="location.href='/admin/member'">관리 페이지로</button>
        <button type="submit" style="float: right">확인</button>
    </div>
    <script>

    </script>
</form>
</body>
</html>
