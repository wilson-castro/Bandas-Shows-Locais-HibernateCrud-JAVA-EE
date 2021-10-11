package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import jdbc.ConnectionFactory;

public class ShowDAO {
	private Connection connection;

	public ShowDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void adicionarShow(Show show) {
		
		String sql = "INSERT INTO shows(id_local,data) VALUES(?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, show.getIdLocal());
			stmt.setDate(2, new Date(
                    show.getData().getTimeInMillis()));
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Show> listarShows() {
		String sql = "select * from shows order by id_show";

        try {
        	ArrayList<Show> shows = new ArrayList<Show>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
            	Show show = new Show();
            	
            	show.setIdLocal(rs.getInt("id_local"));
            	show.setIdShow(rs.getInt("id_show"));
            	
            	  Calendar data = Calendar.getInstance();
                  data.setTime(rs.getDate("data"));
                  show.setData(data);
                		
                // adicionando o objeto à lista
                shows.add(show);
            }
            
            rs.close();
            stmt.close();
            
            return shows;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Show selecionarShow(Show show) {
        String sql = "select * from shows where id_show=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, show.getIdShow());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
            	
				show.setIdShow(rs.getInt("id_show"));
            	show.setIdLocal(rs.getInt("id_local"));

          	  Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                show.setData(data);

			}
			
			rs.close();
            stmt.close();
            
			return show;
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void alterarShow(Show show) {
        String sql = "UPDATE shows SET data=?, id_local=? WHERE id_show=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setDate(1, new Date(
                    show.getData().getTimeInMillis()));
			stmt.setInt(2, show.getIdLocal());
			stmt.setInt(3, show.getIdShow());

			stmt.executeUpdate();
			stmt.close();
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarShow(Show show) {
        String sql = "DELETE FROM shows where id_show=?";
        
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, show.getIdShow());
			
			stmt.executeUpdate();
			stmt.close();
			
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
}
