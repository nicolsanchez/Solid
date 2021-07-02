package estructurales.adapter

class ConexionMySQL implements  IConexionSql{

    void conexion(){
        println("Conexion con MySql")
    }

    String runQuery(){
        return "Consulta MySql"
    }
}
