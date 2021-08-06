package com.grow.main.implementacion.servicios

import com.grow.main.Dtos.Persona
import com.grow.main.implementacion.interfaces.IServicioDePersistencia
import org.springframework.stereotype.Service

import java.util.concurrent.ConcurrentHashMap

@Service
class ServicioDePersistencia implements IServicioDePersistencia {

    private static ConcurrentHashMap<Long, Persona> mapaDePersonas = new ConcurrentHashMap<>()

    @Override
    Persona guardarPersona(Persona personaDTO){
        mapaDePersonas.putIfAbsent(personaDTO.getCedula(), personaDTO)
        return personaDTO
    }
    @Override
    void actualizarPersona(Long Cedula, Persona personaDTO){
        mapaDePersonas.replace(Cedula, personaDTO)
    }
    @Override
    Persona obtenerPersonaPorCedula(Long Cedula){
        return mapaDePersonas.get(Cedula)
    }
    @Override
    boolean borrarPersonaPorCedula(Long Cedula){
        if (obtenerPersonaPorCedula(Cedula) != null){
            mapaDePersonas.remove(Cedula)
            return true
        }
        return false
    }


}
