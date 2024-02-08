package com.example.sample.dto;

import com.example.sample.entity.Sweets;

public class SweetsData extends Sweets {

	private boolean checked;
	private int purchases;
	
	public boolean isChecked() {
		return checked;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public int getPurchases() {
		return purchases;
	}
	
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
}
