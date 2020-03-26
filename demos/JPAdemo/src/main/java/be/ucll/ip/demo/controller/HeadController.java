package be.ucll.ip.demo.controller;

import be.ucll.ip.demo.dto.HeadDTO;
import be.ucll.ip.demo.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/head")
public class HeadController {
	@Autowired
	private HeadService service;

	@GetMapping
	public String getHeads(Model model) {
		model.addAttribute("heads", service.getHeads());
		return "heads";
	}

	@GetMapping("/create")
	public String getCreateForm(Model model) {
		model.addAttribute("headDTO", new HeadDTO());
		return "form";
	}

	@PostMapping
	public String postNewHead(@ModelAttribute @Valid HeadDTO head, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		service.addHead(head);
		return "redirect:/head";
	}
}
