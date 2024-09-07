package me.ksi.demotestdeploy.integrations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllUsers() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect( status().isOk())
                .andExpect( jsonPath( "$.length()").value(4))
                .andExpect(
                        jsonPath( "$.[0].name").value("Jordane")
                );

    }

    @Test
        public void createUser() throws Exception {
        String userJson = "{"
                + "\"name\":\"Saint\","
                + "\"adresse\":\"Saint@gmail.com\","
                + "\"password\":\"password\""
                + "}";

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Saint"))
                .andExpect(jsonPath("$.adresse").value("Saint@gmail.com"))
                .andExpect(jsonPath("$.password").value("password"));
        }

}
