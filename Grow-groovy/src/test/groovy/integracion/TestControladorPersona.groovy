package integracion

import main.Application
import main.Dtos.PersonaDTO
import main.controladores.ControladorPersona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
class TestControladorPersona extends Specification {

    RestTemplate template = new TestRestTemplate();


    @Autowired
    private ControladorPersona controladorPersona

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        setup:
        def a = template.getForEntity("http://localhost:8080", String.class)

        expect:
        println a
    }
}
