package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionFactory;
import model.beans.ShowsLocal;

public class ShowsLocalDAO {
	private Connection connection;

	public ShowsLocalDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(ShowsLocal showlocal) {
		
		String sql = "INSERT INTO showsPorLocal(show_id, local_id) VALUES (?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, showlocal.getShow_Id());
			stmt.setInt(2, showlocal.getLocal_Id());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int countShowPorLocais(int idLocal) {
		String sql = "select count(*) from projeto.showsPorLocal where local_id=?";
		int count = 0;
        try {        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idLocal);
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
	
	public int countLocaisPorShow(int idShow) {
		String sql = "select count(*) from projeto.showsPorLocal where show_id=?";
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
	
	public ArrayList<ShowsLocal> listarShowPorLocal() {
		String sql = "select"
				+ " id_show as ID_Show,id_local as ID_Local, "
				+ "data as DATA_Show, nome_local as ONDE,"
				+ "  capacidade as CAPACIDADE  "
				+ "from shows "
				+ " inner join locais on shows.local_id  = locais.id_local;";
		ShowsBandaDAO sb = new ShowsBandaDAO();
		
        try {
        	ArrayList<ShowsLocal> shows = new ArrayList<ShowsLocal>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	ShowsLocal sl = new ShowsLocal();
            	
            	sl.setShow_Id(rs.getInt("ID_Show"));
            	sl.setLocal_Id(rs.getInt("ID_Local"));
            	sl.setData_show(rs.getString("DATA_Show"));
            	sl.setLugar_nome(rs.getString("ONDE"));
            	sl.setCapacidade(rs.getInt("CAPACIDADE"));
            	
            	int numBandas = 0;
            	numBandas = sb.countBandaPorShow(sl.getShow_Id());
                sl.setNumBandas(numBandas);
                

            	shows.add(sl);
            }
            
            rs.close();
            stmt.close();
            
            return shows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public ArrayList<ShowsLocal> listarShowPorLocalPorIdLocal(int idLocal) {
		String sql = "select"
				+ " id_show as ID_Show,id_local as ID_Local, "
				+ "data as DATA_Show, nome_local as ONDE,"
				+ "  capacidade as CAPACIDADE  "
				+ "from shows "
				+ " inner join locais on shows.local_id  = locais.id_local where local_id =?";
		ShowsBandaDAO sb = new ShowsBandaDAO();
		
        try {
        	ArrayList<ShowsLocal> shows = new ArrayList<ShowsLocal>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);       
            stmt.setInt(1, idLocal);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	ShowsLocal sl = new ShowsLocal();
            	
            	sl.setShow_Id(rs.getInt("ID_Show"));
            	sl.setLocal_Id(rs.getInt("ID_Local"));
            	sl.setData_show(rs.getString("DATA_Show"));
            	sl.setLugar_nome(rs.getString("ONDE"));
            	sl.setCapacidade(rs.getInt("CAPACIDADE"));
            	
            	int numBandas = 0;
            	numBandas = sb.countBandaPorShow(sl.getShow_Id());
                sl.setNumBandas(numBandas);
                

            	shows.add(sl);
            }
            
            rs.close();
            stmt.close();
            
            return shows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public ArrayList<ShowsLocal> listarShowPorLocaComFiltrol(String nomeLugar) {
		String sql = "select"
				+ " id_show as ID_Show,id_local as ID_Local, "
				+ "data as DATA_Show, nome_local as ONDE,"
				+ "  capacidade as CAPACIDADE  "
				+ "from shows "
				+ " inner join locais on shows.local_id  = locais.id_local where nome_local LIKE ?";
		
		ShowsBandaDAO sb = new ShowsBandaDAO();
		
		try {
        	ArrayList<ShowsLocal> shows = new ArrayList<ShowsLocal>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, "%"+ nomeLugar +"%");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

            	ShowsLocal sl = new ShowsLocal();
            	
            	sl.setShow_Id(rs.getInt("ID_Show"));
            	sl.setLocal_Id(rs.getInt("ID_Local"));
            	sl.setData_show(rs.getString("DATA_Show"));
            	sl.setLugar_nome(rs.getString("ONDE"));
            	sl.setCapacidade(rs.getInt("CAPACIDADE"));
            	
            	int numBandas = 0;
            	numBandas = sb.countBandaPorShow(sl.getShow_Id());
                sl.setNumBandas(numBandas);
                
            	shows.add(sl);
            }
            
            rs.close();
            stmt.close();
            
            return shows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	

	public void deletarLocalPorShow(int idShow) {
        String sql = "delete from showsPorLocal where show_id=?";
                
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
		
			stmt.setInt(1, idShow);
			
			stmt.execute();
			stmt.close();
		
					
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	public void deletarShowPorLocal(int idLocal) {
        String sql = "delete from showsPorLocal where local_id=?";
                
        try {        	
			PreparedStatement stmt = connection.prepareStatement(sql);
		
			stmt.setInt(1, idLocal);
			
			stmt.execute();
			stmt.close();
		
					
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
	}
	
	
	
}