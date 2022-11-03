<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>



<article class="index-board">
    <table style="margin-top: 20px">
        <caption id="communityCap">
            <h3>자유게시판</h3>
        <form method="get" action="/admin/community" style="display: inline-block; float: right">
            <input type="text" size="30" name="search" style="margin-bottom: 10px">
            <input type="submit" value="검색">
        </form>
        </caption>
        <tr id="tableCol">
            <th id="no">번호</th>
            <th id="title">제목</th>
            <th id="writer">작성자(id)</th>
            <th id="hit">조회수</th>
            <th id="date">작성일</th>
        </tr>
        <c:forEach items="${commuList}" var="commu">
            <tr>
                <td style="text-align: center">${commu.comu_no}</td>
                <td>${commu.title}</td>
                <td style="text-align: center">${commu.writer}</td>
                <td style="text-align: center">${commu.viewcnt}</td>
                <td style="text-align: center">${commu.regdate}</td>
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
                <a href="/admin/community?page=${i}">${i}</a>
            </c:if>
            <c:if test="${search != ''}">
                <a href="/admin/community?search=${search}&page=${i}">${i}</a>
            </c:if>
        </c:if>
        &nbsp
    </c:forEach>
</article>

<jsp:include page="footer.jsp"/>
