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
						(rs.getString("Nome"),
						(rs.getString("Username")),
						(rs.getString("Email")),
						(rs.getString("SenhaHash")),
						(rs.getString("NivelAcesso")));
						u.setIdUtilizador(rs.getInt("idUtilizador"));
				listaUtilizadores.add(u);
			}	
			return listaUtilizadores;
		}
	}
	
	// Inserir Utilizador Novo
	public void inserirUtilizador(Utilizador u) throws SQLException {
		
		String sql="INSERT INTO utilizadores (idUtilizador, Nome, Username, Email, SenhaHash, NivelAcesso)"
				+ "VALUES (?,?,?,?,?,?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setInt(1, u.getIdUtilizador());
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getUsername());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getSenha());
			stmt.setString(6, u.getNivel());
		}
	}
}
