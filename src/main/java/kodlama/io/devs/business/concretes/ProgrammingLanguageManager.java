package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
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
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception{
		if(isIdExist(programmingLanguage.getId()) == true) {
			throw new Exception("Id "+ programmingLanguage.getId()+" already exist.");
		}else if(isNameExist(programmingLanguage) == true) {
			throw new Exception(programmingLanguage.getName()+" programming language already exist.");
		}else if(programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programming language cannot be empty");
		}
		programmingLanguageRepository.add(programmingLanguage);
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception{
		if(isIdExist(programmingLanguage.getId()) && !isNameExist(programmingLanguage)) {
			programmingLanguageRepository.update(programmingLanguage);
		}else {
			throw new Exception("The programming you want to update was not found");
		}	
	}


	@Override
	public void delete(int id) throws Exception{
		if(isIdExist(id)) {
			programmingLanguageRepository.delete(id);
		}else {
			throw new Exception("The programming you want to delete was not found");
		}
	}
	
	public boolean isIdExist(int id) {
		for(ProgrammingLanguage programmingLanguages: programmingLanguageRepository.getAll()) {
			if(programmingLanguages.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
		for(ProgrammingLanguage programmingLanguages: programmingLanguageRepository.getAll()) {
			if(programmingLanguages.getId() == programmingLanguage.getId() && programmingLanguages.getName().equalsIgnoreCase(programmingLanguage.getName())) {
				return true;
			}
		}
		return false;
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}
	
}
