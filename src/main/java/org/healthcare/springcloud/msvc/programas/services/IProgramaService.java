package org.healthcare.springcloud.msvc.programas.services;

import java.util.List;
import java.util.Optional;

import org.healthcare.springcloud.msvc.programas.models.entity.Programa;

public interface IProgramaService {
	
	List<Programa> findAll();
    Optional<Programa> findById(Long id);    
    Programa save(Programa programa);
    void deleteById(Long id);      

}
