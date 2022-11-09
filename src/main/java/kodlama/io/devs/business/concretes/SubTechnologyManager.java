package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.SubTechnologyService;
import kodlama.io.devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.devs.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import kodlama.io.devs.business.responses.subTechnology.GetByIdSubTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	private SubTechnologyRepository subTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	
	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologiesResponse> subTechnologiesResponse = new ArrayList<GetAllSubTechnologiesResponse>();

		for (SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologiesResponse responseItem = new GetAllSubTechnologiesResponse();
			responseItem.setId(subTechnology.getId());
			responseItem.setName(subTechnology.getName());
			responseItem.setProgrammingLanguageId(subTechnology.getProgrammingLanguage().getId());
			responseItem.setProgrammingLanguageName(subTechnology.getProgrammingLanguage().getName());
			subTechnologiesResponse.add(responseItem);
		}

		return subTechnologiesResponse;
	}
	
	@Override
	public GetByIdSubTechnologyResponse getById(int id) {
		Optional<SubTechnology> subTechnology = subTechnologyRepository.findById(id);
		GetByIdSubTechnologyResponse responseItem = new GetByIdSubTechnologyResponse();
		responseItem.setName(subTechnology.get().getName());
		return null;
	}
	
	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		if(isNameExist(createSubTechnologyRequest.getName()) == true) {
			throw new Exception("This technology already exist.");
		}else if(createSubTechnologyRequest.getName().isBlank()) {
			throw new Exception("Sub-technology name cannot be empty.");
		}
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createSubTechnologyRequest.getProgrammingLanguageId()).get();
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setName(createSubTechnologyRequest.getName());
		subTechnology.setProgrammingLanguage(programmingLanguage);
		subTechnologyRepository.save(subTechnology);
		
	}
	
	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		if(isNameExist(updateSubTechnologyRequest.getName()) == true) {
			throw new Exception("This technology already exist");
		}else if(updateSubTechnologyRequest.getName().isBlank()) {
			throw new Exception("Sub-technology name cannot be empty.");
		}
		SubTechnology subTechnology = subTechnologyRepository.findById(updateSubTechnologyRequest.getId()).get();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateSubTechnologyRequest.getProgrammingLanguageId()).get();
		subTechnology.setName(updateSubTechnologyRequest.getName());
		subTechnology.setProgrammingLanguage(programmingLanguage);
		subTechnologyRepository.save(subTechnology);
	}
	
	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyRepository.deleteById(deleteSubTechnologyRequest.getId());	
	}
	
	public boolean isIdExist(int id) {
		for(GetAllSubTechnologiesResponse subTechnologiesResponse: getAll()) {
			if(subTechnologiesResponse.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNameExist(String name) {
		for (SubTechnology subTechnology : subTechnologyRepository.findAll()) {
			if (subTechnology.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	
}
