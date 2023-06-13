package br.com.fiap.greenfarm.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.greenfarm.model.entity.Atividade;


public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

	Page<Atividade> findAllByAtivoTrue(Pageable paginacao);

}
