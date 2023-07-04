package lt.codeacademy.javau5.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
public class HomeControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetDaiktasEndpoint() throws Exception {		
		mockMvc.perform(get("/daiktas"))
			.andExpect( status().isOk() )
			.andExpect( jsonPath("$.id").value(1L));		
	}
	
	
	
}
