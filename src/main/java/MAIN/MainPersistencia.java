package MAIN;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import BO.Persistencia;
import DAO.JSONPersist;
import DAO.MySQLPersist;
import DAO.XMLPersist;
import DTO.Administrador;
import DTO.Aluno;

public class MainPersistencia {

	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
		Scanner input = new Scanner(System.in);
		Persistencia p = null;
		boolean sistema = true;
		while(sistema) {
			System.out.println("Sistema de cadasatro de Administradores de sistema");
			System.out.println("Forma de persistencia!");
			System.out.println("1 - Banco de dados ");
			System.out.println("2 - JSON");
			System.out.println("3 - XML ");
			System.out.println("4 - sair");
			int formaDePersistencia = input.nextInt();
			switch (formaDePersistencia) {
				case 1:
					MySQLPersist persistDB = new MySQLPersist();
					p = new Persistencia(persistDB);	
					break;
				case 2:
					JSONPersist persistJSON = new JSONPersist();
					p = new Persistencia(persistJSON);	
					break;
				case 3: 
					XMLPersist persistXML = new XMLPersist();
					p = new Persistencia(persistXML);
					break;
				case 4 : 
					sistema = false;
					break;
			}
			
			boolean funcionalidade = true;
			while(funcionalidade) {
				Administrador adm = new Administrador();
				Aluno aluno = new Aluno();
				System.out.println("----------------------------------");
				System.out.println("Funcionalidade: ");
				System.out.println("1 - cadastrar administrador");
				System.out.println("2 - Leitura de todos os administradores");
				System.out.println("3 - deletar administrador");
				System.out.println("4 - buscar administrador");
				System.out.println("5 - cadastrar aluno");
				System.out.println("6 - Leitura de todos os alunos");
				System.out.println("7 - buscar aluno");
				System.out.println("8 - enviar E-mail");
				System.out.println("9 - sair");
				int opcaoFuncionalidade = input.nextInt();
				//System.out.println("Digite nome do arquivo ou tabela que sera utilizado");
				//String persistencia = input.next();
				String persistencia;
				String nome;
				String sobrenome;
				String cpf;
				String email;
				String senha;
				
				switch(opcaoFuncionalidade) {
					case 1:
						persistencia = "funcionarios";
						System.out.println("Digite o nome");
						nome = input.next();
						adm.setNome(nome);
						System.out.println("Digite o sobrenome");
						sobrenome = input.next();
						adm.setSobrenome(sobrenome);
						System.out.println("Digite o cpf");
						cpf = input.next();
						adm.setCpf(cpf);
						System.out.println("Digite o email");
						email = input.next();
						adm.setEmail(email);
						System.out.println("Digite a senha");
						senha = input.next();
						adm.setSenha(senha);
						System.out.println(p.salvar(adm,persistencia));
						break;
					case 2: 
						persistencia = "funcionarios";
						System.out.println(p.buscarTodos(adm,persistencia));
						break;
					case 3:
						persistencia = "funcionarios";
						System.out.println("Digite o CPF");
						String cpfDeletar = input.next();
						adm.setCpf(cpfDeletar);
						System.out.println(p.deletar(adm,persistencia));
						System.out.println(p.buscarTodos(adm,persistencia));
						break;
					case 4 : 
						persistencia = "funcionarios";
						System.out.println("Digite o CPF");
						String cpfBuscarAdministrador = input.next();
						adm.setCpf(cpfBuscarAdministrador);
						System.out.println(p.buscar(adm, persistencia));
						break;
					case 5 : 
						persistencia = "alunos";
						System.out.println("Digite o nome");
						nome = input.next();
						aluno.setNome(nome);
						System.out.println("Digite o sobrenome");
						sobrenome = input.next();
						aluno.setSobrenome(sobrenome);
						System.out.println("Digite o cpf");
						cpf = input.next();
						aluno.setCpf(cpf);
						System.out.println("Digite o email");
						email = input.next();
						aluno.setEmail(email);
						System.out.println("Digite a senha");
						senha = input.next();
						aluno.setSenha(senha);
						System.out.println(p.salvar(aluno,persistencia));
						break;
					case 7 : 
						persistencia = "alunos";
						System.out.println("Digite o CPF");
						String cpfBuscarAluno = input.next();
						aluno.setCpf(cpfBuscarAluno);
						System.out.println(p.buscar(aluno, persistencia));
						break;
					case 8 : 
						persistencia = "funcionarios";
						System.out.println("Digite seu CPF");
						cpf = input.next();
						adm.setCpf(cpf);
						System.out.println("Digite CPF do aluno");
						String cpfAluno = input.next();
						aluno.setCpf(cpfAluno);
						//System.out.println("Digite arquivo do aluno");
						String persistenciaAluno = "alunos";
						System.out.println("Digite assunto");
						String assunto = input.next();
						System.out.println("Digite conteudo");
						String conteudo = input.next();
						aluno =  p.buscar(aluno, persistenciaAluno);
						adm = p.buscar(adm, persistencia);
						System.out.println(p.enviarEmail(adm, aluno, assunto, conteudo));
						break;
					case 9 : 
						funcionalidade = false;
						break;
				}
			}
			}
			
	
	}

}
