package main.controladores

import main.Dtos.PersonaDTO
import main.implementacion.servicios.ServicioDePersona
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus

@RestController
class ControladorPersona {

    private ServicioDePersona servicioDePersona


    @PostMapping(path="/personas")
     ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO persona ){
        PersonaDTO personaDTO = servicioDePersona.crearPersona(persona)
        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED)
    }

    @GetMapping(path="/hello")
    String salutation() {
        return "Hello world!";
    }

    /*@DeleteMapping(path="/personas/{id}")
     ResponseEntity<Persona> deleteEmployee(@PathVariable Long id) {
        ResponseEntity<Persona> respuesta = null

        if(mapaDePersonas.containsKey(id)){
            mapaDePersonas.remove(id)
            respuesta = new ResponseEntity(null, HttpStatus.OK)
        } else {
            respuesta = new ResponseEntity(null, HttpStatus.NOT_FOUND)
        }
        return respuesta
    }

    @GetMapping(path="/personas")
     ResponseEntity<List<Persona>> buscarPersonas(){
        ResponseEntity<List<Persona>> respuesta = null
        respuesta = new ResponseEntity(mapaDePersonas.values(), HttpStatus.OK)
        return respuesta
    }

    @GetMapping(path="/personas/{id}")
     ResponseEntity<Persona> obtenerPersona(@PathVariable Long id){
        ResponseEntity<Persona> respuesta = null
        if(mapaDePersonas.containsKey(id)) {
            respuesta = new ResponseEntity(mapaDePersonas.get(id), HttpStatus.OK)
        } else {
            respuesta = new ResponseEntity(null, HttpStatus.NOT_FOUND)
        }
        return respuesta
    }*/
}
