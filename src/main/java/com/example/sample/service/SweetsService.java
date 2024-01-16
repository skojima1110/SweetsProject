package com.example.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.dto.SweetsData;
import com.example.sample.entity.Sweets;
import com.example.sample.entity.SweetsForm;
import com.example.sample.repository.SweetsRepository;

@Service
public class SweetsService {
	
	@Autowired
	SweetsRepository repository;	

	/**
	 * ショーケースに陳列する
	 * mydb.sweetsのデータ全件を返却
	 * @return List<Sweets>
	 */
	public List<Sweets> getShowcaseData() {
		return repository.findAll();
	}

	/**
	 * ショップで表示する
	 * mydb.sweetsのデータを全件取得し、
	 * ショップ用のFormに移し替えて返却
	 * @return SweetsForm
	 */
	public SweetsForm getShopData() {
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
		return sweetsForm;
	}

	/**
	 * 買い物情報の更新をして
	 * お買い上げ商品のリストを返却
	 * @return List<Sweets>
	 */
	public List<Sweets> updateBuy(SweetsForm sweetsForm) {
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
		return shoppingList;
	}

}
