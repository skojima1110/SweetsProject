package com.example.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.dto.SweetsData;
import com.example.sample.entity.Sweets;
import com.example.sample.entity.SweetsForm;
import com.example.sample.repository.SweetsRepository;

@Controller
public class SweetsController {

	@Autowired
	SweetsRepository repository;
	
	@RequestMapping("/showcase")
	public String showcase(Model model) {
		List<Sweets> list = repository.findAll();
		model.addAttribute("sweets", list);
		return "showcase";
	}
	
	@RequestMapping("/shop")
	public String shop(Model model) {
		List<Sweets> list = repository.findAll();
		// エンティティを画面データに詰めかえる
		List<SweetsData> sweetsList = new ArrayList<SweetsData>();
		for (Sweets sweets : list) {
			SweetsData data = new SweetsData();
			data.setId(sweets.getId());
			data.setItem(sweets.getItem());
			data.setKind(sweets.getKind());
			data.setStock(sweets.getStock());
			sweetsList.add(data);
		}
		SweetsForm sweetsForm = new SweetsForm();
		sweetsForm.setSweetsList(sweetsList);
		model.addAttribute("sweetsForm", sweetsForm);
		
		return "shop";
	}

	@PostMapping("/buy")
	public String buy(SweetsForm sweetsForm, Model model) {
		// お買い上げリスト
		List<Sweets> shoppingList = new ArrayList<Sweets>();
		// チェックのついた商品のみお買い上げ
		for (SweetsData sweets : sweetsForm.getSweetsList()) {
			if (sweets.isChecked()) {
				Sweets data = new Sweets();
				data.setId(sweets.getId());
				data.setItem(sweets.getItem());
				data.setKind(sweets.getKind());
				// 買われた商品の在庫数を減らす
				if (sweets.getStock() > 1) {
					data.setStock(sweets.getStock() - 1);
				} else {
					data.setStock(0);
				}
				shoppingList.add(data);
				
				// DB更新
				repository.save(data);
			}
		}
		model.addAttribute("sweets", shoppingList);
		return "thanks";
	}
}
