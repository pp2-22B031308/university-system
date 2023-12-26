package course;

import java.io.Serializable;

public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;
    private double preFinalMark;
    private double numericGrade;
    private String grade;
    final static String[] marks = {"F", "F", "F", "F", "F", "F", "F", "F", "F", "F", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};

    public Mark() {
        this.firstAttestation = 0;
        this.secondAttestation = 0;
        this.preFinalMark = 0;
        this.grade = null;
        this.numericGrade = 0;
    }

    public Mark(double firstAttestation, double secondAttestation, double preFinalMark) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.preFinalMark = preFinalMark;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Mark other = (Mark) obj;

        if (firstAttestation != other.firstAttestation)
            return false;
        if (secondAttestation != other.secondAttestation)
            return false;
        if (finalExam != other.finalExam)
            return false;

        return true;
    }

    public Mark clone() throws CloneNotSupportedException {
        Mark cloned = (Mark) super.clone();
        return cloned;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getPreFinalMark() {
        if (preFinalMark < 60) return preFinalMark;
        return 60;
    }

    public void setPreFinalMark() {
        preFinalMark = this.firstAttestation + this.secondAttestation;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(double numericGrade) {
        this.numericGrade = numericGrade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade() {
        this.grade = marks[(int) (Math.round((this.numericGrade) / 5))];
    }
}
