package comportamiento.strategy

class Transaccion {

    private IEstrategia estrategia

    Transaccion(IEstrategia estrategia){
        this.estrategia = estrategia
    }

    float ejectarTransaccion(float balance, float cantidad){
        return this.estrategia.realizarOperacion(balance, cantidad)
    }
}
