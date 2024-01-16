package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.entity.SweetsForm;
import com.example.sample.service.SweetsService;

//test

@Controller
public class SweetsController {

	@Autowired
	private SweetsService service;
	
	@RequestMapping("/showcase")
	public String showcase(Model model) {
		model.addAttribute("sweets", service.getShowcaseData());
		return "showcase";
	}

	@RequestMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("sweetsForm", service.getShopData());
		return "shop";
	}

	@PostMapping("/buy")
	public String buy(SweetsForm sweetsForm, Model model) {
		model.addAttribute("sweets", service.updateBuy(sweetsForm));
		return "thanks";
	}
}
