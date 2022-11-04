<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/member.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>아이디 목록</title>
</head>
<body style="text-align: center">
    <div class="index-board">
        <table style="margin: auto; margin-top: 200px">
            <tr>
                <th id="colId">아이디 목록</th>
            </tr>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>
                            ${member.userid}
                    </td>
                </tr>
            </c:forEach>
        </table><br>
        <a href="/member/login" style="margin-right: 100px;"> 로그인 페이지로 </a>
        <a href="/member/findPW"> 비밀번호 찾기 </a>
    </div>

</body>
</html>
