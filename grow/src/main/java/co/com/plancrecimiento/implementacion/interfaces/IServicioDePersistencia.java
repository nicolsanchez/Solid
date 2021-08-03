package co.com.plancrecimiento.implementacion.interfaces;

import co.com.plancrecimiento.Dtos.PersonaDTO;

public interface IServicioDePersistencia {
    PersonaDTO guardarPersona(PersonaDTO personaDTO);
    void actualizarPersona(Long Cedula, PersonaDTO personaDTO);
    PersonaDTO obtenerPersonaPorCedula(Long Cedula);
    boolean borrarPersonaPorCedula(Long Cedula);
}
