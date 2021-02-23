package br.repository;

import br.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   List<Produto> findByNome(String nome);

   List<Produto> findByTamanho(String tamanho);
}
