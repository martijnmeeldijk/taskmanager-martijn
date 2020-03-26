package be.ucll.ip.demo3.service;

import be.ucll.ip.demo3.domain.Head;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeadServiceImpl implements HeadService {
	private List<Head> heads;
	public HeadServiceImpl(){
		this.heads = new ArrayList<>();
	}

	@Override
	public List<Head> getHeads() {
		return heads;
	}

	@Override
	public void addHead(Head head) {
		heads.add(head);
	}
}
