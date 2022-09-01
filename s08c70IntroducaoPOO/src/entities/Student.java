package entities;

public class Student {
	public String name;
	public double firstGrade;
	public double secondGrade;
	public double thirdGrade;
	private static final double CRITERIA = 60;

	public double getFinalGrade() {
		return firstGrade + secondGrade + thirdGrade;
	}

	public boolean isItApproved() {
		return getFinalGrade() > CRITERIA;
	}

	public double needToApprove() {
		if (isItApproved()) {
			return 0;
		}
		return CRITERIA - getFinalGrade();
	}
}
