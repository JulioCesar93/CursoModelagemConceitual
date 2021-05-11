package com.juliocesar.ModeloConceitual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.juliocesar.ModeloConceitual.domain.Categoria;
import com.juliocesar.ModeloConceitual.domain.Cidade;
import com.juliocesar.ModeloConceitual.domain.Cliente;
import com.juliocesar.ModeloConceitual.domain.Endereco;
import com.juliocesar.ModeloConceitual.domain.Estado;
import com.juliocesar.ModeloConceitual.domain.Produto;
import com.juliocesar.ModeloConceitual.domain.enums.TipoCliente;
import com.juliocesar.ModeloConceitual.repositories.CategoriaRepository;
import com.juliocesar.ModeloConceitual.repositories.CidadeRepository;
import com.juliocesar.ModeloConceitual.repositories.ClienteRepository;
import com.juliocesar.ModeloConceitual.repositories.EnderecoRepository;
import com.juliocesar.ModeloConceitual.repositories.EstadoRepository;
import com.juliocesar.ModeloConceitual.repositories.ProdutoRepository;

@ComponentScan
@SpringBootApplication
public class ModeloConceitualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ModeloConceitualApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c1, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Santos", "maria@gmail.com", "11122230085", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3432315454", "34991707070"));
		
		Endereco e1 = new Endereco(null, "Rua Jupiter", "500", "Casa 2", "Morumbi", "38408-210", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Amazonas", "22", "S", "Zema", "39408-807", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

	
	}


