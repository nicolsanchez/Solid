package com.grow.main.implementacion.interfaces

import com.grow.main.Dtos.Persona


interface IServicioDePersona {

    Persona obtenerPersonaPorId(Long id)
    Persona crearPersona(Persona personaDTO)
    boolean borrarPersonaPorCedula(Long id)

}