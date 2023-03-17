package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountDAO {

	static String url = "jdbc:mysql://localhost:3306/banco";
	
	static String sql;

	public static void createAccount(Usuario user) {
		try (Connection conn = DriverManager.getConnection(url, "root", "senha")) {
			
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO login (email, senha) VALUES (?, ?)";

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, user.getEmail());
				ps.setString(2, user.getSenha());
				ps.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.err.println("ERROR SALVANDO CONTA");
			}

			

			conn.commit();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
