package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	public void add(ProgrammingLanguage programmingLanguage);
	public void update(ProgrammingLanguage programmingLanguage);
	public void delete(int id);
}
