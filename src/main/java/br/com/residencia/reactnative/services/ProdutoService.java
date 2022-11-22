package br.com.residencia.reactnative.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.residencia.reactnative.VO.ProdutosVO;
import br.com.residencia.reactnative.entities.Produto;
import br.com.residencia.reactnative.exceptions.RegistryNotFoundException;
import br.com.residencia.reactnative.repositories.CategoriaRepository;
import br.com.residencia.reactnative.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	public List<Produto> findByNome (String nome) {
        return produtoRepository.findByNome(nome);
    }
	
	public Produto findById(Integer id) {
		Optional <Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new RegistryNotFoundException(id));
	}
	
	public List<Produto> findAll(Pageable page) {
		return produtoRepository.findAll(page).getContent();
	}
	
	public Long count() {
		return produtoRepository.count();
	}
	
	public void deleteLogical(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if(produto.isPresent()) {
			produtoRepository.deleteById(id);
		}
	}
	
	public Produto save(ProdutosVO produto) {

        Produto novoProduto = new Produto();

		Integer id = null;
		novoProduto.setId( (null == id) ? produto.getId() : id);
        novoProduto.setNome(produto.getNome());
        novoProduto.setPreco(produto.getPreco());
        novoProduto.setQtdEstoque(produto.getQtdEstoque());
        novoProduto.setDescricao(produto.getDescricao());
        novoProduto.setFoto(produto.getFoto());
        novoProduto.setCategoria(categoriaRepository.findById(produto.getCategoriaId()).get());

        novoProduto = produtoRepository.save(novoProduto);
        return novoProduto;
	}
	
	public Produto update(ProdutosVO produto, Integer id) {
		Produto novoProduto = produtoRepository.findById(id).get();
        updateDados (novoProduto, produto);
        return produtoRepository.save(novoProduto);
	}
	
	private void updateDados(Produto novoProduto, ProdutosVO produto) {
	       
        if (produto.getNome()!=null){
            novoProduto.setNome(produto.getNome());
        }

        if (produto.getDescricao()!=null){
            novoProduto.setDescricao(produto.getDescricao());
        }

        if (produto.getPreco()!=null){
            novoProduto.setPreco(produto.getPreco());
        }

        if (produto.getQtdEstoque()!=null){
            novoProduto.setQtdEstoque(produto.getQtdEstoque());
        }
        
        if (produto.getFoto()!=null){
            novoProduto.setFoto(produto.getFoto());
        }

        if (categoriaRepository.findById(produto.getCategoriaId()).get()!=null){
            novoProduto.setCategoria(categoriaRepository.findById(produto.getCategoriaId()).get());
        }
    }
	
}
