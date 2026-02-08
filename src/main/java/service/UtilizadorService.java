package service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.UtilizadorDAO;
import model.Utilizador;

public class UtilizadorService {
	private UtilizadorDAO dao;

	public UtilizadorService(Connection conn) {
		this.dao = new UtilizadorDAO(conn);
	}
	
	// LOGIN
	public Utilizador login(String username, String senha) throws Exception {
		String hash = gerarHash(senha);
		List<Utilizador> users = dao.listarUtilizadores();
		for(Utilizador u : users) { 
			if(u.getUsername().equals(username) && u.getSenha().equals(hash)) {
				return u;
			}
		}
		return null;
	}
	
	// HASH
	public static String gerarHash(String senha) throws NoSuchAlgorithmException {
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256"); // criar instancia do algoritmo
		
		byte[] hash = digest.digest(senha.trim().getBytes(StandardCharsets.UTF_8)); // converte senha em bytes para gerar o hash
		StringBuilder hex = new StringBuilder();
		for(byte b : hash) {
			hex.append(String.format("%02x", b));
		}
		return hex.toString();
	}
	
	// LISTA UTILIZADORES
	public List<Utilizador> listaUtilizadores() throws SQLException {
		return dao.listarUtilizadores();
	}
	
	// INSERIR NOVO UTILIZADOR
	public void criarUtilizador(Utilizador u) throws Exception {
		dao.inserirUtilizador(u);
	}
		
	// APAGAR UTILIZADOR
	public void apagarUtilizador(int id) throws SQLException {
		dao.apagarUtilizador(id);
	}
	
	// BUSCAR ID
	public Utilizador buscarId(int id) throws SQLException {
		return dao.buscarPorId(id);
	}
	
	// EDITAR UTILIZADOR
	public void editarUtilizador(Utilizador u) throws SQLException {
		dao.editarUtilizador(u);
	}
}
