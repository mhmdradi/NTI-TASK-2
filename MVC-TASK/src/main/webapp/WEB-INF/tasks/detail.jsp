<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <title>تفاصيل المهمة</title>
</head>
<body>

<h1><c:out value="${task.title}"/></h1>

<p>ID: <c:out value="${task.id}"/></p>

<p>
    الأولوية:
    <c:out value="${task.priority}"/>
</p>

<p>
    مكتملة؟
    <c:out value="${task.completed ? 'نعم' : 'لا'}"/>
</p>

<a href="<c:url value='/tasks'/>">العودة للمهام</a>

</body>
</html>