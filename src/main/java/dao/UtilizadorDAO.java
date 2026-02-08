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
		
		String sql="INSERT INTO utilizadores (Nome, Username, Email, SenhaHash, NivelAcesso)"
				+ "VALUES (?,?,?,?,?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getSenha());
			stmt.setString(5, u.getNivel());
			stmt.executeUpdate();
		}
	}
	
	// Apagar Utilizador
	public void apagarUtilizador(int id) throws SQLException {
		String sql = "DELETE FROM utilizadores where idUtilizador=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}
	
	// Editar Utilizador
	public void editarUtilizador(Utilizador u) throws SQLException {
		
		String sql = "UPDATE utilizadores set Nome=?, Username=?, SenhaHash=?, Email=?, NivelAcesso=?  where idUtilizador = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getUsername());
			stmt.setString(3, u.getSenha());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getNivel());
			stmt.setInt(6, u.getIdUtilizador());
			stmt.executeUpdate();
		}
	}
	
	// Buscar ID
		public Utilizador buscarPorId(int id) throws SQLException {
			
			String sql = "SELECT * FROM utilizadores where idUtilizador=?";

			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, id);
				
				try(ResultSet rs = stmt.executeQuery()){
					if(rs.next()) {
						Utilizador u = new Utilizador
								(rs.getString("Nome"),
								(rs.getString("Username")),
								(rs.getString("Email")),
								(rs.getString("SenhaHash")),
								(rs.getString("NivelAcesso")));
								u.setIdUtilizador(rs.getInt("idUtilizador"));
						return u;
					}
					return null;
				}
			}	
		}
}
