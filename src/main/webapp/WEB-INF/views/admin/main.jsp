<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet" type="text/css">
    <title>관리 페이지</title>
</head>
<body>
<div id="mainList">
    <ul>
        <li>
            <a href="/">
                <span class="material-symbols-outlined">home</span>
                메인페이지
            </a>
        </li>
        <li>
            <a href="admin/recipe">
                <span class="material-symbols-outlined">note_alt</span>
                레시피 관리
            </a>
        </li>
        <li>
            <a href="admin/community">
                <span class="material-symbols-outlined">speaker_notes</span>
                커뮤니티 관리
            </a>
        </li>
        <li>
            <a href="admin/member">
                <span class="material-symbols-outlined">person</span>
                회원 관리
            </a>
        </li>
    </ul>
</div>
</body>
</html>
