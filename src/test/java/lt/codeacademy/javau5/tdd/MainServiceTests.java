package lt.codeacademy.javau5.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@SpringBootTest
public class MainServiceTests {
	
	@Mock
	private DaiktasRepository repoMock; 
	
	@InjectMocks
	MainService mainService;
	
	@Test
	void shouldCheckForNullReferenceMainService() {				
		assertNotNull(mainService);		
	}
	
	@Test
	void shouldReturnNotNullObject() {
		
		Daiktas daiktas = mainService.getDaiktas();		
		assertNotNull(daiktas);
	}
	
	@Test 
	void shouldAddDaiktasToRepo() {
		// Arrange
		Long expectedId = 1L;
	    Daiktas daiktas = new Daiktas();
	    when(repoMock.save(Mockito.any(Daiktas.class)))
	    .thenAnswer( e -> {
	        Daiktas savedDaiktas = e.getArgument(0);
	        savedDaiktas.setId(1L);
	        return savedDaiktas;
	    });
		
		
		//Act
		Daiktas savedItem = mainService.saveDaiktas(daiktas);
		
		//Assert
		assertNotNull(savedItem);
		assertEquals( expectedId, savedItem.getId());
	}
	
	@Test
	void shouldFindDaiktasById() {
		//Arrange
		Long id = 1L;
		Long expectedId = 1L;
		Daiktas daiktas = new Daiktas();
		daiktas.setId(1L);
		
		when(repoMock.findById(id))
		.thenReturn( Optional.of(daiktas) );
		
		//Act
		Daiktas expectedItem = mainService.getById(id);
		
		//Assert
		assertNotNull(expectedItem);
		assertEquals(expectedId, expectedItem.getId());
	}
}
