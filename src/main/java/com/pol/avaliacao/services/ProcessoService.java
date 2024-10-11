package com.pol.avaliacao.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pol.avaliacao.entities.Processo;
import com.pol.avaliacao.entities.ProcessoDTO;
import com.pol.avaliacao.repositories.ProcessoRepository;

@Service
public class ProcessoService {
	@Autowired
	private ProcessoRepository repository;

	public ProcessoDTO createProcesso(ProcessoDTO processoDto) {
		if (repository.existsById(processoDto.getNumero_processo())) {
			throw new IllegalArgumentException("O processo com este número já existe.");
		}

		Processo processo = new Processo();
		processo.setNumero_processo(processoDto.getNumero_processo());
		processo.setAutor(processoDto.getAutor());
		processo.setReu(processoDto.getReu());
		processo.setStatus(processoDto.getStatus());

		if (processoDto.getData_criacao() == null) {
			processo.setData_criacao(LocalDate.now()); // Define a data atual
		} else {
			processo.setData_criacao(processoDto.getData_criacao());
		}

		repository.save(processo);
		return processoDto;
	}

	public ProcessoDTO updateProcesso(ProcessoDTO processoDto, Integer processoId) {
		Processo processoDb = repository.getReferenceById(processoId);

		if (processoDto.getReu() != null && !processoDto.getReu().isEmpty()) {
			processoDb.setReu(processoDto.getReu());
		}

		if (processoDto.getAutor() != null && !processoDto.getAutor().isEmpty()) {
			processoDb.setAutor(processoDto.getAutor());
		}

		if (processoDto.getStatus() != null && !processoDto.getStatus().isEmpty()) {
			processoDb.setStatus(processoDto.getStatus());
		}

		repository.save(processoDb);
		return processoDto;
	}

	private ProcessoDTO converter(Processo processo) {
		ProcessoDTO result = new ProcessoDTO();
		result.setNumero_processo(processo.getNumero_processo());
		result.setReu(processo.getReu());
		result.setAutor(processo.getAutor());
		result.setStatus(processo.getStatus());
		result.setData_criacao(processo.getData_criacao());
		return result;
	}

	public List<ProcessoDTO> getAll() {
		return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
	}

	public Optional<Processo> getProcesso(ProcessoDTO processoDto, Integer processoId) {
		return repository.findById(processoId);

	}

	public String deleteProcesso(Integer processoId) {
		if (!repository.existsById(processoId)) {
			throw new IllegalArgumentException("O processo com este número não existe no banco de dados.");
		}
		repository.deleteById(processoId);
		return "Processo " + processoId + " deletado!";
	}

}
