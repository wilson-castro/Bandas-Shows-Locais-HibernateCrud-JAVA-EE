package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.ConnectionFactory;
import model.beans.Local;
import model.beans.ShowsLocal;

public class LocalDAO {
	private Connection connection;

	public LocalDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionarLocal(Local local, int idShow) {
		
		ShowsLocal showlocal = new ShowsLocal();
		String sql = "INSERT INTO locais(nome_local,capacidade) VALUES(?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, local.getNome());
			stmt.setInt(2, local.getCapacidade());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
				showlocal.setLocal_Id(rs.getInt(1));
			}
			
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		if(idShow>0) {
			ShowsLocalDAO sl = new ShowsLocalDAO();
			
			showlocal.setShow_Id(idShow);
			sl.adicionar(showlocal);
		}
	}
	
	public ArrayList<Local> listarLocais() {
		String sql = "select * from locais order by id_local";

        try {
        	ArrayList<Local> locais = new ArrayList<Local>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
            	Local local = new Local();
            	
            	local.setIdLocal(rs.getInt("id_local"));
            	local.setNome(rs.getString("nome_local"));
            	local.setCapacidade(rs.getInt("capacidade"));
                		
                // adicionando o objeto à lista
                locais.add(local);
            }
            
            rs.close();
            stmt.close();
            
            return locais;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Local selecionarLocal(Local local) {
        String sql = "select * from locais where id_local=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, local.getIdLocal());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
            	
            	local.setIdLocal(rs.getInt("id_local"));
                local.setNome(rs.getString("nome_local"));
                local.setCapacidade(rs.getInt("capacidade"));

			}
			
			rs.close();
            stmt.close();
            
			return local;
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void alterarLocal(Local local) {
        String sql = "UPDATE locais SET nome_local=?, capacidade=? WHERE id_local=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, local.getNome());
			stmt.setInt(2, local.getCapacidade());
			stmt.setInt(3, local.getIdLocal());

			stmt.executeUpdate();
			stmt.close();
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarLocal(Local local) {
        String sql = "DELETE FROM locais where id_local=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, local.getIdLocal());
			
			stmt.executeUpdate();
			stmt.close();
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
}
