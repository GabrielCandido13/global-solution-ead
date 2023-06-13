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

import br.com.fiap.greenfarm.model.AtividadeRepository;
import br.com.fiap.greenfarm.model.dto.DadosAtualizacaoAtividade;
import br.com.fiap.greenfarm.model.dto.DadosCadastroAtividade;
import br.com.fiap.greenfarm.model.dto.DadosListagemAtividade;
import br.com.fiap.greenfarm.model.entity.Atividade;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {
	
	@Autowired
	private AtividadeRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroAtividade dados) {
		repository.save(new Atividade(dados));
	}
	
	@GetMapping
	public Page<DadosListagemAtividade> listar(@PageableDefault(size=3)Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemAtividade :: new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoAtividade dados) {
		Atividade atividade = new Atividade();
		atividade = repository.getReferenceById(dados.id_atividade());
		atividade.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id_atividade}")
	@Transactional
	public void excluir(@PathVariable Long id_atividade) {
		Atividade atividade = new Atividade();
		atividade = repository.getReferenceById(id_atividade);
		atividade.excluir();
	}

}