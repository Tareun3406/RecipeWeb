<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>



<article class="index-board">
    <table style="margin-top: 20px">
        <caption id="communityCap"><h3>레시피 게시글</h3></caption>
        <tr id="tableCol">
            <th id="no">번호</th>
            <th id="title">제목</th>
            <th id="writer">작성자(id)</th>
            <th id="hit">조회수</th>
            <th id="report">신고수</th>
            <th id="date">작성일</th>
        </tr>
        <c:forEach items="${recipeList}" var="recipe">
            <tr>
                <td style="text-align: center">${recipe.post_no}</td>
                <td>${recipe.title}</td>
                <td style="text-align: center">${recipe.writer}</td>
                <td style="text-align: center">${recipe.hit}</td>
                <td style="text-align: center">${recipe.report}</td>
                <td style="text-align: center">${recipe.regdate}</td>
            </tr>
        </c:forEach>


    </table>
</article>

<jsp:include page="footer.jsp"/>
