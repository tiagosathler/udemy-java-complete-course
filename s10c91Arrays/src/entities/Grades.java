package entities;

public class Grades extends Person {
	private double[] grades;
	private int index = 0; 
	
	public Grades(String name, int length) {
		super(name);
		this.grades = new double[length];
	}
	
	public void addGrade(double value) {
		if (index < grades.length) {
			this.grades[index] = value;
			index += 1;			
		}
	}
	
	public double[] getGrades() {
		return grades;
	}	 
}
