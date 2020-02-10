package lab05;

public class StudentRecord {
    private String id;
    private double midterm;
    private double assignment;
    private double finalexam;
    private double finalmark;
    private String grade;

    public StudentRecord(String id, double midterm, double assignment, double finalexam){
        this.id = id;
        this.midterm = midterm;
        this.assignment = assignment;
        this.finalexam = finalexam;

        calculateFinal();
    }

    private void calculateFinal(){
        finalmark = (0.2 * assignment) + (0.3 * midterm) + (0.5 * finalexam);

        if(finalmark >= 80){
            grade = "A";
        }
        else if(finalmark >=70){
            grade = "B";
        }
        else if(finalmark >=60){
            grade = "C";
        }
        else if(finalmark >= 50){
            grade = "D";
        }
        else{
            grade = "F";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public double getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(double finalexam) {
        this.finalexam = finalexam;
    }

    public double getFinalmark() {
        return finalmark;
    }

    public void setFinalmark(double finalmark) {
        this.finalmark = finalmark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
