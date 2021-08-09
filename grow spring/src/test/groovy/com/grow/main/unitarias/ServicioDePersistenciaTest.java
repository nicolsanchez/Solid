package com.grow.main.unitarias;

import com.grow.main.Dtos.Persona;
import com.grow.main.implementacion.servicios.ServicioDePersistencia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDePersistenciaTest {

    Persona nicolas = new Persona(103564234, "Nicolas", "Sanchez");
    Persona miguel = new Persona(1924738902, "Miguel", "Triana");

    ServicioDePersistencia persistencia = new ServicioDePersistencia();

    @Test
    void guardarPersona() {
        Persona persona = dadoQueExisteUnaPersona(nicolas);
        assertEquals(persona, nicolas);
    }

    @Test
    void guardarPersonaIdYaExistente() {
        Persona personaexistente = dadoQueExisteUnaPersona(nicolas);
        persistencia.guardarPersona(new Persona(103564234, "Andres", "Gonzalez"));
        assertEquals(personaexistente, persistencia.obtenerPersonaPorCedula(103564234L));
    }

    @Test
    void actualizarPersona() {
        dadoQueExisteUnaPersona(nicolas);
        nicolas.setNombre("Carlos");
        persistencia.actualizarPersona(103564234L, nicolas);
        assertEquals(nicolas.getNombre(), "Carlos");

    }

    @Test
    void obtenerPersonaPorCedula() {
        dadoQueExisteUnaPersona(miguel);
        assertEquals(miguel,persistencia.obtenerPersonaPorCedula(1924738902L));
    }

    @Test
    void borrarPersonaPorCedula() {
        dadoQueExisteUnaPersona(miguel);
        Boolean borrado = persistencia.borrarPersonaPorCedula(1924738902L);
        assertTrue(borrado);
        borrado = persistencia.borrarPersonaPorCedula(1924738902L);
        assertFalse(borrado);
    }

     Persona dadoQueExisteUnaPersona(Persona persona){
        Persona nuevapersona =  persistencia.guardarPersona(persona);
        return nuevapersona;
    }

}