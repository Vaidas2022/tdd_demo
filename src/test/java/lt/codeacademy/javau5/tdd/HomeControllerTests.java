package lt.codeacademy.javau5.tdd;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HomeController.class)
public class HomeControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MainService mainService;
	
	@Test
	public void testGetDaiktasEndpoint() throws Exception {		
		mockMvc.perform(get("/daiktas"))
			.andExpect( status().isOk() )
			.andExpect( jsonPath("$.id").value(1L));		
	}
	
	@Test
    public void testGetDaitaiEnpoint() throws Exception{
        // Mock the data returned by toyRepository.findAll()
        Daiktas d1 = new Daiktas(1L, "A");
        Daiktas d2 = new Daiktas(2L, "B");
        Daiktas d3 = new Daiktas(3L, "C"); 
        List<Daiktas> daiktai = Arrays.asList(d1, d2, d3);
        when(mainService.getAll()).thenReturn(daiktai);
        // Perform the GET request and validate the response
        mockMvc.perform(MockMvcRequestBuilders.get("/api/daiktai")).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("A"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("B"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
        .andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value("C"));
    }
	
	
	
}
