package kodlama.io.devs.wepApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.SubTechnologyService;
import kodlama.io.devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.devs.business.responses.subTechnology.GetAllSubTechnologiesResponse;
import kodlama.io.devs.business.responses.subTechnology.GetByIdSubTechnologyResponse;

@RestController
@RequestMapping("api/subtechnologies")
public class SubTechnologiesController {
	private SubTechnologyService subTechnologyService;
	
	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll() {
		return subTechnologyService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdSubTechnologyResponse getById(int id) {
		return subTechnologyService.getById(id);
	}

	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}

	@PostMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}

	@PostMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) throws Exception {
		this.subTechnologyService.delete(deleteSubTechnologyRequest);
	}
}
