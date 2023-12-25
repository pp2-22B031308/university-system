package service;

import users.*;
import additional.*;
import comporators.*;
import course.*;
import database.*;
import enums.*;
import exceptions.*;
import service.*;
import system.*;

public class MarkService {
//	public static double getPrefinalResult(double att1, double att2){
//		double prefMark = att1+att2;
//		if(att1+att2<60)return 60;
//		return prefMark;
//	}
	public static String printAttestation(Mark mark) {
		return "1st Attestation-"+mark.getFirstAttestation()+"\n2nd Attestation-"+mark.getSecondAttestation()
				+ "\nExam:"+" Numeric Grade-"+mark.getNumericGrade()+" Grade-"+mark.getGrade();
	}
	public static String printTranscaript(Mark mark) {
		return "1st Attestation-"+mark.getFirstAttestation()+"\n2nd Attestation-"+mark.getSecondAttestation()
				+ "\nExam:"+" Numeric Grade-"+mark.getNumericGrade()+" Grade-"+mark.getGrade();
	}
}
