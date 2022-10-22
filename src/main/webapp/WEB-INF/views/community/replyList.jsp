<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../main/header.jsp" flush="false" />
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">

<body>
    <table style="width:700px">
        <!-- 댓글 목록 -->
        <c:forEach var="row" items="${list}">
        <tr>    
            <td align="center">${fn:substring(row.regdate,2,16)}</td>
            <%-- 0이상 10미만 사이의 년월일만 반환--%>
				<td>			
                <br>
                ${row.content}
                <hr>    
            </td>
        </tr>
        </c:forEach>
        <!-- **페이징 처리 -->
        <tr>
            <td>
                <!-- 현재 페이지 블럭이 1보다 크면 처음으로 이동 -->
                <c:if test="${replyPager.curBlock > 1}">
                    <a href="javascript:listReply('1')">[처음]</a>
                </c:if>
                <!-- 현재 페이지 블럭이 1보다 크면 이전 페이지 블럭으로 이동 -->
                <c:if test="${replyPager.curBlock > 1}">
                    <a href="javascript:listReply('${replyPager.prevPage}')">[이전]</a>
                </c:if>
                <!-- 페이지 블럭 처음부터 마지막 블럭까지 1씩 증가하는 페이지 출력 -->
                <c:forEach var="num" begin="${replyPager.blockBegin}" end="${replyPager.blockEnd}">
                    <c:choose>
                        <c:when test="${num == replyPager.curPage}">
                            ${num}&nbsp;
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:listReply('${num}')">${num}</a>&nbsp;
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <!-- 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 다음페이지로 이동 -->
                <c:if test="${replyPager.curBlock <= replyPager.totBlock}">
                    <a href="javascript:listReply('${replyPager.nextPage}')">[다음]</a>
                </c:if>
                <!-- 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 끝으로 이동 -->
                <c:if test="${replyPager.curBlock <= replyPager.totBlock}">
                    <a href="javascript:listReply('${replyPager.totPage}')">[끝]</a>
                </c:if>
            </td>
        </tr>
    </table>

<jsp:include page="../main/footer.jsp" flush="false"/>