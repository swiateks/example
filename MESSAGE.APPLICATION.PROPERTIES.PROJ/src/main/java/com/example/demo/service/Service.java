package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("service")
public class Service {
	           private int empno;
	           private String ename;
	           
	           @Autowired
	           private AnotherService office;
			public int getEmpno() {
				return empno;
			}
			public void setEmpno(int empno) {
				this.empno = empno;
			}
			public String getEname() {
				return ename;
			}
			public void setEname(String ename) {
				this.ename = ename;
			}
			public AnotherService getOffice() {
				return office;
			}
			public void setOffice(AnotherService office) {
				this.office = office;
			}
	           
	}

