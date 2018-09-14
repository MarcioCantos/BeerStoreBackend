package com.vd0.beerstore.dao;

import com.vd0.beerstore.entity.Cliente;
import com.vd0.beerstore.entity.Endereco;
import com.vd0.beerstore.entity.beer.Atributos;
import com.vd0.beerstore.entity.beer.Cerveja;
import com.vd0.beerstore.entity.beer.Imagens;
import com.vd0.beerstore.entity.beer.Produtor;
import com.vd0.beerstore.entity.beer.TipoCerveja;
import com.vd0.beerstore.entity.beer.Wishlist;

public class FabricaDao {

	public static Dao<Cliente> createDaoCliente(){
		return new ClienteDao();
	}
	
	public static Dao<Endereco> createDaoEndereco(){
		return new EnderecoDao();
	}
	
	public static Dao<Atributos> createDaoAtributos(){
		return new AtributosDao();
	}
	
	public static Dao<Cerveja> createDaoCerveja(){
		return new CervejaDao();
	}
	
	public static Dao<TipoCerveja> createDaoTipoCerveja(){
		return new TipoCervejaDao();
	}
	
	public static Dao<Wishlist> createDaoWishlist(){
		return new WishlistDao();
	}
	
	public static Dao<Produtor> createDaoProdutor(){
		return new ProdutorDao();
	}

	public static Dao<Imagens> createDaoImagens(){
		return new ImagensDao();
	}
	
}
