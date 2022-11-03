<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>



<article class="index-board">
    <table style="margin-top: 20px">
        <caption id="communityCap"><h3>레시피 게시글</h3>
        <form method="get" action="/admin/recipe" style="display: inline-block; float: right">
            <input type="text" size="30" name="search" style="margin-bottom: 10px">
            <input type="submit" value="검색">
        </form>
        </caption>
        <tr id="tableCol">
            <th id="no">번호</th>
            <th id="title">제목</th>
            <th id="writer">작성자(id)</th>
            <th id="hit">조회수</th>
            <th id="report">신고수</th>
            <th id="date">작성일</th>
        </tr>
        <c:forEach items="${recipeList}" var="recipe">
            <tr onclick="location.href='/content?post_no=${recipe.post_no}'">
                <td style="text-align: center">${recipe.post_no}</td>
                <td>${recipe.title}</td>
                <td style="text-align: center">${recipe.writer}</td>
                <td style="text-align: center">${recipe.hit}</td>
                <td style="text-align: center">${recipe.report}</td>
                <td style="text-align: center">${recipe.regdate}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <c:forEach var="i" begin="1" end="${totalPage}">
        <c:if test="${i == page}">
            <c:out value="[${page}]"/>
        </c:if>
        <c:if test="${i != page}">
            <c:if test="${search == ''}">
                <a href="/admin/recipe?page=${i}">${i}</a>
            </c:if>
            <c:if test="${search != ''}">
                <a href="/admin/recipe?search=${search}&page=${i}">${i}</a>
            </c:if>
        </c:if>
        &nbsp
    </c:forEach>
</article>

<jsp:include page="footer.jsp"/>
