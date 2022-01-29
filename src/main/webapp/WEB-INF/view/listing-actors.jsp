<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Indian Film Actors</title>
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"> -->
</head>
<body>
    <header>
        <h1>Indian film actors</h1>
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}">Return to the home</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <input type="button" value="Add" onclick="window.location.href='actors/addActor'; return false;" />
        <table>
            <tr>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Affiliation</th>
            </tr>
            <c:forEach var="actor" items="${actors}">
                <c:url var="updateActorLink" value="/actors/updateActor">
                    <c:param name="actorId" value="${actor.id}" />
                </c:url>
                <c:url var="deleteActorLink" value="/actors/deleteActor">
                    <c:param name="actorId" value="${actor.id}" />
                </c:url>
                <tr>
                    <td>${actor.firstName}</td>
                    <td>${actor.middleName}</td>
                    <td>${actor.lastName}</td>
                    <td>${actor.affiliation}</td>
                    <td><a href="${updateActorLink}">Update</a>
                    |
                    <a href="${deleteActorLink}" onclick="if (!(confirm('Are you sure you want to delete this Indian film actor?'))) return false;">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </main>
</body>
</html>
