package be.ucll.ip.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Head {
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(min = 3)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
