package co.com.plancrecimiento.implementacion.servicios;

import co.com.plancrecimiento.Dtos.PersonaDTO;
import co.com.plancrecimiento.excepciones.ApiException;
import co.com.plancrecimiento.implementacion.interfaces.IServicioDePersona;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServicioDePersona implements IServicioDePersona {


    private ServicioDePersistencia servicioDePersistencia;


    public PersonaDTO obtenerPersonaPorId(Long id){
        PersonaDTO persona = servicioDePersistencia.obtenerPersonaPorCedula(id);
        if(persona == null){
            throw new ApiException("404", "Empleado no encontrado", HttpStatus.NOT_FOUND.value());
        }
        return persona;
    }

    public PersonaDTO crearPersona(PersonaDTO personaDTO){
        if(personaDTO.getCedula() == null){
            throw new ApiException("400", "Revise el documento de Identificacion", HttpStatus.BAD_REQUEST.value());
        }
        return servicioDePersistencia.guardarPersona(personaDTO);
    }

    public boolean borrarPersonaPorCedula(Long id){
        boolean isDeleted = servicioDePersistencia.borrarPersonaPorCedula(id);
        if(!isDeleted){
            throw new ApiException("404", "Isle not found", HttpStatus.NOT_FOUND.value());
        }
        return isDeleted;
    }
}
