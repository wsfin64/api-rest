package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")  // endpont raiz da api
@Api(value = "API REST Produtos")  // Anotação do swagger
@CrossOrigin(origins = "*")  // permitindo acessos de qualquer domínio
public class ProdutoResource {

    @Autowired  // fazendo a injeção da dependencia de produtorepository para assim, utilizar os metodos do BD
    ProdutoRepository produtoRepository;


    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }


    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um produto específico via ID")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Salva um novo produto no banco de dados")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = "Deleta um produto específico")
    public void deletarProduto(@RequestBody Produto produto){
        produtoRepository.deleteById(produto.getId());
        // Desta forma, estamos buscando um produdo pelo id, e em seguida, deletando-o
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
        // Desta forma,será necessário passar um produto inteiro, onde será atualizado pelo ID
    }


}
