package studentmanagement.persistant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import studentmanagement.persistant.dto.RequestDTO;
import studentmanagement.persistant.dto.ResponseDTO;


public class StudentDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "orokamonotachi123";
	protected Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =  DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connection Successful");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class not found");
		} catch (SQLException e) {
			System.out.println("Connection not found");
		}
		return con;
	}
	
	//insert method 
	public int insertData(RequestDTO dto) {
		int result=0;
		Connection con=getConnection();
		String sql="insert into student (student_name,student_email,student_age,student_address,student_ph)"
				+"values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getStuName());
			ps.setString(2, dto.getStuEmail());
			ps.setInt(3, dto.getStuAge());
			ps.setString(4, dto.getStuAddress());
			ps.setString(5, dto.getStuPh());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Insert Error");
		}
		return result;
	}

	//update method
	public int updateData(RequestDTO dto) {
		int result=0;
		Connection con=getConnection();
		String sql="update student set student_name=?,student_email=?,student_age=?,student_address=?,student_ph=?"
				+"where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getStuName());
			ps.setString(2, dto.getStuEmail());
			ps.setInt(3, dto.getStuAge());
			ps.setString(4, dto.getStuAddress());
			ps.setString(5, dto.getStuPh());
			ps.setInt(6, dto.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update Error");
		}
		return result;
	}
	
	//delete method
	
	public int deleteData(RequestDTO dto) {
		int result=0;
		Connection con=getConnection();
		String sql="delete from student where id=?";	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete Error");
		}
		return result;
	}
	
		//display one
	public ResponseDTO selectOne(RequestDTO dto) {
		Connection con=getConnection();
			ResponseDTO res = new ResponseDTO();
			String sql="select * from student where id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, dto.getId());
				ResultSet rs = ps.executeQuery(); 
				while(rs.next()) {
					res.setId(rs.getInt("id"));
					res.setStuName(rs.getString("student_name"));
					res.setStuEmail(rs.getString("student_email"));
					res.setStuAge(rs.getInt("student_age"));
					res.setStuAddress(rs.getString("student_address"));
					res.setStuPh(rs.getString("student_ph"));
				}
			} catch (SQLException e) {
				System.out.println("Select one Error");
			}
			return res;
		}	
	
	//display all
	public ArrayList<ResponseDTO> selectAll(){
		Connection con=getConnection();
		ArrayList<ResponseDTO> list = new ArrayList();
		String sql="select * from student";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ResponseDTO dto = new ResponseDTO();
				dto.setId(rs.getInt("id"));
				dto.setStuName(rs.getString("student_name"));
				dto.setStuEmail(rs.getString("student_email"));
				dto.setStuAge(rs.getInt("student_age"));
				dto.setStuAddress(rs.getString("student_address"));
				dto.setStuPh(rs.getString("student_ph"));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("Display all Error");
		}
		return list;
	}	
}
