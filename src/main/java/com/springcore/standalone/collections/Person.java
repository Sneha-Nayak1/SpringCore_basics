package com.springcore.standalone.collections;

import java.util.List;
import java.util.Map;

public class Person {
	
	private String name;
	private List<String> bestfriends;
	private Map<String, Double> feestructure;
	
	public Map<String, Double> getFeestructure() {
		return feestructure;
	}
	public void setFeestructure(Map<String, Double> feestructure) {
		this.feestructure = feestructure;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getBestfriends() {
		return bestfriends;
	}
	public void setBestfriends(List<String> bestfriends) {
		this.bestfriends = bestfriends;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", bestfriends=" + bestfriends + ", feestructure=" + feestructure + "]";
	}
	
	

}
