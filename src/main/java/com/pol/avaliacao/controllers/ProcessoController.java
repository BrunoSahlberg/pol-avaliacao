package com.pol.avaliacao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pol.avaliacao.entities.Processo;
import com.pol.avaliacao.entities.ProcessoDTO;

import com.pol.avaliacao.services.ProcessoService;

@RestController
@RequestMapping(value = "/processos")
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	@PostMapping
	@ResponseBody
	public ProcessoDTO insertProcesso(@RequestBody ProcessoDTO processoDto) {
		return processoService.createProcesso(processoDto);
	}

	@GetMapping
	@ResponseBody
	public List<ProcessoDTO> getAll() {
		return processoService.getAll();
	}

	@GetMapping("/{processoId}")
	@ResponseBody
	public Optional<Processo> getProcesso(@PathVariable("processoId") Integer processoId) {
		return processoService.getProcesso(null, processoId);
	}

	@PutMapping("/{processoId}")
	@ResponseBody
	public ProcessoDTO updateProcesso(@PathVariable("processoId") Integer processoId,
			@RequestBody ProcessoDTO processoDto) {
		return processoService.updateProcesso(processoDto, processoId);
	}

	@DeleteMapping("/{processoId}")
	@ResponseBody
	public String deleteProcesso(@PathVariable("processoId") Integer processoId) {
		return processoService.deleteProcesso(processoId);
	}
}
