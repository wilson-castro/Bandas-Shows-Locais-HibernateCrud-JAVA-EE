package teste;

import java.util.ArrayList;

import model.beans.Local;
import model.dao.LocalDAO;

public class teste {

	public static void main(String[] args) {
		/*Banda banda = new Banda();

		banda.setIdBanda(3);
		
		BandaDAO dao = new BandaDAO();
		
		//dao.adicionarBaanda);
		
		Genero[] generos = {};
		
		ArrayList<Banda> lista = dao.listarBandasComFiltro("z", generos);
		
		for (Banda banda2 : lista) {
			System.out.println(banda2.getIdBanda());
			System.out.println(banda2.getNome());
		}
		
		//dao.selecionarBanda(banda).getIdBanda();
		banda.setNome("banda2");
		banda.setGenero(Genero.ROCK);
		dao.alterarBanda(banda);
		
		dao.deletarBanda(banda);
		
		*/
		
		
		// LOCAL CRUD TESTE
	    Local local = new Local();
		LocalDAO dao = new LocalDAO();
		
		
		local.setCapacidade(500);
		local.setNome("SP");
		
		
		ArrayList<Local> lista = dao.listarLocais();
		
		for (Local local2 : lista) {
			System.out.println(local2.getNome());
			System.out.println(local2.getCapacidade());
		}
		
		local.setIdLocal(4);
		local.setCapacidade(300);
		local.setNome("MG");
		
		int idShow = 2;
		
		dao.adicionarLocal(local,2);

		
		//dao.alterarLocal(local);
		//dao.deletarLocal(local);
		
        
		
		/*Show show = new Show();
		ShowDAO dao = new ShowDAO();
		
		
		show.setData("02/08/2052");
		show.setIdLocal(1);
		
		int id_Banda = 2;*/
		
		//dao.adicionarShow(show,id_Banda);
		
		/*ArrayList<Show> lista = dao.listarShows();
		
		for (Show show2 : lista) {
			System.out.println(show2.getData().getTime());
			System.out.println(show2.getIdLocal());
		}
	
		dao.alterarShow(show);
		dao.deletarShow(show);*/
		
		/*ShowBanda sb = new ShowBanda();
		sb.setId_banda(1);
		sb.setId_show(6);
		
		ShowsBandaDAO sbdao = new ShowsBandaDAO();
		sbdao.adicionar(sb);*/
	}

}
