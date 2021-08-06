package integracion;

import co.com.plancrecimiento.Aplicacion;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Aplicacion.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "SCOPE_SUFFIX = integration_test" })
@AutoConfigureMockMvc
public abstract class ControllerTest{
    @Autowired
    protected TestRestTemplate testRestTemplate;

    protected <T> RequestEntity<T> getDefaultRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return new RequestEntity<>(headers, HttpMethod.GET, null);
    }

    protected HttpEntity getDefaultHttpEntityWithBody(Map map) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        return new HttpEntity<>(map, headers);
    }
}

