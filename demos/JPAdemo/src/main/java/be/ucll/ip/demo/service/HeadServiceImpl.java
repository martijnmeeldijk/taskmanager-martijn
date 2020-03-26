package be.ucll.ip.demo.service;

import be.ucll.ip.demo.domain.Head;
import be.ucll.ip.demo.dto.HeadDTO;
import be.ucll.ip.demo.repo.HeadRepository;
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
		return repository.findAll().stream().map(h -> {
			HeadDTO dto = new HeadDTO();
			dto.setDateAndTimeOfBeheading(h.getDateAndTimeOfBeheading());
			dto.setDecapitated(h.isDecapitated());
			dto.setOwner(h.getOwner());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void addHead(HeadDTO headDTO) {
		Head head = new Head();
		head.setOwner(headDTO.getOwner());
		head.setDecapitated(headDTO.isDecapitated());
		head.setDateAndTimeOfBeheading(headDTO.getDateAndTimeOfBeheading());
		repository.save(head);
	}
}
