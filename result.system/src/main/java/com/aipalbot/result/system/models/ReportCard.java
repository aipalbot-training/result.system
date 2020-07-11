package com.aipalbot.result.system.models;

import com.aipalbot.result.system.util.GradingScale;

public class ReportCard {

	private double gpa;
	private GradingScale overAllGrading;
	
	public GradingScale getOverAllGrading() {
		return overAllGrading;
	}
	public void setOverAllGrading(GradingScale overAllGrading) {
		this.overAllGrading = overAllGrading;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
