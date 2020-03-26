package be.ucll.ip.demo3.service;

import be.ucll.ip.demo3.domain.Head;

import java.util.List;

public interface HeadService {
	List<Head> getHeads();

	void addHead(Head head);
}
