package co.com.plancrecimiento.Dtos;

public class PersonaDTO {

    private Long Cedula;
    private String Nombre;
    private String Apellido;

    public PersonaDTO(Long Cedula, String Nombre, String Apellido) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    };

    public Long getCedula(){
        return Cedula;
    }

    public String getNombreCompleto(){
        return Nombre.concat(Apellido);
    }


}
