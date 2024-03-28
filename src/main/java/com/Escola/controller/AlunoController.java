package com.Escola.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Escola.entities.Aluno;
import com.Escola.service.AlunoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/itempedido")
public class AlunoController {
	
	private final AlunoService AlunoService;

	
	public AlunoController(AlunoService AlunoService) {
		this.AlunoService = AlunoService;
	}

	@GetMapping ("/{id}")

	public ResponseEntity<Aluno> buscaItemPedidoIdControlId (@ PathVariable Long id) {
		Aluno Aluno = AlunoService.buscaAlunoId(id);
		if (Aluno != null) {
			return ResponseEntity.ok(Aluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aluno>> buscaTodosAlunoControl(){
		List<Aluno> ItemPedido = AlunoService.buscaTodosAluno();
		return ResponseEntity.ok(ItemPedido);
	}
	@PostMapping("/")
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody  Aluno Aluno){
		Aluno salvaAluno= AlunoService.salvaAluno(Aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody Aluno Aluno){
		Aluno alterarAluno = AlunoService.alterarAluno(id, Aluno);
		if(alterarAluno != null) {
			return ResponseEntity.ok(alterarAluno);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAlunoControl(@PathVariable Long id){
		boolean Aluno = AlunoService.apagarAluno(id);
		if (Aluno) {
			return ResponseEntity.ok().body("O Aluno foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}
