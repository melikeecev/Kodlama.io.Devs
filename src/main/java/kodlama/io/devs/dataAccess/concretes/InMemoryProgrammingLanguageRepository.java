package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
		programmingLanguages.add(new ProgrammingLanguage(2, "Python"));
		programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
		programmingLanguages.add(new ProgrammingLanguage(4, "Dart"));
		programmingLanguages.add(new ProgrammingLanguage(5, "C++"));
		programmingLanguages.add(new ProgrammingLanguage(6, "SQL"));
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}


	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage language : programmingLanguages) {
			if (language.getId() == programmingLanguage.getId()) {
				programmingLanguages.set(language.getId() - 1, programmingLanguage);
			}
		}
	}


	@Override
	public void delete(int id) {
		programmingLanguages.removeIf(programmingLanguage -> programmingLanguage.getId() == id);	
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.get(id);
	}

}
