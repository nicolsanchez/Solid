package main.implementacion.servicios

import main.Dtos.PersonaDTO
import main.implementacion.interfaces.IServicioDePersistencia

import java.util.concurrent.ConcurrentHashMap


class ServicioDePersistencia implements IServicioDePersistencia {

    private static ConcurrentHashMap<Long, PersonaDTO> mapaDePersonas = new ConcurrentHashMap<>()


     PersonaDTO guardarPersona(PersonaDTO personaDTO){
        mapaDePersonas.putIfAbsent(personaDTO.getCedula(), personaDTO)
        return personaDTO
    }
     void actualizarPersona(Long Cedula,PersonaDTO personaDTO){
        mapaDePersonas.replace(Cedula, personaDTO)
    }
     PersonaDTO obtenerPersonaPorCedula(Long Cedula){
        return mapaDePersonas.get(Cedula)
    }
     boolean borrarPersonaPorCedula(Long Cedula){
        if (obtenerPersonaPorCedula(Cedula) != null){
            mapaDePersonas.remove(Cedula)
            return true
        }
        return false
    }


}