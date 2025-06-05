package com.springcore.sterotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Company {
	@Value("VCTI")
	private String name;
	
	@Value("Bangalore")
	private String address;
	
	@Value("#{branch1}")
	private List<String> branch;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getBranch() {
		return branch;
	}
	public void setBranch(List<String> branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", branch=" + branch + "]";
	}
	
	

}
