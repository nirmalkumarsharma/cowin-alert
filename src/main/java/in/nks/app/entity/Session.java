package in.nks.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Session {
	@JsonProperty("session_id")
	private String sessionId;
	private String date;
	@JsonProperty("available_capacity")
	private Integer availableCapacity;
	@JsonProperty("min_age_limit")
	private Integer minAgeLimit;
	private String vaccine;
	private List<String> slots = new ArrayList<String>();
}