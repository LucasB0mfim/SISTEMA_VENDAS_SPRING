package br.com.lbomfim.NotaFiscal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.lbomfim.domain.Produto;
import br.com.lbomfim.domain.ProdutoVenda;
import br.com.lbomfim.domain.Venda;
import br.com.lbomfim.repository.IProdutoRepository;
import br.com.lbomfim.repository.IVendaRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.lbomfim.repository")
@EntityScan("br.com.lbomfim.*")
@ComponentScan(basePackages = "br.com.lbomfim")
public class NotaFiscalApplication implements CommandLineRunner {

	@Autowired
	private IProdutoRepository prod_repository;

	@Autowired
	private IVendaRepository venda_repository;

	public static void main(String[] args) {
		SpringApplication.run(NotaFiscalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		Produto produto1 = createProduto("BISCOITO TRELOSO CHOCOLATE", 2.50d);
		Produto produto2 = createProduto("REFRIGERANTE COCA COLA LATA", 3.00d);
		prod_repository.save(produto1);
		prod_repository.save(produto2);

		Map<Produto, Integer> produtosQuantidades = new HashMap<>();
		produtosQuantidades.put(produto1, 2);
		produtosQuantidades.put(produto2, 1);

		Venda venda = createVenda(produtosQuantidades);
		venda_repository.save(venda);
	}

	private Venda createVenda(Map<Produto, Integer> produtosQuantidades) {
		Venda venda = new Venda();
		List<ProdutoVenda> listaProdutos = new ArrayList<>();
		Double totalVenda = 0.0;

		for (Map.Entry<Produto, Integer> entry : produtosQuantidades.entrySet()) {
			Produto produto = entry.getKey();
			Integer quantidade = entry.getValue();

			ProdutoVenda produtoVenda = new ProdutoVenda();
			produtoVenda.setProduto(produto);
			produtoVenda.setQuantidade(quantidade);
			produtoVenda.setSubtotal(produto.getPRECO() * quantidade);
			produtoVenda.setVenda(venda);

			listaProdutos.add(produtoVenda);
			totalVenda += produtoVenda.getSubtotal();
		}

		venda.setProdutosVenda(listaProdutos);
		venda.setTOTAL(totalVenda);

		return venda;
	}

	private Produto createProduto(String descricao, double preco) {
		return Produto.builder().DESCRICAO(descricao).PRECO(preco).build();
	}
}