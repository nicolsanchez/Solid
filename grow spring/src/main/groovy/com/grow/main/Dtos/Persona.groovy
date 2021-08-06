package com.grow.main.Dtos


class Persona {
    private Long Cedula
    private String Nombre
    private String Apellido

    Persona(){
        super()
    }

    Persona(Cedula, Nombre, Apellido){

        this.Cedula = Cedula
        this.Nombre = Nombre
        this.Apellido = Apellido

    }

    Long getCedula() {
        return Cedula
    }

    void setCedula(Long cedula) {
        this.Cedula = cedula
    }


    String getNombre() {
        return Nombre
    }

    void setNombre(String nombre) {
        this.Nombre = nombre
    }


    String getApellido() {
        return Apellido
    }

    void setApellido(String apellido) {
        this.Apellido = apellido
    }
}
