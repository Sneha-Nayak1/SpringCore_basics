package com.springcore.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Value("#{ T(java.lang.Math).sqrt(144)}")
	private double sqrt;
	
	@Value("#{ T(java.lang.Math).PI}")
	private double pi;
	
	@Value("#{ 8-4>2}")
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public double getSqrt() {
		return sqrt;
	}
	public void setSqrt(double sqrt) {
		this.sqrt = sqrt;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	
	@Override
	public String toString() {
		return "Demo [sqrt=" + sqrt + ", pi=" + pi + ", isActive=" + isActive + "]";
	}
	
}
