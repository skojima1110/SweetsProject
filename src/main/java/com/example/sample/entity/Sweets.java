package com.example.sample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sweets")
public class Sweets {

		@Id
		@Column
		private String id;
		
		@Column
		private String item;
		
		@Column
		private String kind;
		
		@Column
		private int stock;

		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getItem() {
			return item;
		}
		
		public void setItem(String item) {
			this.item = item;
		}

		public String getKind() {
			return kind;
		}
		
		public void setKind(String kind) {
			this.kind = kind;
		}

		public int getStock() {
			return stock;
		}
		
		public void setStock(int stock) {
			this.stock = stock;
		}

}
