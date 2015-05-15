<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="utilisateur" items="${utilisateurConnecte}">
	<h1>${utilisateurConnecte}</h1>
</c:forEach>