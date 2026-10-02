<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <title>المهمة غير موجودة</title>
</head>
<body>

<h1>404 — المهمة غير موجودة</h1>

<p><c:out value="${message}"/></p>

<a href="<c:url value='/tasks'/>">العودة للمهام</a>

</body>
</html>