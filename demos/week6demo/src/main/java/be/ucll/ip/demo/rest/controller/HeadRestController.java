package be.ucll.ip.demo.rest.controller;

import be.ucll.ip.demo.model.dto.HeadDTO;
import be.ucll.ip.demo.model.service.HeadService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HeadRestController {
	private final HeadService headService;

	public HeadRestController(HeadService headService) {
		this.headService = headService;
	}

	@GetMapping("/head")
	@ResponseBody
	public List<HeadDTO> getHeads() {
		return headService.getHeads();
	}

	@PostMapping("/head")
	public HeadDTO createNewHead(@RequestBody @Valid HeadDTO headDTO){
		return headService.addHead(headDTO);
	}
}
