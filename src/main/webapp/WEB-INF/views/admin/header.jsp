<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet" type="text/css">
    <title>관리페이지</title>
</head>
<body>
<header>
    <div>
        <ul>
            <li>
                <a href="/">메인페이지</a>
            </li>
            <li>
                <a href="/admin/recipe">레시피 관리</a>
            </li>
            <li>
                <a href="/admin/community">커뮤니티 관리</a>
            </li>
            <li>
                <a href="/admin/member">회원 관리</a>
            </li>
        </ul>
    </div>
</header>