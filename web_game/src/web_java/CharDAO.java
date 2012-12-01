package web_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CharDAO {
	public static DataSource getDataSource() throws NamingException {
		Context initCtx = null;
		Context envCtx = null;

		// Obtain our environment naming context
		initCtx = new InitialContext();
		envCtx = (Context) initCtx.lookup("java:comp/env");

		// Look up our data source
		return (DataSource) envCtx.lookup("jdbc/WebDB");
	}
	public static character findById(String id) throws NamingException, SQLException{
		character charact = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		DataSource ds = getDataSource();
		
		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn.prepareStatement("SELECT * FROM game_player WHERE userId = ?");
			stmt.setString(1, id);
			
			// 수행
			rs = stmt.executeQuery();

			if (rs.next()) {
				charact = new character(rs.getString("userid"),rs.getString("name")
						,rs.getString("wish"),rs.getInt("hp"),rs.getInt("mp")
						,rs.getInt("attack"),rs.getInt("deffence"),rs.getInt("avata"));
				charact.setLevel(rs.getInt("level"));
				charact.setLocation(rs.getInt("location"));
				charact.setArmor(rs.getInt("armor"));
				charact.setWeapon(rs.getInt("weapon"));

				
			}	
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
		
		return charact;
	}
	public static boolean create(character charact) throws SQLException, NamingException {
		int result;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		DataSource ds = getDataSource();
		
		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn.prepareStatement(
					"INSERT INTO game_player(userId, name, wish,level," +
					"hp,mp,attack,deffence,avata) " +
					"VALUES(?, ?, ?,?,?,?,?,?,?)"
					);
			stmt.setString(1,  charact.getUserid());
			stmt.setString(2,  charact.getName());
			stmt.setString(3,  charact.getWish());
			stmt.setInt(4,  charact.getLevel());
			stmt.setInt(5,  charact.getHp());
			stmt.setInt(6,  charact.getMp());
			stmt.setInt(7,  charact.getAttack());
			stmt.setInt(8,  charact.getDeffence());
			stmt.setInt(9,  charact.getAvata());			
			// 수행
			result = stmt.executeUpdate();
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
		
		return (result == 1);
	}
	public static boolean remove(String name) throws NamingException, SQLException {
		int result;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		DataSource ds = getDataSource();
		
		try {
			conn = ds.getConnection();

			// 질의 준비
			stmt = conn.prepareStatement("DELETE FROM game_player WHERE name=?");
			stmt.setString(1,  name);
			
			// 수행
			result = stmt.executeUpdate();
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
		
		return (result == 1);		
	}
}
