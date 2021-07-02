 package comportamiento.strategy

 class deposito implements IEstrategia {

    float realizarOperacion(float balance, float cantidad){
        return balance + cantidad
    }
}
