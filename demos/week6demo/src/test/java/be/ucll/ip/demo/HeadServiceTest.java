package be.ucll.ip.demo;

import be.ucll.ip.demo.model.dto.HeadDTO;
import be.ucll.ip.demo.model.service.HeadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HeadServiceTest {
	@Autowired
	private HeadService headService;

	@Test
	public void testGetHeads() {
		// setup
		HeadDTO headDTO = new HeadDTO();
		headDTO.setOwner("Wim");
		headDTO.setDecapitated(false);
		headDTO.setDateAndTimeOfBeheading(LocalDateTime.of(2020, 03, 10, 10, 0));
		headService.addHead(headDTO);

		// method to be tested
		List<HeadDTO> heads = headService.getHeads();

		// checks
		assertNotNull(heads);
		assertFalse(heads.isEmpty());
		assertEquals(1, heads.size());
		HeadDTO head = heads.get(0);
		assertNotNull(head);
	}
}
