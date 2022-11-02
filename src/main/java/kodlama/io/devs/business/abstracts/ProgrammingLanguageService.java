package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	public void add(ProgrammingLanguage programmingLanguage) throws Exception;
	public void update(ProgrammingLanguage programmingLanguage) throws Exception;
	public void delete(int id) throws Exception;
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
}
