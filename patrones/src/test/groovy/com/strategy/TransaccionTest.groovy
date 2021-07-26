package com.strategy

import comportamiento.strategy.Transaccion
import comportamiento.strategy.deposito
import comportamiento.strategy.retiro
import spock.lang.Specification

class TransaccionTest extends Specification {

    def "Test Transaccion deposito"(){
        given:
        Transaccion deposito = new Transaccion(new deposito())
        Transaccion retiro = new Transaccion(new retiro())

        and:

        float resultadoDeposito = deposito.ejectarTransaccion(100, 20)
        float resultadoRetiro = retiro.ejectarTransaccion(100,20)

        expect:

        resultadoDeposito == 120
        resultadoRetiro == 80


    }
}
