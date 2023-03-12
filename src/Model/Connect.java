package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connect {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;

	public Connection connect() {
		// TODO Auto-generated method stub
		
		try{
			   String userName = "root";
			   String password = "";
			   String url = "jdbc:mysql://localhost:3306/javack";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
			   System.out.println("Ok");
//			   
//			   String sql = "SELECT * FROM quanlysinhvien";
//			   PreparedStatement stm = conn.prepareStatement(sql);
//			   ResultSet rs = stm.executeQuery();
//			   while(rs.next()) {
//				   System.out.println(rs.getInt(1) + "\t" + rs.getString(2));			   }
		} catch(Exception e){
		   e.printStackTrace();
		}
		return conn;
		
	}
	public int executeDB(String sql) { //insert, update, delete
		int record=0;
		try {
			connect();
			stmt = conn.createStatement();
			record = stmt.executeUpdate(sql); //so luong hang thay doi sau khi thuc hien 1 trong 3 cau lenh tren
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return record;
	}
	public ResultSet listAll(String sql) {
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				//conn.close();
				//stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return rs;
	
	}
	public static void main(String [] agrs) {
		new Connect().connect();
	}



}
