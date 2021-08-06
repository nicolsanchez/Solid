package main.implementacion.servicios

import main.Dtos.PersonaDTO
import main.excepciones.ApiException
import main.implementacion.interfaces.IServicioDePersona


//servicio
class ServicioDePersona implements IServicioDePersona {


    private ServicioDePersistencia servicioDePersistencia


    PersonaDTO obtenerPersonaPorId(Long id){
        PersonaDTO persona = servicioDePersistencia.obtenerPersonaPorCedula(id)
        if(persona == null){
            throw new ApiException("404", "Empleado no encontrado", HttpStatus.NOT_FOUND.value())
        }
        return persona
    }

     PersonaDTO crearPersona(PersonaDTO personaDTO){
        if(personaDTO.getCedula() == null){
            throw new ApiException("400", "Revise el documento de Identificacion", HttpStatus.BAD_REQUEST.value())
        }
        return servicioDePersistencia.guardarPersona(personaDTO)
    }

     boolean borrarPersonaPorCedula(Long id){
        boolean isDeleted = servicioDePersistencia.borrarPersonaPorCedula(id)
        if(!isDeleted){
            throw new ApiException("404", "Isle not found", HttpStatus.NOT_FOUND.value())
        }
        return isDeleted
    }
}

