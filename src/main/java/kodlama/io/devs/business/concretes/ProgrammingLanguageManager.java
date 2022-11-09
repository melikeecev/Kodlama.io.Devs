package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}


	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguageResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			programmingLanguageResponse.add(responseItem);
		}
		return programmingLanguageResponse;
	}


	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(id).get();
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		getByIdProgrammingLanguageResponse.setName(programmingLanguage.getName());
		return getByIdProgrammingLanguageResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		if(isNameExist(createProgrammingLanguageRequest.getName()) == true) {
			throw new Exception("This programming language already exist.");
		}else if(createProgrammingLanguageRequest.getName().isBlank()) {
			throw new Exception("Programming language name cannot be empty.");
		}
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		this.programmingLanguageRepository.save(programmingLanguage);	
	}


	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		if(isIdExist(updateProgrammingLanguageRequest.getId()) == false) {
			throw new Exception("The programming language to be updated was not found.");
		}else if(isNameExist(updateProgrammingLanguageRequest.getName()) == true) {
			throw new Exception("This programming language already exist");
		}else if(updateProgrammingLanguageRequest.getName().isBlank()) {
			throw new Exception("Programming language name cannot be empty.");
		}
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository
				.findById(updateProgrammingLanguageRequest.getId()).get();
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);
	}


	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		if(isIdExist(deleteProgrammingLanguageRequest.getId()) == false) {
			throw new Exception("The programming language to be deleted was not found.");
		}
		this.programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
		
	}
	
	public boolean isIdExist(int id) {
		for(GetAllProgrammingLanguagesResponse programmingLanguagesResponse: getAll()) {
			if(programmingLanguagesResponse.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNameExist(String name) {
		for (ProgrammingLanguage programmingLanguage : programmingLanguageRepository.findAll()) {
			if (programmingLanguage.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
}
