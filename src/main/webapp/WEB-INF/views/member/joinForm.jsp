<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/member.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/member.css" rel="stylesheet" type="text/css">
</head>
<body>
<form id="joinForm" method="post">
    <div class="caption" style="margin: 20px">
        <h3 style="display: inline-block">회원가입</h3>
        <span style="display:inline-block;border: solid 1px; width: 100px; height: 50px; float: right">
                로고
        </span>
    </div>
    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
        <span class="rowName">아이디</span>
        <span class="inputArea">
            <input type="text" size="45" name="userid" id="userid">
        </span>
        <button type="button" onclick="id_check()">중복확인</button>
        <span id="idCheckMessage"></span>
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
            <input type="text" size="45" name="nickname">
        </span>
    </div>
    <div>
        <span class="rowName">이메일</span>
        <span class="inputArea">
            <input type="text" size="45" name="email">
        </span>
    </div>
    <!--
    <div>
        <span class="rowName">주소</span>
        <span class="inputArea">
            <input type="text" size="45" name="address1">
        </span>
    </div>
    <div>
        <span class="rowName">상세주소</span>
        <span class="inputArea">
            <input type="text" size="45" name="address2">
        </span>
     </div>
     -->
    <div class="joinBtnDiv">
        <button type="submit">회원가입</button>
    </div>

</form>
</body>
</html>
