<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <title>المهام</title>
</head>
<body>

<h1><c:out value="${heading}"/></h1>

<nav>
    <a href="<c:url value='/tasks'/>">كل المهام</a>
    |
    <a href="<c:url value='/tasks/new'/>">مهمة جديدة</a>
    |
    <a href="<c:url value='/tasks/search'/>">
        البحث بالقيمة الافتراضية HIGH
    </a>

    <c:forEach var="priority" items="${priorities}">
        <c:url var="searchUrl" value="/tasks/search">
            <c:param name="priority" value="${priority}"/>
        </c:url>

        |
        <a href="<c:out value='${searchUrl}'/>">
            <c:out value="${priority}"/>
        </a>
    </c:forEach>
</nav>

<c:choose>
    <c:when test="${empty tasks}">
        <p>لا توجد مهام.</p>
    </c:when>

    <c:otherwise>
        <table border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>العنوان</th>
                <th>الأولوية</th>
                <th>مكتملة؟</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="task" items="${tasks}">
                <c:url var="detailUrl" value="/tasks/${task.id}"/>

                <tr>
                    <td><c:out value="${task.id}"/></td>

                    <td>
                        <a href="<c:out value='${detailUrl}'/>">
                            <c:out value="${task.title}"/>
                        </a>
                    </td>

                    <td><c:out value="${task.priority}"/></td>

                    <td>
                        <c:out value="${task.completed ? 'نعم' : 'لا'}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>