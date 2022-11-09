package kodlama.io.devs.wepApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.programmingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdProgrammingLanguageResponse getById(int id) {
		return programmingLanguageService.getById(id);
	}
}
