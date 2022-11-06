<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/resources/css/member.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>아이디 목록</title>
</head>
<body>
    <table>
        <tr>
            <td>아이디 목록</td>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>
                    ${member.userid}
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <a href="/member/login"> 로그인 페이지로 </a>
                <a href="/member/findPW"> 비밀번호 찾기 </a>
            </td>
        </tr>
    </table>
</body>
</html>
