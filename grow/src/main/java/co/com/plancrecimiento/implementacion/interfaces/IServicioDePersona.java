package co.com.plancrecimiento.implementacion.interfaces;

import co.com.plancrecimiento.Dtos.PersonaDTO;
import co.com.plancrecimiento.modelo.Persona;

public interface IServicioDePersona {

    PersonaDTO obtenerPersonaPorId(Long id);
    PersonaDTO crearPersona(PersonaDTO personaDTO);
    boolean borrarPersonaPorCedula(Long id);

}
