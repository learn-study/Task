package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Task {
	private int id;
	private String task;
	private String status;
	private static final String DBConnection = "jdbc:mysql://localhost:3360/taskapp?verifyServerCertificate=false&useSSL=false&requireSSL=false";
	public Task() {}
	public Task(String task, String status) {
		this.task  = task;
		this.status= status;
	}
	public Task(int id, String task, String status) {
		this.id = id;
		this.task  = task;
		this.status= status;
	}
	//setter getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//Create
	public boolean save(){
		Connection con = null;
		PreparedStatement pStmt = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBConnection,"root","password");

			con.setAutoCommit(false);

			String sql = "insert into tasks(task,status)" + "values(?,?);";
			pStmt = con.prepareStatement(sql);

			pStmt.setString(1,  this.getTask());
			pStmt.setString(2,  this.getStatus());

			if( pStmt.executeUpdate() > 0) {
				con.commit();
			}else{
				con.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	//Read（All）
	public static List<Task> all() {
		Connection con = null;
		PreparedStatement pStmt = null;
		List<Task> tasklist = new ArrayList<Task>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBConnection,"root","password");

			String sql = "select * from tasks";
			pStmt = con.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				int id        = rs.getInt("id");
				String task   = rs.getString("task");
				String status = rs.getString("status");

				Task model = new Task(id,task,status);

				tasklist.add(model);
			}

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		return tasklist;
	}
	//Read(Object)
	public static Task findOne(String objectid) {
		Connection con = null;
		PreparedStatement pStmt = null;
		Task model = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBConnection,"root","password");

			String sql = "select * from tasks where id = ?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, objectid);

			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				int id        = rs.getInt("id");
				String task   = rs.getString("task");
				String status = rs.getString("status");

				model = new Task(id,task,status);
			}

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		return model;
	}
	//Update
	public boolean update(String task, String status){
		Connection con = null;
		PreparedStatement pStmt = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBConnection,"root","password");

			con.setAutoCommit(false);

			String sql = "update tasks set task=?,status=? where id=?;";
			pStmt = con.prepareStatement(sql);

			pStmt.setString(1, task);
			pStmt.setString(2, status);
			pStmt.setInt(3, this.getId());

			if( pStmt.executeUpdate() > 0) {
				con.commit();
			}else{
				con.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	//Delete
	public static boolean destroy(String objid){
		Connection con = null;
		PreparedStatement pStmt = null;
		Task model = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DBConnection,"root","password");

			String sql = "delete from tasks where id = ?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, objid);
			if( pStmt.executeUpdate() > 0) {
				con.commit();
			}else{
				con.rollback();
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
