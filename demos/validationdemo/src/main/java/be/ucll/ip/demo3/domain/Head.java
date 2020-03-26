package be.ucll.ip.demo3.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Head {
	@NotEmpty
	@Size(min=3)
	private String owner;
	private boolean decapitated;

//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dateAndTimeOfBeheading;

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
