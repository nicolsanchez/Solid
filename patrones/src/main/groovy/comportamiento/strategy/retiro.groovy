package comportamiento.strategy

class retiro implements IEstrategia{

    float realizarOperacion(float balance, float cantidad){
        return balance - cantidad
    }
}
