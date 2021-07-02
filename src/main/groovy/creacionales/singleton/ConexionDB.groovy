package creacionales.singleton

class ConexionDB {
    private static ConexionDB conexion

    private ConexionDB(){

    }

    static ConexionDB obtenerConexion(){

        if (conexion == null){
            conexion = new ConexionDB()
        }
        return  conexion
    }
}
