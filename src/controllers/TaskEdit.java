package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;

/**
 * Servlet implementation class TaskEdit
 */
@WebServlet("/taskedit")
public class TaskEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Task task = Task.findOne(id);

		request.setAttribute("Task", task);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/task/edit.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id     = request.getParameter("id");
		String task   = request.getParameter("task");
		String status = request.getParameter("status");
		Task taskModel = Task.findOne(id);
		taskModel.update(task,status);

		response.sendRedirect("index.html");
	}

}
