package com.grow.main.implementacion.servicios

import com.grow.main.Dtos.Persona
import com.grow.main.excepciones.ApiException
import com.grow.main.implementacion.interfaces.IServicioDePersistencia
import com.grow.main.implementacion.interfaces.IServicioDePersona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.http.HttpStatus

@Service
class ServicioDePersona implements IServicioDePersona {

    @Autowired
    private IServicioDePersistencia servicioDePersistencia

    @Override
    Persona obtenerPersonaPorId(Long id){
        Persona persona = servicioDePersistencia.obtenerPersonaPorCedula(id)
        if(persona == null){
            throw new ApiException("404", "Empleado no encontrado", HttpStatus.NOT_FOUND.value())
        }
        return persona
    }

    @Override
    Persona crearPersona(Persona personaDTO){
        if(personaDTO.getCedula() == null){
            throw new ApiException("400", "Revise el documento de Identificacion", HttpStatus.BAD_REQUEST.value())
        }
        return servicioDePersistencia.guardarPersona(personaDTO)
    }

    @Override
    boolean borrarPersonaPorCedula(Long id){
        boolean isDeleted = servicioDePersistencia.borrarPersonaPorCedula(id)
        if(!isDeleted){
            throw new ApiException("404", "Isle not found", HttpStatus.NOT_FOUND.value())
        }
        return isDeleted
    }
}

