package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionFactory;

public class BandaDAO {
	private Connection connection;

	public BandaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionarBanda(Banda banda) {
		
		String sql = "INSERT INTO bandas(nome,genero) VALUES(?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, banda.getNome());
			stmt.setString(2, banda.getGenero().toString());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Banda> listarBandas() {
		String sql = "select * from bandas order by id_banda";
		
        try {
        	ArrayList<Banda> bandas = new ArrayList<Banda>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
            	String generoString = rs.getString("genero");
            	Banda banda = new Banda();
            	Genero genero = Genero.valueOf(generoString);
            	
            	banda.setIdBanda(rs.getInt("id_banda"));
                banda.setNome(rs.getString("nome"));
                banda.setGenero(genero);
                		
                // adicionando o objeto à lista
                bandas.add(banda);
            }
            
            rs.close();
            stmt.close();
            
            return bandas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Banda selecionarBanda(Banda banda) {
        String sql = "select * from bandas where id_banda=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, banda.getIdBanda());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String generoString = rs.getString("genero");
            	Genero genero = Genero.valueOf(generoString);
            	
            	banda.setIdBanda(rs.getInt("id_banda"));
                banda.setNome(rs.getString("nome"));
                banda.setGenero(genero);

			}
			
			rs.close();
            stmt.close();
            
			return banda;
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void alterarBanda(Banda banda) {
        String sql = "update bandas SET nome=?, genero=? where id_banda=? ";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, banda.getNome());
			stmt.setString(2, banda.getGenero().toString());
			stmt.setInt(3, banda.getIdBanda());

			stmt.executeUpdate();
			stmt.close();
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarBanda(Banda banda) {
        String sql = "delete from bandas where id_banda=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			stmt.setInt(1, banda.getIdBanda());
			
			stmt.executeUpdate();
			stmt.close();
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	
}
