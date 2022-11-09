package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.devs.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import kodlama.io.devs.business.responses.subTechnology.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {
	List<GetAllSubTechnologiesResponse> getAll();
	GetByIdSubTechnologyResponse getById(int id);
	void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception;
	void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest); 
}
