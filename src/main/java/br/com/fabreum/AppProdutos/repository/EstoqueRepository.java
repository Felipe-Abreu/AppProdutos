package br.com.fabreum.AppProdutos.repository;

import br.com.fabreum.AppProdutos.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
