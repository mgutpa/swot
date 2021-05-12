package com.goptri.pojo;

import java.util.Arrays;

public class JavaCandidate {
	
	private String fullName;
	private float totalExperience;
	private float currentSalaryInLakh;
	private String[] skillSets;
	
	public JavaCandidate(String fullName, float totalExperience, float currentSalaryInLakh, String[] skillSets) {
		super();
		this.fullName = fullName;
		this.totalExperience = totalExperience;
		this.currentSalaryInLakh = currentSalaryInLakh;
		this.skillSets = skillSets;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public float getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public float getCurrentSalaryInLakh() {
		return currentSalaryInLakh;
	}

	public void setCurrentSalaryInLakh(float currentSalaryInLakh) {
		this.currentSalaryInLakh = currentSalaryInLakh;
	}

	public String[] getSkillSets() {
		return skillSets;
	}

	public void setSkillSets(String[] skillSets) {
		this.skillSets = skillSets;
	}

	@Override
	public String toString() {
		return "JavaCandidate [fullName=" + fullName + ", totalExperience=" + totalExperience + ", currentSalaryInLakh="
				+ currentSalaryInLakh + ", skillSets=" + Arrays.toString(skillSets) + "]";
	}	
	
}
