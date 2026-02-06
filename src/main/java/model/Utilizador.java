package model;

public class Utilizador {

	private int idUtilizador;
	private String nome;
	private String username;
	private String email;
	private String senha;
	private String nivel;
	
	public Utilizador(String nome, String username, String email, String senha, String nivel) {
		this.nome = nome;
		this.username = username;
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
	}
	
	public int getIdUtilizador() {
		return idUtilizador;
	}
	public void setIdUtilizador(int idUtilizador) {
		this.idUtilizador = idUtilizador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
}
