package org.healthcare.springcloud.msvc.programas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.healthcare.springcloud.msvc.programas.models.Paciente;
import org.healthcare.springcloud.msvc.programas.models.entity.Programa;
import org.healthcare.springcloud.msvc.programas.services.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramaController {

	@Autowired
    private IProgramaService service;
	
	@GetMapping
    public ResponseEntity<List<Programa>> listar(){
        return ResponseEntity.ok(service.findAll());
    }
	
    /*
     * Pendiente modificar metodo detalle para devolver el programa con 
     * pacientes asociados 
     */

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Programa> o = service.findById(id);
        
        if(o.isPresent()){
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Programa programa, BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }

        Programa programaDB = service.save(programa);
        return ResponseEntity.status(HttpStatus.CREATED).body(programaDB);
    }    


    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Programa programa, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validar(result);
        }

        Optional<Programa> o = service.findById(id);

        if(o.isPresent()){
        	Programa programaDb = o.get();
            programaDb.setNombre(programa.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(programaDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Programa> o = service.findById(id);
        if(o.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    /*
     * Pendiente desarrollar funcionalidad
     */
    @PutMapping("/asignar-paciente/{programaId}")
    public ResponseEntity<?> asignarPaciente(@RequestBody Paciente paciente, @PathVariable Long programaId){
        
        return ResponseEntity.notFound().build();
    }  
    
    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String,String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "el campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
    
    
	
}
