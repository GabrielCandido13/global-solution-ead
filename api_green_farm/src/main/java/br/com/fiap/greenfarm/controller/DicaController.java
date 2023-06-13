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

import br.com.fiap.greenfarm.model.DicaRepository;
import br.com.fiap.greenfarm.model.dto.DadosAtualizacaoDica;
import br.com.fiap.greenfarm.model.dto.DadosCadastroDica;
import br.com.fiap.greenfarm.model.dto.DadosListagemDica;
import br.com.fiap.greenfarm.model.entity.Dica;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dicas")
public class DicaController {
	
	@Autowired
	private DicaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroDica dados) {
		repository.save(new Dica(dados));
	}
	
	@GetMapping
	public Page<DadosListagemDica> listar(
			@PageableDefault(size=3)
			Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDica :: new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoDica dados) {
		Dica dica = new Dica();
		dica = repository.getReferenceById(dados.id_dica());
		dica.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id_dica}")
	@Transactional
	public void excluir(@PathVariable Long id_dica) {
		Dica dica = new Dica();
		dica = repository.getReferenceById(id_dica);
		dica.excluir();
	}

}













