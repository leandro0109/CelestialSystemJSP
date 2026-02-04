package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Utilizador;

public class UtilizadorDAO {
	private Connection conn;

	public UtilizadorDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	// Listar Utilizadores 
	public List<Utilizador> listarUtilizadores() throws SQLException{
		
		List<Utilizador> listaUtilizadores = new ArrayList<>();
		
		String sql = "SELECT IdUtilizador, Nome, Username, Email, SenhaHash, NivelAcesso FROM Utilizadores";
		try(PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			
			while(rs.next()) {
				
				Utilizador u = new Utilizador
						((rs.getInt("IdUtilizador")),
						(rs.getString("Nome")),
						(rs.getString("Username")),
						(rs.getString("Email")),
						(rs.getString("SenhaHash")),
						(rs.getString("NivelAcesso")));
				listaUtilizadores.add(u);
			}	
			return listaUtilizadores;
		}
		
	}
	
}
