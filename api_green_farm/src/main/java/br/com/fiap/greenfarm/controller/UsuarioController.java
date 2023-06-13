package br.com.fiap.greenfarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.greenfarm.model.UsuarioRepository;
import br.com.fiap.greenfarm.model.dto.DadosAtualizacaoUsuario;
import br.com.fiap.greenfarm.model.dto.DadosCadastroUsuario;
import br.com.fiap.greenfarm.model.dto.DadosListagemUsuario;
import br.com.fiap.greenfarm.model.entity.Usuario;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
		repository.save(new Usuario(dados));
	}
	
	@GetMapping
	public Page<DadosListagemUsuario> listar(
			@PageableDefault(size=3)
			Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario :: new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
		Usuario usuario = new Usuario();
		usuario = repository.getReferenceById(dados.id_usuario());
		usuario.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id_usuario}")
	@Transactional
	public void excluir(@PathVariable Long id_usuario) {
		Usuario usuario = new Usuario();
		usuario = repository.getReferenceById(id_usuario);
		usuario.excluir();
	}

}