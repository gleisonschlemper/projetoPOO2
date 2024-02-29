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

public interface IPersistencia {	
	public  ArrayList <Administrador> buscarTodos(Administrador adm,String tabela) throws JsonIOException, JsonSyntaxException, FileNotFoundException, JsonMappingException, JsonProcessingException;
	public boolean salvar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException;
	public boolean deletar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException;
	public Administrador buscar(Administrador adm,String tabela)throws StreamWriteException, DatabindException, IOException;
	
	public boolean salvar(Aluno aluno,String tabela) throws StreamWriteException, DatabindException, IOException;
	public boolean deletar(Aluno aluno,String tabela) throws StreamWriteException, DatabindException, IOException;
	public  ArrayList <Aluno> buscarTodos(Aluno aluno,String tabela) throws JsonIOException, JsonSyntaxException, FileNotFoundException, JsonMappingException, JsonProcessingException;
	public Aluno buscar(Aluno aluno,String tabela)throws StreamWriteException, DatabindException, IOException;
	
	
	public String enviarEmail(Administrador adm,Aluno aluno, String assunto, String conteudo);
}
