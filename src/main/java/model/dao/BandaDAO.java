package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jdbc.ConnectionFactory;
import model.beans.Banda;
import model.enums.Genero;

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
	
	public ArrayList<Banda> listarBandasComFiltro(String nomeBanda,Genero[] generosFiltro)  {
		String sql = "SELECT * FROM projeto.bandas WHERE nome LIKE ?";
		int quantidadeGenerosFiltro = generosFiltro.length;
		
		if (quantidadeGenerosFiltro>0) {
			sql+=" AND (";
			
			for (int i =0; i<quantidadeGenerosFiltro;i++) {
				if (i==(quantidadeGenerosFiltro-1)) {
					sql+="genero=? ";
				}else {
					sql+="genero=? OR ";
				}
			}
			
			sql+=")";
		}
		
    	sql+= "ORDER BY id_banda";
		
        try {
        	ArrayList<Banda> bandas = new ArrayList<Banda>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+nomeBanda+"%");
            
            if (quantidadeGenerosFiltro>0) {
            	for (int i =0; i<quantidadeGenerosFiltro;i++) {
    				stmt.setString((i+2), generosFiltro[i].toString());
    			}
    		}
            
            System.out.println(stmt.toString());
            
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
