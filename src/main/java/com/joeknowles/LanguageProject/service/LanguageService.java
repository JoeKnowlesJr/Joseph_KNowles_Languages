package com.joeknowles.LanguageProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.LanguageProject.models.Language;
import com.joeknowles.LanguageProject.repository.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository lRepo;
    
    public LanguageService(LanguageRepository lRepo) {
        this.lRepo = lRepo;
    }
    
    // returns all the languages
    public List<Language> allLanguages() { return lRepo.findAll(); }
    // creates a language
    public Language createLanguage(Language b) { return lRepo.save(b); }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = lRepo.findById(id);
        return optionalLanguage.orElse(null);
    }
    public void updateLanguage(Language language) {
    	Optional<Language> ol = lRepo.findById(language.getId());
    	if (ol.isPresent()) {
    		Language l = ol.get();
    		l.setName(language.getName());
    		l.setCreator(language.getCreator());
    		l.setVersion(language.getVersion());
    		lRepo.save(l);
    	}
    }
    // deletes a language
    public void deleteLanguage(Long id) {
        Optional<Language> optionalBook = lRepo.findById(id);
        if(optionalBook.isPresent()) {
        	lRepo.delete(optionalBook.get());
        } 
    }
}

