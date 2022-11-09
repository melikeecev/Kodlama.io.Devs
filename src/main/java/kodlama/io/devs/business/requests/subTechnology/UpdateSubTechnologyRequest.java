package kodlama.io.devs.business.requests.subTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubTechnologyRequest {
	private int id;
	private String name;
	private int programmingLanguageId;
}
