package com.juliocesar.CursoModelagemConceitual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juliocesar.CursoModelagemConceitual.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
		
}
