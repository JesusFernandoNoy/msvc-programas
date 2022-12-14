package org.healthcare.springcloud.msvc.programas.services;

import java.util.List;
import java.util.Optional;

import org.healthcare.springcloud.msvc.programas.models.Paciente;
import org.healthcare.springcloud.msvc.programas.models.entity.Programa;
import org.healthcare.springcloud.msvc.programas.repositories.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramaServiceImpl implements IProgramaService {

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

	/*
	 * Crear funcionalidad para recuperar la información de programa 
	 * con el listado de pacientes.
	 */
	@Override
	public Optional<Programa> porIdConPacientes(Long id) {		
        return Optional.empty();
	}

	/*
	 * Crear funcionalidad para asignar paciente en lista programaPacientes
	 */
	@Override
	public Optional<Paciente> asignarPaciente(Paciente paciente, Long programaId) {
		
        return Optional.empty();
	}


	

}
