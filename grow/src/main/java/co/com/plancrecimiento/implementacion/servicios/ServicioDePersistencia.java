package co.com.plancrecimiento.implementacion.servicios;

import co.com.plancrecimiento.Dtos.PersonaDTO;
import co.com.plancrecimiento.implementacion.interfaces.IServicioDePersistencia;
import java.util.concurrent.ConcurrentHashMap;

public class ServicioDePersistencia implements IServicioDePersistencia {

    private static ConcurrentHashMap<Long, PersonaDTO> mapaDePersonas = new ConcurrentHashMap<>();


    public PersonaDTO guardarPersona(PersonaDTO personaDTO){
        mapaDePersonas.putIfAbsent(personaDTO.getCedula(), personaDTO);
        return personaDTO;
    }
    public void actualizarPersona(Long Cedula,PersonaDTO personaDTO){
        mapaDePersonas.replace(Cedula, personaDTO);
    };
    public PersonaDTO obtenerPersonaPorCedula(Long Cedula){
        return mapaDePersonas.get(Cedula);
    };
    public boolean borrarPersonaPorCedula(Long Cedula){
        if (obtenerPersonaPorCedula(Cedula) != null){
            mapaDePersonas.remove(Cedula);
            return true;
        }
        return false;
    };


}
