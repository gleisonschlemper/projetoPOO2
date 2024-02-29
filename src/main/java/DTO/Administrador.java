package DTO;

public class Administrador extends Pessoa {
	private static String cargo = "Administrador";

	public Administrador() {}
	
	public Administrador(int codigo) {
		super(codigo);
	}
	
	public Administrador(String cpf){
		super(cpf);
	}
	
	public Administrador(String email, String senha){
		super(email, senha);
	}
	
	public Administrador(int codigo, String cpf, String nome,String sobrenome, String email, String senha) {
		super(codigo, cpf, nome, sobrenome, email, senha);
	}
	
	public Administrador(String cpf, String nome, String sobrenome, String email, String senha) {
		super(cpf, nome, sobrenome,email, senha);
	}

	public static String getCargo() {
		return cargo;
	}

	public static void setCargo(String cargo) {
		Administrador.cargo = cargo;
	}
	
	
	
}
