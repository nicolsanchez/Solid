package com.singleton

import spock.lang.Specification
import creacionales.singleton.ConexionDB

class ConexionDBTest extends Specification {

    def "Test that two conexion has the same hash code"(){
        given:
        ConexionDB conexion = ConexionDB.obtenerConexion()
        ConexionDB conexion2 = ConexionDB.obtenerConexion()

        expect:
        conexion.hashCode() == conexion2.hashCode()
    }
}
