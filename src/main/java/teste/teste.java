package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.Local;
import model.Show;
import model.ShowDAO;

public class teste {

	public static void main(String[] args) {
		/*Banda banda = new Banda();

		banda.setIdBanda(3);
		
		BandaDAO dao = new BandaDAO();
		
		//dao.adicionarBanda(banda);
		
		ArrayList<Banda> lista = dao.listarBandas();
		
		for (Banda banda2 : lista) {
			System.out.println(banda2.getIdBanda());
			System.out.println(banda2.getNome());
		}
		
		//dao.selecionarBanda(banda).getIdBanda();
		banda.setNome("banda2");
		banda.setGenero(Genero.ROCK);
		dao.alterarBanda(banda);
		
		dao.deletarBanda(banda);
		local.setCapacidade(500);
		local.setNome("RJ");
		
		//dao.adicionarLocal(local);
		
		ArrayList<Local> lista = dao.listarLocais();
		
		for (Local local2 : lista) {
			System.out.println(local2.getNome());
			System.out.println(local2.getCapacidade());
		}
		
		
		//System.out.println(dao.selecionarLocal(local).getNome());
		
		dao.alterarLocal(local);
		
		System.out.println(dao.selecionarLocal(local).getNome());
		
		//dao.deletarBanda(local);
		 
		
        Calendar dataNascimento = null;
		String dataEmTexto = "03/12/2002";
		
		try {
            Date date = new SimpleDateFormat("dd/MM/yyyy")
                  .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
            return; //para a execução do método
        }

		Show show = new Show();
		ShowDAO dao = new ShowDAO();
		
		show.setData(dataNascimento);
		show.setIdLocal(1);
		show.setIdShow(5);
		
		
		ArrayList<Show> lista = dao.listarShows();
		
		for (Show show2 : lista) {
			System.out.println(show2.getData().getTime());
			System.out.println(show2.getIdLocal());
		}
	
		show.setData(dataNascimento);
		dao.alterarShow(show);
		dao.deletarShow(show);*/
	}

}
