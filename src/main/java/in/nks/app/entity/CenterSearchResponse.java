package in.nks.app.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CenterSearchResponse {
	private List<Center> centers = new ArrayList<Center>();
}