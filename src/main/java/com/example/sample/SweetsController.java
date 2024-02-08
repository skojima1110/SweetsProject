package com.example.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.dto.SweetsData;
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

	//以下追加課題分

@RequestMapping("/shop2")
public String shop2(Model model) {
	model.addAttribute("sweetsForm", service.getShopData2());
	return "shop2";
}

@PostMapping("/buy2")
public String buy2(SweetsForm sweetsForm, Model model) {
	List<SweetsData> list = service.updateStock2(sweetsForm);
	model.addAttribute("sweets", list);
	return "thanks2";
//	if (list.size() > 0) {
//		model.addAttribute("sweets", list);
//		return "thanks2";
//	} else {
//		model.addAttribute("sweetsForm", sweetsForm);
//		model.addAttribute("msg", "商品を選んでください");
//		return "shop2";
//	}
}
//
//@Autowired
//BackyardService backyardService;
//
//@RequestMapping("/backyard")
//public String backyard(Model model) {
//	model.addAttribute("sweetsList", backyardService.getSweetsList());
//	BackyardForm form = new BackyardForm();
//	model.addAttribute("backyardForm", form);
//	return "backyard";
//}
//
//@PostMapping("/stock-add")
//public String stockAdd(BackyardForm form, Model model) {
//	model.addAttribute("msg1", backyardService.addStock(form.getId(), form.getAddStock()));
//
//	// 続けて更新ができるよう商品一覧とformを再送
//	model.addAttribute("sweetsList", backyardService.getSweetsList());
//	model.addAttribute("backyardForm", form);
//	
//	return "backyard";
//}
//
//@PostMapping("/item-insert")
//public String itemInsert(Sweets sweets, Model model) {
//	model.addAttribute("msg2", backyardService.insertItem(sweets));
//
//	// 続けて更新ができるよう商品一覧とformを再送
//	model.addAttribute("sweetsList", backyardService.getSweetsList());
//	BackyardForm form = new BackyardForm();
//	model.addAttribute("backyardForm", form);
//
//	return "backyard";
//}
//
//@PostMapping("/item-delete")
//public String itemDelete(String id, Model model) {
//	model.addAttribute("msg3", backyardService.deleatItem(id));
//
//	// 続けて更新ができるよう商品一覧とformを再送
//	model.addAttribute("sweetsList", backyardService.getSweetsList());
//	BackyardForm form = new BackyardForm();
//	model.addAttribute("backyardForm", form);
//
//	return "backyard";
//}

}
