package br.com.fiap.greenfarm.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.greenfarm.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Page<Usuario> findAllByAtivoTrue(Pageable paginacao);

}
