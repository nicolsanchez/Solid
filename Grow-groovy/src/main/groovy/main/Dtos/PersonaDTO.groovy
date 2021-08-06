package main.Dtos

class PersonaDTO {
    private Long Cedula;
    private String Nombre;
    private String Apellido;

    PersonaDTO(Long Cedula, String Nombre, String Apellido) {
        this.Cedula = Cedula
        this.Nombre = Nombre
        this.Apellido = Apellido
    };

    Long getCedula(){
        return Cedula;
    }

    String getNombreCompleto(){
        return Nombre.concat(Apellido)
    }
}
