package BO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import DTO.Administrador;
import DTO.Aluno;


public class Persistencia {
	
	IPersistencia ip;
	
	public Persistencia(IPersistencia ip) {
		this.ip = ip;
	}
	
	// PARTE DO ADMINISTRADOR
	public ArrayList<Administrador> buscarTodos(Administrador adm,String tabela) throws JsonMappingException, JsonIOException, JsonSyntaxException, JsonProcessingException, FileNotFoundException{
		return ip.buscarTodos(adm,tabela);
	}

	public boolean deletar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException {
		ip.deletar(adm,tabela);
		
		return true;
	}

	public boolean salvar(Administrador adm, String tabela) throws StreamWriteException, DatabindException, IOException{
		ip.salvar(adm,tabela);
		return true;
	}
	
	public Administrador buscar(Administrador adm, String tabela) throws StreamWriteException, DatabindException, IOException {
		return ip.buscar(adm, tabela);
	}
	
	// PARTE DO ALUNO
	public ArrayList <Aluno> buscarTodos(Aluno aluno,String tabela) throws JsonMappingException, JsonIOException, JsonSyntaxException, JsonProcessingException, FileNotFoundException{
		return ip.buscarTodos(aluno,tabela);
	}

	public boolean deletar(Aluno aluno,String tabela) throws StreamWriteException, DatabindException, IOException {
		ip.deletar(aluno,tabela);
		
		return true;
	}

	public boolean salvar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException{
		ip.salvar(aluno,tabela);
		return true;
	}
	
	public Aluno  buscar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		return ip.buscar(aluno, tabela);
	}
	
	public boolean enviarEmail(Administrador adm,Aluno aluno, String assunto, String conteudo) {
		ip.enviarEmail(adm, aluno, assunto, conteudo);
		return true;
	}
}
