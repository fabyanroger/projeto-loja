package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {


        Produto celular = new Produto();

        celular.setNome("Samsung S24");
        celular.setDescricao("256GB");
        celular.setPreco(new BigDecimal("5000"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
