package DTO;

public class Pessoa {
	public int codigo = 0;
	public String cpf = "";
	public String nome = "";
	public String sobrenome = "";
	public String email = "";
	public String senha = "";

    @Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email="
				+ email + ", senha=" + senha + "]";
	}

	public Pessoa() {}
    
    public Pessoa(int codigo) {
    	setCodigo(codigo);
    }
    
    public Pessoa(String cpf) {
    	setCpf(cpf);
    }
    
    public Pessoa(String email, String senha) {
    	setEmail(email);
    	setSenha(senha);
    }
    
	public Pessoa(int codigo, String cpf, String nome, String sobrenome, String email, String senha) {
		setCodigo(codigo);
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}
	
	// Seta sem codigo da pessoa
	public Pessoa(String cpf, String nome, String sobrenome, String email, String senha) {
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}
	
	// Seta sem codigo da pessoa e cargo
	public Pessoa(String cpf, String nome, String sobrenome, int idade, String email, String senha) {
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}
	
	// Seta sem email e senha
	public Pessoa(String cpf, String nome, String sobrenome) {
		setCpf(cpf);
		setNome(nome);
		setSobrenome(sobrenome);

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo <= 0) {
			this.codigo = 0;
		}
		else {
			this.codigo = codigo;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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

}
