package projetoPOO2;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class BO {
	public static void main(String[] args) throws IOException {
		JsonMapper m = new JsonMapper();
		ArrayList<Pessoa> list = new ArrayList<>();
		Pessoa pessoa = new Pessoa();
		pessoa.setCodigo(1);
		pessoa.setNome("Gleison");
		list.add(pessoa);
		String jsonData = m.writeValueAsString(list);
		System.out.println(jsonData);
		m.writeValue(new File("funcionario.json"), list);
	
		JsonMapper m1 = new JsonMapper();
		String json = m.writeValueAsString(list);
		ArrayList <Pessoa> list1 = m1.readValue(json, ArrayList.class);
		System.out.println(list1.size());
		
		recuperarDados();	
	}
	
	public static void recuperarDados() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		// Create a JsonParser
	    JsonParser parser = new JsonParser();

	    // Parse the JSON file using FileReader
	    JsonElement jsonElement = parser.parse(new FileReader("funcionario.json"));

	    // Convert JsonElement to String
	    String jsonString = jsonElement.toString();
	    //System.out.println(jsonString);

	    // Convert JsonString to ArrayList
	   /// Gson gson = new Gson();
	    ///JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
	    //System.out.println(jsonArray);

	    // Now, jsonArray contains your data as an ArrayList
	}

class Pessoa{
	private int codigo;
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
