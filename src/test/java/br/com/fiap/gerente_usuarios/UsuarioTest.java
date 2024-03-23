package br.com.fiap.gerente_usuarios;

import br.com.fiap.gerente_usuarios.model.UserRole;
import br.com.fiap.gerente_usuarios.model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsuarioTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void teste_Cadastrando_Usuario_Sucesso() throws JsonProcessingException {

        String randomWord = geraPalavraRandomica();
        String url = "http://localhost:" + port + "/auth/register";

        Usuario usuario = new Usuario(randomWord, "1234", UserRole.ADMIN);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void teste_Login_Usuario_Sucesso() throws JsonProcessingException {

        String randomWord = geraPalavraRandomica();
        String url = "http://localhost:" + port + "/auth/register";

        Usuario usuario = new Usuario(randomWord, "1234", UserRole.ADMIN);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        url = "http://localhost:" + port + "/auth/login";

        Usuario userLogin = new Usuario();
        userLogin.setLogin(randomWord);
        userLogin.setPassword("1234");

       requestBody = objectMapper.writeValueAsString(userLogin);

        requestEntity = new HttpEntity<>(requestBody, headers);
        response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        try {
            ObjectMapper objectMapperResp = new ObjectMapper();
            JsonNode jsonNode = objectMapperResp.readTree(response.getBody());

            String mensagem = jsonNode.get("token").asText();

            Assert.assertNotNull(mensagem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void usuario_existe_Sucesso_Test() throws JsonProcessingException {

        String randomWord = geraPalavraRandomica();
        String url = "http://localhost:" + port + "/auth/register";

        Usuario usuario = new Usuario(randomWord, "1234", UserRole.ADMIN);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(usuario);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        url = "http://localhost:" + port + "/users/" + randomWord;
        requestEntity = new HttpEntity<>(headers);
        response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void usuario_existe_Falha_Test() {

        String url = "http://localhost:" + port + "/users/naoexiste";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    private static String geraPalavraRandomica() {
        int length = 8;
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            word.append(randomChar);
        }
        return word.toString();
    }

}
