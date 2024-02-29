package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import BO.IPersistencia;
import Conexao.DB;
import DTO.Administrador;
import DTO.Aluno;
import UTIL.Email;

public class MySQLPersist implements IPersistencia{

	@Override
	public boolean salvar(Administrador adm,String tabela) {
		try {
            String queryInsertMatricula = "INSERT INTO "+tabela+" (func_cpf, func_nome, func_sobrenome, func_email, func_senha,func_cargo) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = DB.ConexaoDB().prepareStatement(queryInsertMatricula)) {
                stmt.setString(1, adm.getCpf());
                stmt.setString(2, adm.getNome());
                stmt.setString(3, adm.getSobrenome());
                stmt.setString(4, adm.getEmail());
                stmt.setString(5, adm.getSenha());
                stmt.setString(6, adm.getCargo());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public ArrayList<Administrador> buscarTodos(Administrador adm,String tabela){
		ArrayList <Administrador> list = new ArrayList <Administrador>();
		try  { // Execução do código corretamente 
		 	Connection conn = DB.ConexaoDB();
            String querySelect = "SELECT * FROM "+tabela; // Cria o select do aluno     
        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
            ResultSet rs = stmt.executeQuery(); // Executa o select
            while (rs.next()) { // Excuta quantos objetos foram encontrado
            	Administrador admArr = new Administrador(
            			rs.getInt("func_codigo"),
            			rs.getString("func_cpf"),
            			rs.getString("func_nome"),
            			rs.getString("func_sobrenome"),
            			rs.getString("func_email"),
            			rs.getString("func_senha")
            			);
            	list.add(admArr);
            }
            conn.close();
            stmt.close();
            rs.close();
        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
        	//e.printStackTrace();
        }
        return list; // Retorna Array de Alunos da escola 
	}

	@Override
	public boolean deletar(Administrador adm,String tabela) throws StreamWriteException, DatabindException, IOException {
		
		try  { // Execução do código corretamente 
		 	Connection conn = DB.ConexaoDB();
            String querySelect = "DELETE FROM tb_funcionarios WHERE func_cpf = "+adm.getCpf(); // Cria o select do aluno     
        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
            int rowsAffected = stmt.executeUpdate();
            conn.close();
            stmt.close();
            return rowsAffected > 0;

        } catch (SQLException e) { // Mostra se ocorrer um error na execução do código
        	//e.printStackTrace();
        }	
		return false;
	}
	
	@Override
	public Administrador buscar(Administrador adm, String tabela) throws StreamWriteException, DatabindException, IOException {
		try  { // Execução do código corretamente 
		 	Connection conn = DB.ConexaoDB();
            String querySelect = "SELECT * FROM "+tabela+" where func_cpf = "+adm.getCpf(); // Cria o select do aluno     
        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
            ResultSet rs = stmt.executeQuery(); // Executa o select
            if(rs.next()) {
               adm.setCodigo(rs.getInt("func_codigo"));
               adm.setCpf(rs.getString("func_cpf"));
               adm.setNome(rs.getString("func_nome"));
               adm.setSobrenome(rs.getString("func_sobrenome"));
               adm.setEmail(rs.getString("func_email"));
               adm.setSenha(rs.getString("func_senha"));
            } 
         }
		catch (SQLException e) { // Mostra se ocorrer um error na execução do código
        	e.printStackTrace();
        }
		return adm;
	}
	

	// PARTE DO ALUNO
	
	@Override
	public boolean salvar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		try {
            String queryInsertMatricula = "INSERT INTO "+tabela+" (mat_cpf, mat_nome, mat_sobrenome, mat_email, mat_senha) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = DB.ConexaoDB().prepareStatement(queryInsertMatricula)) {
                stmt.setString(1, aluno.getCpf());
                stmt.setString(2, aluno.getNome());
                stmt.setString(3, aluno.getSobrenome());
                stmt.setString(4, aluno.getEmail());
                stmt.setString(5, aluno.getSenha());
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean deletar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Aluno> buscarTodos(Aluno aluno, String tabela) throws JsonIOException, JsonSyntaxException,
			FileNotFoundException, JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String enviarEmail(Administrador adm, Aluno aluno, String assunto, String conteudo) {
		Email email = new Email();
		return email.enviar(aluno, assunto,conteudo);
	}

	@Override
	public Aluno buscar(Aluno aluno, String tabela) throws StreamWriteException, DatabindException, IOException {
		try  { // Execução do código corretamente 
		 	Connection conn = DB.ConexaoDB();
            String querySelect = "SELECT * FROM "+tabela+" where mat_cpf = "+aluno.getCpf(); // Cria o select do aluno     
        	PreparedStatement stmt = conn.prepareStatement(querySelect); // Prepara o select
            ResultSet rs = stmt.executeQuery(); // Executa o select
            if(rs.next()) {
               aluno.setCodigo(rs.getInt("mat_codigo"));
               aluno.setCpf(rs.getString("mat_cpf"));
               aluno.setNome(rs.getString("mat_nome"));
               aluno.setSobrenome(rs.getString("mat_sobrenome"));
               aluno.setEmail(rs.getString("mat_email"));
               aluno.setSenha(rs.getString("mat_senha"));
            } 
         }
		catch (SQLException e) { // Mostra se ocorrer um error na execução do código
        	e.printStackTrace();
        }
		return aluno;
	}

}
