package estructurales.adapter

class ConexionMongoDB implements IconexionNoSQL{

    void conexion(){
        println("Conexion con MongoDB")
    }

    String executeSentence(){
        return "Consulta MongoDB"
    }
}
