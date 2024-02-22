package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos") /* Utilizo @Table para mapear a classe Produto para a tabela "produtos" no banco de dados */
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    /* @Column(name = "desc") Se necessário mudar nome de variável, utilizo @Column para mapear o atributo 'descricao' para a coluna 'desc' no banco de dados */
    private String descricao;
    private BigDecimal preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}