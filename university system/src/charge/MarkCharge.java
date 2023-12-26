package charge;

import course.*;

public class MarkCharge {
	public static String printAttestation(Mark mark) {
		return "1st Attestation-"+mark.getFirstAttestation()+"\n2nd Attestation-"+mark.getSecondAttestation()
				+ "\nExam:"+" Numeric Grade-"+mark.getNumericGrade()+" Grade-"+mark.getGrade();
	}
	public static String printTranscaript(Mark mark) {
		return "1st Attestation-"+mark.getFirstAttestation()+"\n2nd Attestation-"+mark.getSecondAttestation()
				+ "\nExam:"+" Numeric Grade-"+mark.getNumericGrade()+" Grade-"+mark.getGrade();
	}
}
