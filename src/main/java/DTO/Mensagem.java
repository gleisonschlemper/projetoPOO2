package DTO;

public class Mensagem {
	private int codigo;
	private int funcionarioCodigo;
	private String mensagemAssunto;
	private String mensagemConteudo;
	private String alunoCodigo;
	
	public Mensagem(int funcionarioCodigo, String mensagemAssunto,String mensagemConteudo,String alunoCodigo) {
		setFuncionarioCodigo(funcionarioCodigo);
		setMensagemAssunto(mensagemAssunto);
		setMensagemConteudo(mensagemConteudo);
		setAlunoCodigo(alunoCodigo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getFuncionarioCodigo() {
		return funcionarioCodigo;
	}
	public void setFuncionarioCodigo(int funcionarioCodigo) {
		this.funcionarioCodigo = funcionarioCodigo;
	}
	public String getMensagemAssunto() {
		return mensagemAssunto;
	}
	public void setMensagemAssunto(String mensagemAssunto) {
		this.mensagemAssunto = mensagemAssunto;
	}
	public String getMensagemConteudo() {
		return mensagemConteudo;
	}
	public void setMensagemConteudo(String mensagemConteudo) {
		this.mensagemConteudo = mensagemConteudo;
	}
	public String getAlunoCodigo() {
		return alunoCodigo;
	}
	public void setAlunoCodigo(String alunoCodigo) {
		this.alunoCodigo = alunoCodigo;
	}
	
	
}
