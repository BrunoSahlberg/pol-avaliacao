package com.pol.avaliacao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pol.avaliacao.entities.Processo;
import com.pol.avaliacao.entities.ProcessoDTO;
import com.pol.avaliacao.repositories.ProcessoRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class ProcessoService {
	@Autowired
	private ProcessoRepository repository;

	public ProcessoDTO createProcesso(ProcessoDTO processoDTO) {
		Processo processo = new Processo();
		processo.setNumero_processo(processoDTO.getNumero_processo());
		processo.setAutor(processoDTO.getAutor());
		processo.setReu(processoDTO.getReu());
		processo.setStatus(processoDTO.getStatus());
		processo.setData_criacao(processoDTO.getData_criacao());
		return processoDTO;
	}
	
	public ProcessoDTO updateProcesso(ProcessoDTO processoDTO, Integer processoId) {
		Processo processoDb = repository.getReferenceById(processoId);
		processoDb.setReu(processoDTO.getReu());
		processoDb.setAutor(processoDTO.getAutor());
		processoDb.setStatus(processoDTO.getStatus());
		return processoDTO;
	}
	
	  private ProcessoDTO converter (Processo processo) {
	        ProcessoDTO result = new ProcessoDTO();
	        result.setNumero_processo(processo.getNumero_processo());
	        result.setReu(processo.getReu());
	        result.setAutor(processo.getAutor());
	        result.setStatus(processo.getStatus());
	        result.setData_criacao(processo.getData_criacao());
	        return result;
	    }
	
	
	public List<ProcessoDTO> getAll(){
		return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
	}
	
	public String deleteProcesso(Integer processoId) {
		repository.deleteById(processoId);
		return "Processo deletado!";
	}
}
