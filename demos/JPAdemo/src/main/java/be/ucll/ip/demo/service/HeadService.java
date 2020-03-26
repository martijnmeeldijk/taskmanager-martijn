package be.ucll.ip.demo.service;


import be.ucll.ip.demo.domain.Head;
import be.ucll.ip.demo.dto.HeadDTO;

import java.util.List;

public interface HeadService {
	List<HeadDTO> getHeads();

	void addHead(HeadDTO head);
}
