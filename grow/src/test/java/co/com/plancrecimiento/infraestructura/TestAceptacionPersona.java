package co.com.plancrecimiento.infraestructura;


import co.com.plancrecimiento.Dtos.PersonaDTO;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAceptacionPersona extends TestAceptacion{

    private ResponseEntity<PersonaDTO> respuestaPost;
    private ResponseEntity<List<PersonaDTO>> respuestaGetConListado;
    private final String URL_PATH_API_PERSONAS = "/personas"; // TODO: static final en Controller, usar dentro de anotación de mapping
    private final String NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID = "id";
    private final String PATH_PARAM_ID = "/{"+NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID+"}";

    @Test
    public void debePoderDarDeAltaUnaPersona(){
        cuandoSeDaDeAltaEnElSistemaALaPersona(10294758395L,"Juan","Garcia");
        entoncesDebeExistirLaPersonaConIdDistintoDeNullSiendoSuNombreYApellido("Juan","Garcia");
    }






    private void cuandoSeDaDeAltaEnElSistemaALaPersona(Long Cedula, String Nombre, String Apellido) {
        PersonaDTO persona = new PersonaDTO(Cedula, Nombre, Apellido);
        this.respuestaPost = restTemplate.postForEntity(url + URL_PATH_API_PERSONAS, persona, PersonaDTO.class);
    }



    private void entoncesDebeExistirLaPersonaConIdDistintoDeNullSiendoSuNombreYApellido(String nombre, String apellido) {
        Long idPersonaEsperado = this.respuestaPost.getBody().getCedula();
        assertThat(idPersonaEsperado).isNotNull();
    }

}
