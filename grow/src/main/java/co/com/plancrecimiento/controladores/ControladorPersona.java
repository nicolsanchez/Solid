package co.com.plancrecimiento.controladores;

import co.com.plancrecimiento.Dtos.PersonaDTO;
import co.com.plancrecimiento.implementacion.servicios.ServicioDePersona;
import co.com.plancrecimiento.modelo.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControladorPersona {

    private ServicioDePersona servicioDePersona;
    private static Map<Long, Persona> mapaDePersonas = new HashMap<Long, Persona>();

    @PostMapping(path="/personas")
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO persona ){
        PersonaDTO personaDTO = servicioDePersona.crearPersona(persona);
        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(path="/personas/{id}")
    public ResponseEntity<Persona> deleteEmployee(@PathVariable Long id) {
        ResponseEntity<Persona> respuesta = null;

        if(mapaDePersonas.containsKey(id)){
            mapaDePersonas.remove(id);
            respuesta = new ResponseEntity(null, HttpStatus.OK);
        } else {
            respuesta = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return respuesta;
    }

    @GetMapping(path="/personas")
    public ResponseEntity<List<Persona>> buscarPersonas(){
        ResponseEntity<List<Persona>> respuesta = null;
        respuesta = new ResponseEntity(mapaDePersonas.values(), HttpStatus.OK);
        return respuesta;
    }

    @GetMapping(path="/personas/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable Long id){
        ResponseEntity<Persona> respuesta = null;
        if(mapaDePersonas.containsKey(id)) {
            respuesta = new ResponseEntity(mapaDePersonas.get(id), HttpStatus.OK);
        } else {
            respuesta = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return respuesta;
    }


    private Long generarIdParaPersona(){
        Long ultimoId = null;
        if(mapaDePersonas.values().isEmpty()){
            ultimoId = 1L;
        }else{
            ultimoId = mapaDePersonas.values().stream()
                    .map(p -> p.getId())
                    .sorted((id1,id2) -> id2.compareTo(id1))
                    .findFirst().get() + 1L;
        }
        return ultimoId;
    }

}
