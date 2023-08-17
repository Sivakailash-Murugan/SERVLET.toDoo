<!DOCTYPE html>
<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<style type="text/css">
		body {
			background-image:
				url("https://img.freepik.com/free-vector/hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg");
			background-size: cover;
		}
	</style>
</head>

<body>
<%
List<Task> tasks =(List<Task>)request.getAttribute("list");
%>
	<h1 align="center">Welcome to TODO Home</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Task Name</th>
			<th>Description</th>
			<th>Task Date</th>
			<th>Task Completion Date</th>
			<th>Status</th>
			<th>Change Status</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%for(Task task1:tasks) 
		{%>
		<tr>
			<td><%=task1.getId() %></td>
			<td><%=task1.getTaskname() %></td>
			<td><%=task1.getTaskDiscription() %></td>
			<td><%=task1.getTaskdate() %></td>
			<td><%=task1.getCompletiondate() %></td>
			<td><%if(task1.isStatus()) %>Completed<%else %>Not Completed</td>
			<td>
			<a href="changestatus?id=<%=task1.getId()%>"><button>Change</button></a></td>
			<td><a href="deletetask?id=<%=task1.getId()%>"><button>Delete</button></a></td>
			<td><a href="edittask?id=<%=task1.getId()%>"><button>Update</button></a></td>
		</tr>
		<%
		}
		%>

	</table>
	<br>
	<br>
	<a href="tasksession"><button style="margin-left: 20px">Add
			Task</button></a>
	<a href="logout"><button style="margin-left: 500px">Logout</button></a>
</body>

</html>