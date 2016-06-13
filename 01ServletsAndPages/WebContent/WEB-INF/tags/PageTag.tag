<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentdate" value="<%= new java.util.Date() %>" />

<%@ attribute name="head"%>
<%@ attribute name="title"%>
<%@ attribute name="version"%>
<%@ attribute name="shouldPrintDate"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body>
	<h1>${head}</h1>
	<hr>
	<div>
		<jsp:doBody/>
	</div>
	<hr>
	<div>
		Version ${version}
	</div>
	<div>
		<c:if test='${shouldPrintDate == "true"}'>
			Date ${currentdate}
		</c:if>
	</div>
</body>
</html>