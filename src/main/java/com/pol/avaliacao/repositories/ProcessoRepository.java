package com.pol.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pol.avaliacao.entities.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer> {
}
