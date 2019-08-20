package com.joeknowles.LanguageProject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.joeknowles.LanguageProject.models.Language;
import com.joeknowles.LanguageProject.service.LanguageService;


@Controller
public class LanguageController {
    private final LanguageService service;
    
    public LanguageController(LanguageService service) {
    	this.service = service;
    }
    
	@GetMapping("/languages")
	public String lang_index(Model model, @ModelAttribute("language") Language language) {
		List<Language> l = service.allLanguages();
		model.addAttribute("languages", l);
		return "/languages/index.jsp";
	}
	
	@PostMapping("/languages")
    public String lCreate(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/index.jsp";
        } else {
        	service.createLanguage(language);
            return "redirect:/languages";
        }
    }
	
    @GetMapping("/languages/{lang_id}")
    public String lShow(Model model, @PathVariable("lang_id") Long lang_id) {
    	model.addAttribute("language", service.findLanguage(lang_id));
    	return "/languages/show.jsp";
    }
    
    @GetMapping("/languages/{lang_id}/edit")
    public String edit(@PathVariable("lang_id") Long lang_id, Model model) {
        model.addAttribute("language", service.findLanguage(lang_id));
        return "/books/edit.jsp";
    }
    
    @PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
        	service.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("lang_id") Long lang_id) {
    	service.deleteLanguage(lang_id);
        return "redirect:/languages";
    }
}















