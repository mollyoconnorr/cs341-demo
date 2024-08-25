package edu.carroll.cs341;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexTest() throws Exception {
        String expectedName = "Spring Boot"; // This should match the value of the 'name' variable set in the controller

        // Send request to "/"
        mockMvc.perform(get("/?name=" + expectedName)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + expectedName + "!")));

        // Test default behavior (no name parameter provided)
        mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Student!")));
    }
}
