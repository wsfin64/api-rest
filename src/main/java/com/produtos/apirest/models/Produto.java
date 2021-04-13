package com.produtos.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;  // Isto faz com que o id do produto incie com 1 do tipo long

    @Id  // marcação da chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO)  // O id será gerado automaticamente
    private long id;

    private String nome;

    private BigDecimal quantidade;
    private BigDecimal valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }


}
