package main.implementacion.interfaces

import main.Dtos.PersonaDTO


interface IServicioDePersona {

    PersonaDTO obtenerPersonaPorId(Long id)
    PersonaDTO crearPersona(PersonaDTO personaDTO)
    boolean borrarPersonaPorCedula(Long id)

}