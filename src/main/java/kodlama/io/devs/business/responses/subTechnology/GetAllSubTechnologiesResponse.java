package kodlama.io.devs.business.responses.subTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSubTechnologiesResponse {
	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}
