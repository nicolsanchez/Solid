package main.implementacion.interfaces

import main.Dtos.PersonaDTO

interface IServicioDePersistencia {
    PersonaDTO guardarPersona(PersonaDTO personaDTO)
    void actualizarPersona(Long Cedula, PersonaDTO personaDTO)
    PersonaDTO obtenerPersonaPorCedula(Long Cedula)
    boolean borrarPersonaPorCedula(Long Cedula)
}