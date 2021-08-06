package co.com.plancrecimiento.controladores;

import co.com.plancrecimiento.Dtos.PersonaDTO;
import co.com.plancrecimiento.implementacion.servicios.ServicioDePersona;
import co.com.plancrecimiento.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControladorPersona {

    @Autowired
    private ServicioDePersona servicioDePersona;

    @PostMapping(path="/personas")
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO persona ){
        PersonaDTO personaDTO = servicioDePersona.crearPersona(persona);
        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(path="/personas/{id}")
    public ResponseEntity<Persona> deleteEmployee(@PathVariable Long id) {
        servicioDePersona.borrarPersonaPorCedula(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path="/ping")
    public String buscarPersonas(){
        return "pong";
    }

    @GetMapping(path="/personas/{id}")
    public ResponseEntity<PersonaDTO> obtenerPersona(@PathVariable Long id){
        return new ResponseEntity<>(servicioDePersona.obtenerPersonaPorId(id), HttpStatus.OK);

    }

}
