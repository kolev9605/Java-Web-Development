<%@page import="java.util.Date"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="currentdate" value="<%= new java.util.Date() %>" />

<ct:PageTag head="This is table using page tag" version="420" shouldPrintDate="true" title="Title">
	<jsp:body>
		<table border = "1">
			<thead>
				<tr>
					<th>Topic</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Intro</td>
					<td>${currentdate}</td>
				</tr>
				<tr>
					<td>Servlets and Pages</td>
					<td>${currentdate}</td>
				</tr>
			</tbody>
		</table>
	</jsp:body>
</ct:PageTag>