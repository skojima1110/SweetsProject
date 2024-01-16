package com.example.sample.entity;

import java.util.List;

import com.example.sample.dto.SweetsData;

public class SweetsForm {

	private List<SweetsData> sweetsList;
	
	public void setSweetsList(List<SweetsData> sweetsList) {
		this.sweetsList = sweetsList;
	}
	
	public List<SweetsData> getSweetsList() {
		return sweetsList;
	}
}
