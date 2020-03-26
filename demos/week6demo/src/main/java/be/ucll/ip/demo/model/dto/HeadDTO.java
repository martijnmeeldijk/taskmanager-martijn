package be.ucll.ip.demo.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class HeadDTO {
	private Long id;
	@NotEmpty
	@Size(min = 3)
	private String owner;
	private boolean decapitated;
	private LocalDateTime dateAndTimeOfBeheading;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isDecapitated() {
		return decapitated;
	}

	public void setDecapitated(boolean decapitated) {
		this.decapitated = decapitated;
	}

	public LocalDateTime getDateAndTimeOfBeheading() {
		return dateAndTimeOfBeheading;
	}

	public void setDateAndTimeOfBeheading(LocalDateTime dateAndTimeOfBeheading) {
		this.dateAndTimeOfBeheading = dateAndTimeOfBeheading;
	}
}
