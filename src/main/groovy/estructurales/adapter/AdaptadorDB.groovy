package estructurales.adapter

class AdaptadorDB implements IConexionSql{

    private IconexionNoSQL noSQL

    AdaptadorDB(IconexionNoSQL noSQL){
        this.noSQL = noSQL
    }

    void conexion(){
        this.noSQL.conexion()
    }

    String runQuery(){
        return this.noSQL.executeSentence()
    }
}
