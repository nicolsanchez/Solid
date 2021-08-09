package com.grow.main.funcionales

import com.grow.main.Dtos.Persona
import com.grow.main.excepciones.ApiException
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.*
import org.springframework.web.client.RestClientException

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class ControladorPersonaTest extends ControllerTest {


    @LocalServerPort
    private int port


    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/hola",
                String.class)).contains("mundo")
    }

    @Test
    void crearpersonastatus() throws Exception {
        ResponseEntity<Persona> responseEntity = this.testRestTemplate.postForEntity("/personas", new Persona(1038429482, "Nicolas", "Sanchez"), Persona.class)
        HttpStatus.OK.value() == responseEntity.getStatusCode()
    }

    @Test
    void obtenerpersonastatus() throws Exception {
        Long id = 1038429482
        this.testRestTemplate.postForEntity("/personas", new Persona(1038429482, "Nicolas", "Sanchez"), Persona.class)
        ResponseEntity<Persona> responseEntity = this.testRestTemplate.getForEntity("/personas/" + id, Persona.class)
        HttpStatus.OK == responseEntity.getStatusCode()
    }

    @Test
    void borrarpersonastatus() throws Exception {
        Long id = 1038429482
        this.testRestTemplate.postForEntity("/personas", new Persona(1038429482, "Nicolas", "Sanchez"), Persona.class)
        ResponseEntity<Boolean> responseEntity = this.testRestTemplate.exchange("/personas/" + id, HttpMethod.DELETE, this.getDefaultRequestEntity(), Boolean.class);
        HttpStatus.OK == responseEntity.getStatusCode()
        true == responseEntity.getBody()
        Assert.assertThrows(RestClientException .class, () -> {
            this.testRestTemplate.exchange("/personas/" + id, HttpMethod.DELETE, this.getDefaultRequestEntity(), Boolean.class)
        });

    }
}