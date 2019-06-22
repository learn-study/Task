<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Task New</title>
</head>
<body>
	<h1>Create New Task</h1>
	<form action="NewTask" method="POST">
		<div>
			<label>Task</label>
			<input type="text" name="task">
		</div>
		<div>
			<label>Status</label>
			<input type="text" name="status">
		</div>
		<input type="submit">
	</form>
    <%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
</body>
</html>