package org.healthcare.springcloud.msvc.programas.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.healthcare.springcloud.msvc.programas.models.Paciente;

@Entity
@Table(name="programas")
public class Programa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="programa_id")
    private List<ProgramaPaciente> programaPacientes;

    @Transient
    private List<Paciente> pacientes;
    
    public Programa(){
    	programaPacientes = new ArrayList<>();
    	pacientes = new ArrayList<>();
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ProgramaPaciente> getProgramaPacientes() {
		return programaPacientes;
	}

	public void setProgramaPacientes(List<ProgramaPaciente> programaPacientes) {
		this.programaPacientes = programaPacientes;
	}
	
	/*
	 * poder manipular la lista programaPacientes adicionar y eliminar 
	 */
	
	public void addProgramaPaciente(ProgramaPaciente programaPaciente){
		programaPacientes.add(programaPaciente);
    }

    public void removeProgramaPaciente(ProgramaPaciente programaPaciente){
    	programaPacientes.remove(programaPaciente);
    }


	public List<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}	
	
}
