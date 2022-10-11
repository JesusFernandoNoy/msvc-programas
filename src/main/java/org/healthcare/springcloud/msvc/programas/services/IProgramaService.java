package org.healthcare.springcloud.msvc.programas.services;

import java.util.List;
import java.util.Optional;

import org.healthcare.springcloud.msvc.programas.models.entity.Programa;

public interface IProgramaService {
	
	List<Programa> findAll();
    Optional<Programa> findById(Long id);    
    Programa save(Programa programa);
    void deleteById(Long id);
    
    //void eliminarCursoUsuarioPorId(Long id);

    /*
    metodos remotos
     */
    //Optional<Paciente> asignarUsuario(Paciente paciente, Long programaId);
    //Optional<Paciente> crearUsuario(Paciente paciente, Long programaId);
    //Optional<Paciente> eliminarUsuario(Paciente paciente, Long programaId);

}
