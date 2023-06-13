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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.greenfarm.model.SuporteRepository;
import br.com.fiap.greenfarm.model.dto.DadosCadastroSuporte;
import br.com.fiap.greenfarm.model.dto.DadosListagemSuporte;
import br.com.fiap.greenfarm.model.entity.Suporte;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/suportes")
public class SuporteController {
	
	@Autowired
	private SuporteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroSuporte dados) {
		repository.save(new Suporte(dados));
	}
	
	@GetMapping
	public Page<DadosListagemSuporte> listar(
			@PageableDefault(size=3)
			Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemSuporte :: new);
	}
	
	@DeleteMapping("/{id_suporte}")
	@Transactional
	public void excluir(@PathVariable Long id_suporte) {
		Suporte suporte = new Suporte();
		suporte = repository.getReferenceById(id_suporte);
		suporte.excluir();
	}

}