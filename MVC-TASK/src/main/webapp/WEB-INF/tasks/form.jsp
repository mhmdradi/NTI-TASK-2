<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <title>مهمة جديدة</title>

    <style>
        .error {
            color: #b00020;
            display: block;
        }
    </style>
</head>
<body>

<h1>إنشاء مهمة</h1>

<c:url var="createUrl" value="/tasks"/>

<form:form method="post"
           action="${createUrl}"
           modelAttribute="task"
           htmlEscape="true">

    <p>
        <form:label path="title">العنوان</form:label>
        <form:input path="title"/>
        <form:errors path="title" cssClass="error"/>
    </p>

    <p>
        <form:label path="priority">الأولوية</form:label>

        <form:select path="priority">
            <form:option value="" label="-- اختر الأولوية --"/>
            <form:options items="${priorities}"/>
        </form:select>

        <form:errors path="priority" cssClass="error"/>
    </p>

    <p>
        <form:checkbox path="completed"/>
        <form:label path="completed">مكتملة</form:label>
        <form:errors path="completed" cssClass="error"/>
    </p>

    <button type="submit">حفظ</button>

</form:form>

<a href="<c:url value='/tasks'/>">العودة للمهام</a>

</body>
</html>