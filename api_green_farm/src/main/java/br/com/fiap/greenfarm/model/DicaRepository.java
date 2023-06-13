package br.com.fiap.greenfarm.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.greenfarm.model.entity.Dica;

public interface DicaRepository extends JpaRepository<Dica, Long> {

	Page<Dica> findAllByAtivoTrue(Pageable paginacao);

}
