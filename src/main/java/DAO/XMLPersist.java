package DAO;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator ;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import BO.IPersistencia;
import DTO.Administrador;
import DTO.Aluno;
import UTIL.Email;

public class XMLPersist implements IPersistencia{

	// parte do administrador 
	
	@Override
	public boolean salvar(Administrador adm,String tabela) {
		ArrayList list = buscarTodos(adm,tabela);
		
		Element config = new Element("funcionarios");
        Document documento = new Document(config);
        
        // Cria tag com os dados que será cadastrado com administrador novo
        Element titulo = new Element("titulo");
        titulo.setText("Cadastro de Administrador");
        config.addContent(titulo);

        Element admElementArr = new Element("Administrador");
        admElementArr.setAttribute("cpf", String.valueOf(adm.getCpf()));

        Element cpfElement = new Element("cpf");
        cpfElement.setText(adm.getCpf());

        Element nomeElement = new Element("nome");
        nomeElement.setText(adm.getNome());

        Element sobrenomeElement = new Element("sobrenome");
        sobrenomeElement.setText(adm.getSobrenome());
            
        Element senhaElement = new Element("senha");
        senhaElement.setText(adm.getSenha());

        Element emailElement = new Element("email");
        emailElement.setText(adm.getEmail());

        Element cargoElement = new Element("cargo");
        cargoElement.setText(adm.getCargo());
           
        admElementArr.addContent(cpfElement);
        admElementArr.addContent(nomeElement);
        admElementArr.addContent(sobrenomeElement);
        admElementArr.addContent(emailElement);
        admElementArr.addContent(senhaElement);
        admElementArr.addContent(cargoElement);
        config.addContent(admElementArr);
   
        // Partee de recuperar os dados já salvo 
    	for(int i=0; i < list.size(); i++) {
    		Administrador admArr = (Administrador) list.get(i);
    		Element admElement = new Element("Administrador");
            admElement.setAttribute("cpf", String.valueOf(admArr.getCpf()));

            Element cpf = new Element("cpf");
            cpf.setText(admArr.getCpf());

            Element nome = new Element("nome");
            nome.setText(admArr.getNome());

            Element sobrenome = new Element("sobrenome");
            sobrenome.setText(admArr.getSobrenome());
                
            Element senha = new Element("senha");
            senha.setText(admArr.getSenha());

            Element email = new Element("email");
            email.setText(admArr.getEmail());

            Element cargo = new Element("cargo");
            cargo.setText(admArr.getCargo());
               
            admElement.addContent(cpf);
            admElement.addContent(nome);
            admElement.addContent(sobrenome);
            admElement.addContent(email);
            admElement.addContent(senha);
            admElement.addContent(cargo);
            
            config.addContent(admElement);
            
    	}
        XMLOutputter xout = new XMLOutputter();

        try {
            // Completar a criação do arquivo XML
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(tabela+".xml"), "UTF-8"));
            xout.output(documento, arquivo);
            arquivo.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public ArrayList <Administrador> buscarTodos(Administrador adm,String tabela) {
		ArrayList <Administrador> listaAdm = new ArrayList <Administrador>();
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(tabela+".xml");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		Element config = doc.getRootElement();
		List list = (List) config.getChildren("Administrador");
		
		for(Iterator iter = list.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Administrador admArr = new Administrador();
			admArr.setCpf(element.getChildText("cpf"));
			admArr.setNome(element.getChildText("nome"));
			admArr.setSobrenome(element.getChildText("sobrenome"));
			admArr.setEmail(element.getChildText("email"));
			admArr.setSenha(element.getChildText("senha"));
			admArr.setCargo(element.getChildText("cargo"));
			listaAdm.add(admArr);
		}
		return listaAdm;
	}

	@Override
	public boolean deletar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException {
		ArrayList list = buscarTodos(adm,tabela);
		ArrayList <Administrador> listaNovo = new ArrayList <Administrador>();
		
		Element config = new Element("funcionarios");
        Document documento = new Document(config);
    	for(int i=0; i < list.size(); i++) {
    		Administrador admArr = (Administrador) list.get(i);
    		if(admArr.getCpf().equalsIgnoreCase(adm.getCpf())) {
    			    		
    		}
    		else {
    			listaNovo.add(admArr);
    		}
    	}
        
        // Partee de recuperar os dados já salvo 
     	for(int i=0; i < listaNovo.size(); i++) {
     		Administrador admArr = (Administrador) listaNovo.get(i);
     		Element admElement = new Element("Administrador");
             admElement.setAttribute("cpf", String.valueOf(admArr.getCpf()));

             Element cpf = new Element("cpf");
             cpf.setText(admArr.getCpf());

             Element nome = new Element("nome");
             nome.setText(admArr.getNome());

             Element sobrenome = new Element("sobrenome");
             sobrenome.setText(admArr.getSobrenome());
                 
             Element senha = new Element("senha");
             senha.setText(admArr.getSenha());

             Element email = new Element("email");
             email.setText(admArr.getEmail());

             Element cargo = new Element("cargo");
             cargo.setText(admArr.getCargo());
                
             admElement.addContent(cpf);
             admElement.addContent(nome);
             admElement.addContent(sobrenome);
             admElement.addContent(email);
             admElement.addContent(senha);
             admElement.addContent(cargo);
             
             config.addContent(admElement);  
     	}
		
        XMLOutputter xout = new XMLOutputter();

        try {
            // Completar a criação do arquivo XML
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(tabela+".xml"), "UTF-8"));
            xout.output(documento, arquivo);
            arquivo.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	@Override
	public Administrador buscar(Administrador adm, String tabela) throws StreamWriteException, DatabindException, IOException {
		ArrayList list = buscarTodos(adm, tabela);
		for(int i=0; i < list.size(); i++) {
    		Administrador admArr = (Administrador) list.get(i);
    		if(admArr.getCpf().equalsIgnoreCase(adm.getCpf())) {
    			    return admArr;
    		}
    	}
		
		return adm;
	}

	
	
	// PARTE DO ALUNO

	@Override
	public boolean salvar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		ArrayList list = buscarTodos(aluno,tabela);
		
		Element config = new Element("Alunos");
        Document documento = new Document(config);
        
        // Cria tag com os dados que será cadastrado com administrador novo
        Element titulo = new Element("titulo");
        titulo.setText("Cadastro de aluno");
        config.addContent(titulo);

        Element admElementArr = new Element("Aluno");
        admElementArr.setAttribute("cpf", String.valueOf(aluno.getCpf()));

        Element cpfElement = new Element("cpf");
        cpfElement.setText(aluno.getCpf());

        Element nomeElement = new Element("nome");
        nomeElement.setText(aluno.getNome());

        Element sobrenomeElement = new Element("sobrenome");
        sobrenomeElement.setText(aluno.getSobrenome());
            
        Element senhaElement = new Element("senha");
        senhaElement.setText(aluno.getSenha());

        Element emailElement = new Element("email");
        emailElement.setText(aluno.getEmail());
           
        admElementArr.addContent(cpfElement);
        admElementArr.addContent(nomeElement);
        admElementArr.addContent(sobrenomeElement);
        admElementArr.addContent(emailElement);
        admElementArr.addContent(senhaElement);
        config.addContent(admElementArr);
   
        // Partee de recuperar os dados já salvo 
    	for(int i=0; i < list.size(); i++) {
    		Administrador admArr = (Administrador) list.get(i);
    		Element admElement = new Element("Aluno");
            admElement.setAttribute("cpf", String.valueOf(admArr.getCpf()));

            Element cpf = new Element("cpf");
            cpf.setText(admArr.getCpf());

            Element nome = new Element("nome");
            nome.setText(admArr.getNome());

            Element sobrenome = new Element("sobrenome");
            sobrenome.setText(admArr.getSobrenome());
                
            Element senha = new Element("senha");
            senha.setText(admArr.getSenha());

            Element email = new Element("email");
            email.setText(admArr.getEmail());

            admElement.addContent(cpf);
            admElement.addContent(nome);
            admElement.addContent(sobrenome);
            admElement.addContent(email);
            admElement.addContent(senha);
            config.addContent(admElement);
            
    	}
        XMLOutputter xout = new XMLOutputter();

        try {
            // Completar a criação do arquivo XML
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(tabela+".xml"), "UTF-8"));
            xout.output(documento, arquivo);
            arquivo.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public ArrayList <Aluno> buscarTodos(Aluno aluno, String tabela) throws JsonIOException, JsonSyntaxException,FileNotFoundException, JsonMappingException, JsonProcessingException {
		ArrayList <Aluno> listaAluno = new ArrayList <Aluno>();
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(tabela+".xml");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		Element config = doc.getRootElement();
		List list = (List) config.getChildren("Aluno");
		
		for(Iterator iter = list.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Aluno admArr = new Aluno();
			admArr.setCpf(element.getChildText("cpf"));
			admArr.setNome(element.getChildText("nome"));
			admArr.setSobrenome(element.getChildText("sobrenome"));
			admArr.setEmail(element.getChildText("email"));
			admArr.setSenha(element.getChildText("senha"));
			listaAluno.add(admArr);
		}
		return listaAluno;
	}

	@Override
	public Aluno buscar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		ArrayList list = buscarTodos(aluno, tabela);
		for(int i=0; i < list.size(); i++) {
    		Aluno admArr = (Aluno) list.get(i);
    		if(admArr.getCpf().equalsIgnoreCase(aluno.getCpf())) {
    			    return admArr;
    		}
    	}
		
		return aluno;
	}
	
	public boolean deletar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String enviarEmail(Administrador adm, Aluno aluno, String assunto, String conteudo) {
		Email email = new Email();
		email.enviar(aluno, assunto,conteudo);
		return null;
	}


}
