package com.joeknowles.LanguageProject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joeknowles.LanguageProject.models.Language;
import com.joeknowles.LanguageProject.service.LanguageService;

@RestController
public class LanguageApi {
    private final LanguageService languageService;
    public LanguageApi(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @PostMapping("/api/languages")
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
        return languageService.createLanguage(new Language(name, creator, version));
    }
    
    @GetMapping("/api/books/{id}")
    public Language show(@PathVariable("id") Long id) {
        return languageService.findLanguage(id);
    }
    
    @PutMapping("/api/books/{id}")
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
    	Language l = new Language(name, creator, version);
    	languageService.updateLanguage(l);
    	return l;
    }
    
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
}

