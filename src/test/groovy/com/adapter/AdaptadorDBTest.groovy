package com.adapter

import estructurales.adapter.AdaptadorDB
import estructurales.adapter.ConexionMySQL
import estructurales.adapter.IConexionSql
import estructurales.adapter.ConexionMongoDB
import spock.lang.Specification


class AdaptadorDBTest extends Specification {

    def "Test adapter to Nosql"(){
        given:
        IConexionSql conexion = new AdaptadorDB(new ConexionMongoDB())
        conexion.conexion()

        and:

        String resultado = conexion.runQuery()

        expect:
        resultado == "Consulta MongoDB"

    }

    def "Test adapter to MySQL"(){
        given:
        IConexionSql conexion = new ConexionMySQL()
        conexion.conexion()

        and:

        String resultado = conexion.runQuery()

        expect:
        resultado == "Consulta MySql"

    }
}
