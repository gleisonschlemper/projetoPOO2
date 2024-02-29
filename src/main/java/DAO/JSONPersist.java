package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import BO.IPersistencia;
import DTO.Administrador;
import DTO.Aluno;
import UTIL.Email;

import java.lang.reflect.Type;

public class JSONPersist implements IPersistencia{

	// parte do administrador
	@Override
	public boolean salvar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException {
		JsonMapper m = new JsonMapper();
		ArrayList<Administrador> list = buscarTodos(adm,tabela);
		list.add(adm);
		String jsonData = m.writeValueAsString(list);
		m.writeValue(new File(tabela+".json"), list);
		return true;
	}

	@Override
	public ArrayList <Administrador> buscarTodos(Administrador adm,String tabela) throws JsonIOException, JsonSyntaxException, FileNotFoundException, JsonMappingException, JsonProcessingException {
		JsonMapper m2 = new JsonMapper();
	    JsonParser parser = new JsonParser();
	    JsonElement jsonElement = parser.parse(new FileReader(tabela+".json"));
	    String jsonString = jsonElement.toString();
	    ArrayList <Administrador> list1 = m2.readValue(jsonString,ArrayList.class );
	    return list1;
	}
	
	@Override
	public boolean deletar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException{
			JsonMapper m1 = new JsonMapper();
		    String json = m1.writeValueAsString(buscarTodos(adm,tabela));
		    ArrayList <Administrador> listNovo = new ArrayList <Administrador>();
		    ArrayList<Administrador> list = m1.readValue(json, new TypeReference<ArrayList<Administrador>>() {});
		    Gson gson = new Gson();
		    com.google.gson.JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();
		    for (int i = 0; i < jsonArray.size(); i++) {
		        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
		        String numeroCPF = jsonObject.get("cpf").getAsString();
		        if (adm.getCpf().equalsIgnoreCase(numeroCPF)) {
		        	listNovo.add(adm);
		        }
		        else {
		        	
		        }
		    }
		    m1.writeValue(new File(tabela+".json"), listNovo);
		    return true;
	}
	
	@Override
	public Administrador buscar(Administrador adm, String tabela) throws StreamWriteException, DatabindException, IOException {
		JsonMapper m1 = new JsonMapper();
	    String json = m1.writeValueAsString(buscarTodos(adm,tabela));
	    ArrayList <Administrador> listNovo = new ArrayList <Administrador>();
	    ArrayList<Administrador> list = m1.readValue(json, new TypeReference<ArrayList<Administrador>>() {});
	    Gson gson = new Gson();
	    com.google.gson.JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();
	    for (int i = 0; i < jsonArray.size(); i++) {
	        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
	        String numeroCPF = jsonObject.get("cpf").getAsString();
	        String numeroNome = jsonObject.get("nome").getAsString();
	        String numeroSobrenome = jsonObject.get("sobrenome").getAsString();
	        String numeroEmail = jsonObject.get("email").getAsString();
	        String numeroSenha = jsonObject.get("senha").getAsString();    
	        if (adm.getCpf().equalsIgnoreCase(numeroCPF)) {
	        	adm.setCpf(numeroCPF);
	        	adm.setNome(numeroNome);
	        	adm.setSobrenome(numeroSobrenome);
	        	adm.setEmail(numeroEmail);
	        	adm.setSenha(numeroSenha);
	        }

	    }
		return adm;
	}
	
	// PARTE DO ALUNO

	@Override
	public boolean salvar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		JsonMapper m = new JsonMapper();
		ArrayList<Aluno> list = buscarTodos(aluno,tabela);
		list.add(aluno);
		String jsonData = m.writeValueAsString(list);
		m.writeValue(new File(tabela+".json"), list);
		return true;
	}

	@Override
	public boolean deletar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Aluno> buscarTodos(Aluno aluno, String tabela) throws JsonIOException, JsonSyntaxException,FileNotFoundException, JsonMappingException, JsonProcessingException {
		JsonMapper m2 = new JsonMapper();
	    JsonParser parser = new JsonParser();
	    JsonElement jsonElement = parser.parse(new FileReader(tabela+".json"));
	    String jsonString = jsonElement.toString();
	    ArrayList <Aluno> list1 = m2.readValue(jsonString,ArrayList.class );
	    return list1;
	}

	@Override
	public Aluno buscar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		JsonMapper m1 = new JsonMapper();
	    String json = m1.writeValueAsString(buscarTodos(aluno,tabela));
	    ArrayList <Administrador> listNovo = new ArrayList <Administrador>();
	    ArrayList<Administrador> list = m1.readValue(json, new TypeReference<ArrayList<Administrador>>() {});
	    Gson gson = new Gson();
	    com.google.gson.JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();
	    for (int i = 0; i < jsonArray.size(); i++) {
	        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
	        String numeroCPF = jsonObject.get("cpf").getAsString();
	        String numeroNome = jsonObject.get("nome").getAsString();
	        String numeroSobrenome = jsonObject.get("sobrenome").getAsString();
	        String numeroEmail = jsonObject.get("email").getAsString();
	        String numeroSenha = jsonObject.get("senha").getAsString();    
	        if (aluno.getCpf().equalsIgnoreCase(numeroCPF)) {
	        	aluno.setCpf(numeroCPF);
	        	aluno.setNome(numeroNome);
	        	aluno.setSobrenome(numeroSobrenome);
	        	aluno.setEmail(numeroEmail);
	        	aluno.setSenha(numeroSenha);
	        }
	    }
		return aluno;
	}
	
	
	// PARTE DO ENVIO DE EMAIL
	@Override
	public String enviarEmail(Administrador adm, Aluno aluno, String assunto, String conteudo) {
		Email email = new Email();
		return email.enviar(aluno, assunto,conteudo);
	}
}
