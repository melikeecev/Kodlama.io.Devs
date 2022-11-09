package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	void delete(DeleteProgrammingLanguageRequest deleteLanguageRequest) throws Exception;
}
