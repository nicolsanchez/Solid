package com.grow.main.unitarias

import com.grow.main.excepciones.ApiException
import com.grow.main.implementacion.servicios.ServicioDePersona
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDePersonaTest {

    ServicioDePersona servicioDePersona = new ServicioDePersona()

    @Test
    void obtenerPersonaPorIdNullTest(){
       ApiException thrown =  assertThrows(ApiException.class,()->{
            servicioDePersona.obtenerPersonaPorId()
        });
        assertEquals(thrown.getMessage(), "Revise los datos de entrada")
        assertEquals(thrown.getStatusCode(), HttpStatus.BAD_REQUEST.value())
    }
}
