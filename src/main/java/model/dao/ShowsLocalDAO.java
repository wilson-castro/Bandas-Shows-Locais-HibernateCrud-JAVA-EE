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
	
	public ArrayList<ShowsLocal> listarShowPorLocal() {
		String sql = "select"
				+ " id_show as ID_Show,id_local as ID_Local, "
				+ "data as DATA_Show, nome_local as ONDE,"
				+ "  capacidade as CAPACIDADE  "
				+ "from shows "
				+ " inner join locais on shows.local_id  = locais.id_local;";
		
        try {
        	ArrayList<ShowsLocal> shows = new ArrayList<ShowsLocal>();
        	
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
            	ShowsLocal sl = new ShowsLocal();
            	
            	sl.setShow_Id(rs.getInt("ID_Show"));
            	sl.setLocal_Id(rs.getInt("ID_Local"));
            	sl.setData_show(rs.getString("DATA_Show"));
            	sl.setLugar_nome(rs.getString("ONDE"));
            	sl.setCapacidade(rs.getInt("CAPACIDADE"));
            	
                // adicionando o objeto à lista
            	shows.add(sl);
            }
            
            rs.close();
            stmt.close();
            
            return shows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
