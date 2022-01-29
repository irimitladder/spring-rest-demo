<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Indian Film Actors &mdash; Add or Update Actor</title>
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"> -->
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/add-or-update-customer-styles.css"> -->
</head>
<body>
    <header>
        <h1><c:if test="${empty actor.id}">Add a new Indian film actor</c:if><c:if test="${not empty actor.id}">Update an Indian film actor</c:if></h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}">Return to the home</a></li>
                <li><a href="${pageContext.request.contextPath}/actors">Return to the list</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <form:form action="${pageContext.request.contextPath}/actors/saveActor" modelAttribute="actor" method="POST">
            <form:hidden path="id" />
            <table>
                <tr>
                    <td><label for="first_name">First name:</label></td>
                    <td><form:input id="first_name" path="firstName" /></td>
                </tr>
                <tr>
                    <td><label for="middle_name">Middle name:</label></td>
                    <td><form:input id="middle_name" path="middleName" /></td>
                </tr>
                <tr>
                    <td><label for="last_name">Last name:</label></td>
                    <td><form:input id="last_name" path="lastName" /></td>
                </tr>
                <tr>
                    <td><label for="affiliation">Affiliation:</label></td>
                    <td><form:input id="affiliation" path="affiliation" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
    </main>
</body>
</html>
