package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jdbc.ConnectionFactory;
import model.beans.Banda;
import model.beans.ShowBanda;

public class ShowsBandaDAO {
	private Connection connection;

	public ShowsBandaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(ShowBanda showBanda) {
		
		String sql = "INSERT INTO showsPorBanda(banda_id, show_id) VALUES (?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, showBanda.getId_banda());
			stmt.setInt(2, showBanda.getId_show());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public int countShowPorBanda(int idBanda) {
		String sql = "select count(*) from projeto.showsPorBanda where banda_id=?";
		int count = 0;
        try {        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idBanda);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	
            count = rs.getInt(1);
            	
            }
            rs.close();
            stmt.close();
            
            return count;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public int countBandaPorShow(int idShow) {
		String sql = "select count(*) from projeto.showsPorBanda where show_id=?";
		int count = 0;
        try {        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idShow);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	
            count = rs.getInt(1);
            	
            }
            rs.close();
            stmt.close();
            
            return count;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	public ArrayList<ShowBanda> selecionarShowsPorBanda(ShowBanda show) {
        String sql = "select * from showsPorBanda where show_id=?";
        
        try {
        	ArrayList<ShowBanda> shows = new ArrayList<ShowBanda>();

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, show.getId_show());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ShowBanda sb = new ShowBanda();
				sb.setId_banda(rs.getInt("banda_id"));
				sb.setId(rs.getInt("id"));
				sb.setId_show(rs.getInt("show_id"));
				shows.add(sb);
			}
			
			rs.close();
            stmt.close();
            
			return shows;
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public ArrayList<ShowBanda> selecionarBandasPorShow(ShowBanda banda) {
        String sql = "select * from showsPorBanda where banda_id=?";
        
        try {
        	ArrayList<ShowBanda> bandas = new ArrayList<ShowBanda>();

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, banda.getId_banda());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ShowBanda sb = new ShowBanda();
				sb.setId_banda(rs.getInt("banda_id"));
				sb.setId(rs.getInt("id"));
				sb.setId_show(rs.getInt("show_id"));
				bandas.add(sb);
			}
			
			rs.close();
            stmt.close();
            
			return bandas;
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarShowPorBanda(int idBanda) {
        String sql = "delete from showsPorBanda where banda_id=?";
                
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
		
			stmt.setInt(1, idBanda);
			
			stmt.execute();
			stmt.close();
		
					
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarBandaPorShow(int idShow) {
        String sql = "delete from showsPorBanda where show_id=?";
                
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
		
			stmt.setInt(1, idShow);
			
			stmt.execute();
			stmt.close();
		
					
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
}
