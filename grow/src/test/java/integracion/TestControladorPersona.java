package integracion;

import co.com.plancrecimiento.Dtos.PersonaDTO;
import co.com.plancrecimiento.infraestructura.TestAceptacion;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TestControladorPersona extends TestAceptacion {

    private ResponseEntity<PersonaDTO> respuestaPost;
    private ResponseEntity<List<PersonaDTO>> respuestaGetConListado;
    private final String URL_PATH_API_PERSONAS = "/personas";
    private final String NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID = "id";
    private final String PATH_PARAM_ID = "/{"+NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID+"}";


    @Test
    public void darDeAltaUnaPersona(){
        respuestaPost = restTemplate.postForEntity(url + URL_PATH_API_PERSONAS,
                new PersonaDTO(1018472555L, "Nicolas", "Sanchez"), PersonaDTO.class);
    }
}
