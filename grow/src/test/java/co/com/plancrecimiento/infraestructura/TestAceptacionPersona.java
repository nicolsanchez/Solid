package co.com.plancrecimiento.infraestructura;


import co.com.plancrecimiento.modelo.Persona;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAceptacionPersona extends TestAceptacion{

    private ResponseEntity<Persona> respuestaPost;
    private ResponseEntity<List<Persona>> respuestaGetConListado;
    private final String URL_PATH_API_PERSONAS = "/personas"; // TODO: static final en Controller, usar dentro de anotación de mapping
    private final String NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID = "id";
    private final String PATH_PARAM_ID = "/{"+NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID+"}";

    @Test
    public void debePoderDarDeAltaUnaPersona(){
        dadoQueEnElSistemaNoExisteLaPersonaCuyoNombreYApellidoEs("Juan","Garcia");
        cuandoSeDaDeAltaEnElSistemaALaPersona("Juan","Garcia");
        entoncesDebeExistirLaPersonaConIdDistintoDeNullSiendoSuNombreYApellido("Juan","Garcia");
    }

    @Test
    public void debePoderDarDeBajaUnaPersona(){
        dadoQueSeInvocaAlSistemaAlAltaDePersonaConNombreYApellido("Juan","Garcia");
        dadoQueSeInvocaAlSistemaAlAltaDePersonaConNombreYApellido("Maria","Lopez");
        dadoQueSeInvocaAlSistemaAlAltaDePersonaConNombreYApellido("Natalia","Da Vinci");
        dadoQueSeInvocaAlSistemaParaObtenerElListadoDePersonas();
        cuandoSeInvocaAlSistemaParaEliminarLaPersonaCuyoNombreEs("Maria","Lopez");
        entoncesCuandoSeConsultaAlSistemaNoDebeExistirLaPersona("Maria","Lopez");
    }

    private void dadoQueEnElSistemaNoExisteLaPersonaCuyoNombreYApellidoEs(String nombre, String apellido) {
        respuestaGetConListado = restTemplate.exchange(url + URL_PATH_API_PERSONAS, HttpMethod.GET, null, new ParameterizedTypeReference<List<Persona>>() {});
        Boolean laPersonaNoExiste = respuestaGetConListado.getBody().stream()
                .filter(p -> (p.getNombre().equals(nombre) && p.getApellido().equals(apellido) ))
                .findFirst().isEmpty();
        assertThat(laPersonaNoExiste).isTrue();
    }

    private void dadoQueSeInvocaAlSistemaAlAltaDePersonaConNombreYApellido(String nombre, String apellido) {
        this.respuestaPost = restTemplate.postForEntity(url + URL_PATH_API_PERSONAS, new Persona(null, nombre, apellido), Persona.class);
    }

    private void dadoQueSeInvocaAlSistemaParaObtenerElListadoDePersonas() {
        respuestaGetConListado = restTemplate.exchange(url + URL_PATH_API_PERSONAS, HttpMethod.GET, null, new ParameterizedTypeReference<List<Persona>>() {});
    }

    private void cuandoSeDaDeAltaEnElSistemaALaPersona(String nombre, String apellido) {
        this.respuestaPost = restTemplate.postForEntity(url + URL_PATH_API_PERSONAS, new Persona(null, nombre, apellido), Persona.class);
    }

    private void cuandoSeInvocaAlSistemaParaEliminarLaPersonaCuyoNombreEs(String nombre, String apellido) {
        String idPersonaAEliminar = respuestaGetConListado.getBody()
                                        .stream()
                                        .filter(p -> (p.getNombre().equals(nombre) && p.getApellido().equals(apellido) ))
                                        .findFirst().get().getId().toString();

        Map<String, String> pathParamsMap = new HashMap<String, String>();

        pathParamsMap.put(NOMBRE_ATRIBUTO_ID_PATH_PARAM_ID, idPersonaAEliminar);
        restTemplate.delete(url + URL_PATH_API_PERSONAS + PATH_PARAM_ID, pathParamsMap );
    }


    private void entoncesDebeExistirLaPersonaConIdDistintoDeNullSiendoSuNombreYApellido(String nombre, String apellido) {
        Long idPersonaEsperado = this.respuestaPost.getBody().getId();
        respuestaGetConListado = restTemplate.exchange(url + URL_PATH_API_PERSONAS, HttpMethod.GET, null, new ParameterizedTypeReference<List<Persona>>() {});
        Long idPersonaActual = respuestaGetConListado.getBody().stream()
                .filter(p -> (p.getNombre().equals(nombre) && p.getApellido().equals(apellido) ))
                .findFirst().get().getId();

        assertThat(idPersonaActual).isNotNull();
        assertThat(idPersonaActual).isEqualTo(idPersonaEsperado);
    }


    private void entoncesCuandoSeConsultaAlSistemaNoDebeExistirLaPersona(String nombre, String apellido) {
        respuestaGetConListado = restTemplate.exchange(url + URL_PATH_API_PERSONAS, HttpMethod.GET, null, new ParameterizedTypeReference<List<Persona>>() {});
        Boolean laPersonaNoExiste = respuestaGetConListado.getBody().stream()
                .filter(p -> (p.getNombre().equals(nombre) && p.getApellido().equals(apellido) ))
                .findFirst().isEmpty();
        assertThat(laPersonaNoExiste).isTrue();
    }


}
