package be.ucll.ip.demo.model.service;


import be.ucll.ip.demo.model.dto.HeadDTO;

import java.util.List;

public interface HeadService {
	List<HeadDTO> getHeads();

	HeadDTO addHead(HeadDTO head);
}
