package com.validation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.Dto.LoginDto;

@Controller
public class FormController {
	
	@GetMapping("/login")
	public String formPage() {
		return "Test";
	}
	
	@PostMapping("/form")
	public String saveDataFromPage(@Valid @ModelAttribute("LoginDto") LoginDto loginDto,BindingResult result,Model model) {
		if(result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("result", result);
			return "Test";
		}
	//7	System.out.println(loginDto.toString());
		
		model.addAttribute("loginDto", loginDto);
		return "Success"; 
	}
}
