package be.ucll.ip.demo.model.service;

import be.ucll.ip.demo.model.dto.HeadDTO;
import be.ucll.ip.demo.model.entity.Head;
import be.ucll.ip.demo.model.repo.HeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeadServiceImpl implements HeadService {
	private final HeadRepository repository;

	@Autowired
	public HeadServiceImpl(HeadRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<HeadDTO> getHeads() {
		return repository.findAll().stream().map(this::convert).collect(Collectors.toList());
	}

	@Override
	public HeadDTO addHead(HeadDTO headDTO) {
		Head head = new Head();
		head.setOwner(headDTO.getOwner());
		head.setDecapitated(headDTO.isDecapitated());
		head.setDateAndTimeOfBeheading(headDTO.getDateAndTimeOfBeheading());
		head = repository.save(head);
		return convert(head);
	}

	private HeadDTO convert(Head head) {
		HeadDTO dto = new HeadDTO();
		dto.setId(head.getId());
		dto.setDateAndTimeOfBeheading(head.getDateAndTimeOfBeheading());
		dto.setDecapitated(head.isDecapitated());
		dto.setOwner(head.getOwner());
		return dto;
	}
}
