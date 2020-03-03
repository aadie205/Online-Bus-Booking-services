package com.vk.servlet;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BusBean implements Serializable {
        private int servNo, seats;
        private String servName,fStation,tStation,dTime,aTime;
        private float price;
        public BusBean() {}
		public int getServNo() {
			return servNo;
		}
		public void setServNo(int servNo) {
			this.servNo = servNo;
		}
		public int getSeats() {
			return seats;
		}
		public void setSeats(int seats) {
			this.seats = seats;
		}
		public String getServName() {
			return servName;
		}
		public void setServName(String servName) {
			this.servName = servName;
		}
		public String getfStation() {
			return fStation;
		}
		public void setfStation(String fStation) {
			this.fStation = fStation;
		}
		public String gettStation() {
			return tStation;
		}
		public void settStation(String tStation) {
			this.tStation = tStation;
		}
		public String getdTime() {
			return dTime;
		}
		public void setdTime(String dTime) {
			this.dTime = dTime;
		}
		public String getaTime() {
			return aTime;
		}
		public void setaTime(String aTime) {
			this.aTime = aTime;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
        
        
}
