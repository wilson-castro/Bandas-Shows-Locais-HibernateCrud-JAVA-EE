select id_banda as ID_Banda ,  nome as Nome_Banda,  genero  as Genero_Banda ,
     id_show as ID_Show, id_local as ID_Local, data as DATA_Showshows, nome_local as ONDE,  capacidade as CAPACIDADE
     from bandas 
     inner join showsPorBanda on bandas.id_banda = showsPorBanda.banda_id
     inner join shows on showsPorBanda.show_id = shows.id_show
	inner join locais on shows.local_id  = locais.id_local 
    where id_banda=1;
    
    select  id_show as ID_Show, id_local as ID_Local, data as DATA_Showshows, nome_local as ONDE,  capacidade as CAPACIDADE
	from shows  inner join locais on shows.local_id  = locais.id_local ;