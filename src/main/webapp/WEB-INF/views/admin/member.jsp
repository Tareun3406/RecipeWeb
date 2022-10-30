<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<script>
</script>
<div>
    <form>
        <input type="text" name="idSearch">
    </form>
    <article class="index-board">
        <table>
            <tr id="tableCol">
                <th id="colId">아이디</th> <th id="colEmail">이메일</th> <th id="colName">닉네임</th> <th>수정/삭제</th>
            </tr>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.userid}</td> <td>${member.email}</td> <td>${member.nickname}</td>
                    <td>
                        <form action="member/edit" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token">
                            <input type="hidden" name="userid" value="${member.userid}">
                            <button type="submit">수정</button>
                            <button type="button">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </article>
</div>

<jsp:include page="footer.jsp"/>