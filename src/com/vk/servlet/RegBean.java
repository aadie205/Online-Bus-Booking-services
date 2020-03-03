package com.vk.servlet;

import java.io.Serializable;

public class RegBean implements Serializable {
          private String uName,pWd,fName,lName,addr,mId;
          private long phNo;
          public RegBean() {}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public String getpWd() {
			return pWd;
		}
		public void setpWd(String pWd) {
			this.pWd = pWd;
		}
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getmId() {
			return mId;
		}
		public void setmId(String mId) {
			this.mId = mId;
		}
		public long getPhNo() {
			return phNo;
		}
		public void setPhNo(long phNo) {
			this.phNo = phNo;
		}
          
          
}
