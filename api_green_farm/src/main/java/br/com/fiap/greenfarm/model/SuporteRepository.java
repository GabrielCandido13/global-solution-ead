package br.com.fiap.greenfarm.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.greenfarm.model.entity.Suporte;

public interface SuporteRepository extends JpaRepository<Suporte, Long> {

	Page<Suporte> findAllByAtivoTrue(Pageable paginacao);

}

