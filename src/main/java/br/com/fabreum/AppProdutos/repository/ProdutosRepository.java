package br.com.fabreum.AppProdutos.repository;

import br.com.fabreum.AppProdutos.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
