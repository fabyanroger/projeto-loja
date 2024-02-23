package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        /*
        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p -> System.out.println(p.getNome()));

        List<Produto> todos = produtoDao.buscarPorNome("Samsung S24");
        todos.forEach(p -> System.out.println(p.getNome()));

        List<Produto> todos = produtoDao.buscarNomeDaCategoria("CELULARES");
        todos.forEach(p -> System.out.println(p.getNome()));
         */

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Samsung S24");
        System.out.println("Preço do produto: " + precoDoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Samsung S24", "256GB", new BigDecimal("5000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
