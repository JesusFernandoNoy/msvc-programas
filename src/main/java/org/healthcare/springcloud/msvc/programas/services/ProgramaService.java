package org.healthcare.springcloud.msvc.programas.services;

import java.util.List;
import java.util.Optional;

import org.healthcare.springcloud.msvc.programas.models.entity.Programa;
import org.healthcare.springcloud.msvc.programas.repositories.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramaService implements IProgramaService {

	@Autowired
	ProgramaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Programa> findAll() {
		return (List<Programa>) repository.findAll();
	}

	@Override
	public Optional<Programa> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Programa save(Programa programa) {
		return repository.save(programa);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);		
	}
}
