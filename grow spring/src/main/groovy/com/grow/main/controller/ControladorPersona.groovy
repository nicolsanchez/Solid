package com.grow.main.controller

import com.grow.main.Dtos.Persona
import com.grow.main.implementacion.interfaces.IServicioDePersona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus

@RestController
@Validated
class ControladorPersona {

    @Autowired
    private IServicioDePersona servicioDePersona

    @GetMapping("/hola")
    String saludo() {
        return "mundo"
    }

   @PostMapping(path="/personas")
    ResponseEntity<Persona> postPersona(@RequestBody Persona persona){
        Persona personaDTO = servicioDePersona.crearPersona(new Persona(1038429482, "Nicolas", "Sanchez"))
        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED)
    }

    @GetMapping(path="/personas/{id}")
    ResponseEntity<Persona> obtenerPersona(@PathVariable Long id){
        return new ResponseEntity<Persona>(servicioDePersona.obtenerPersonaPorId(id), HttpStatus.OK)
    }

    @DeleteMapping(path="/personas/{id}")
     ResponseEntity<Persona> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<Persona>(servicioDePersona.borrarPersonaPorCedula(id), HttpStatus.OK)
    }

    /*@GetMapping(path="/personas")
     ResponseEntity<List<Persona>> buscarPersonas(){
        ResponseEntity<List<Persona>> respuesta = null
        respuesta = new ResponseEntity(mapaDePersonas.values(), HttpStatus.OK)
        return respuesta
    }*/


}
