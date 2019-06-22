<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Task New</title>
</head>
<body>
	<h1>Task:${Task.id}</h1>
	<div>
	${Task.task}
	${Task.status}
	</div>
	<a href="taskedit?id=${Task.id}">edit</a> | <a href="taskdelete?id=${Task.id}">delete</a>
    <%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>