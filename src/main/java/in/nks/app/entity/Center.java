package in.nks.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Center {
	@JsonProperty("center_id")
    private Integer centerId;
    private String name;
    private String address;
    @JsonProperty("state_name")
    private String stateName;
    @JsonProperty("district_name")
    private String districtName;
    @JsonProperty("block_name")
    private String blockName;
    private Integer pincode;
    private Integer lat;
    @JsonProperty("long")
    private Integer _long;
    private String from;
    private String to;
    @JsonProperty("fee_type")
    private String feeType;
    private List<Session> sessions;
}