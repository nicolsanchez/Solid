package com.grow.main.implementacion.interfaces

import com.grow.main.Dtos.Persona

interface IServicioDePersistencia {
    Persona guardarPersona(Persona personaDTO)
    void actualizarPersona(Long Cedula, Persona personaDTO)
    Persona obtenerPersonaPorCedula(Long Cedula)
    boolean borrarPersonaPorCedula(Long Cedula)
}