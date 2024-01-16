package com.example.sample.dto;

import com.example.sample.entity.Sweets;

public class SweetsData extends Sweets {

	private boolean checked;
	
	public boolean isChecked() {
		return checked;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
