package com.grow.main.funcionales

import com.grow.main.Dtos.Persona
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.*



import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class ControladorPersonaTest extends ControllerTest{



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
        HttpStatus.OK == responseEntity.getStatusCode()
    }

}
