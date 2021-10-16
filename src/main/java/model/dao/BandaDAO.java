package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.ConnectionFactory;
import model.beans.Banda;
import model.beans.ShowBanda;
import model.enums.Genero;

public class BandaDAO {
	private Connection connection;

	public BandaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	ShowsBandaDAO sb = new ShowsBandaDAO();

	public void adicionarBanda(Banda banda, int showsIds[]) {
		ShowBanda sb = new ShowBanda();
		ShowsBandaDAO dao = new ShowsBandaDAO();
		
		String sql = "INSERT INTO bandas(nome,genero) VALUES(?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, banda.getNome());
			stmt.setString(2, banda.getGenero().toString());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				sb.setId_banda(rs.getInt(1));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		if(showsIds != null) {
			for(int i=0; i< showsIds.length; i++) {
				sb.setId_show(showsIds[i]);
				dao.adicionar(sb);
			}
		}
	}
	
	public void alterarBanda(Banda banda, int showsIds[]) {
		ShowBanda sb = new ShowBanda();
		ShowsBandaDAO dao = new ShowsBandaDAO();
		
        String sql = "UPDATE bandas SET nome=?, genero=? WHERE (id_banda = ?)";
        
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
        
        dao.deletarShowPorBanda(banda.getIdBanda());
        
       if(showsIds != null) {
			for(int i=0; i< showsIds.length; i++) {
				sb.setId_banda(banda.getIdBanda());
				sb.setId_show(showsIds[i]);
				dao.adicionar(sb);
			}
		}
        
	}
	
	public ArrayList<Banda> listarBandas() {
		String sql = "select * from bandas order by id_banda";
		
        try {
        	ArrayList<Banda> bandas = new ArrayList<Banda>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	String generoString = rs.getString("genero");
            	Banda banda = new Banda();
            	Genero genero = Genero.valueOf(generoString);
            	
            	banda.setIdBanda(rs.getInt("id_banda"));
                banda.setNome(rs.getString("nome"));
                banda.setGenero(genero);
                
                int numShows = 0;
                numShows = sb.countShowPorBanda(banda.getIdBanda());
                
                banda.setNumShows(numShows);
                		
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
                        
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String generoString = rs.getString("genero");
            	Banda banda = new Banda();
            	Genero genero = Genero.valueOf(generoString);
            	
            	banda.setIdBanda(rs.getInt("id_banda"));
                banda.setNome(rs.getString("nome"));
                banda.setGenero(genero);
                
                int numShows = 0;
                numShows = sb.countShowPorBanda(banda.getIdBanda());
                
                banda.setNumShows(numShows);
                		
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
                int numShows = 0;
                numShows = sb.countShowPorBanda(banda.getIdBanda());
                
                banda.setNumShows(numShows);

			}
			
			rs.close();
            stmt.close();
            
			return banda;
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarBanda(Banda banda) {
        String sql = "delete from bandas where id_banda=?";
	
		
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			int qtdBandas = 0;
			qtdBandas = sb.countShowPorBanda(banda.getIdBanda());
				
			if (qtdBandas>0) {
				sb.deletarShowPorBanda(banda.getIdBanda());
			}
			
			stmt.setInt(1, banda.getIdBanda());
			
		    stmt.executeUpdate();
			stmt.close();
						
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
                
	}
	
	
}
