<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.Task"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
List<Task> tasklist =(ArrayList<Task>)request.getAttribute("Tasks");
%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>日報管理システム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>TaskApp</h1>
                  <ul>
                    <% for(Task task: tasklist){ %>
                      <li>
                        <a href="show?id=<%=task.getId() %>"><%=task.getId() %></a>:
                        <%=task.getTask() %>:
                        <%=task.getStatus() %>
                      </li>
                    <% } %>
                  </ul>
            </div>
            <%@ include file="/WEB-INF/views/layouts/footer.jsp"%>
        </div>
    </body>
</html>