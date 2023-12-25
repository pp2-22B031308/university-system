package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Course;
import model.Faculty;
import model.Mark;

public class MarkFactory {
	public static Mark createMark() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter result of 1st attestation:");
		double att1 = Double.parseDouble(br.readLine());
		System.out.println("Enter result of 2st attestation:");
		double att2 = Double.parseDouble(br.readLine());
		System.out.println("Enter result of Final:");
		double finExam = Double.parseDouble(br.readLine());
		return new Mark(att1, att2, finExam);
	}
	
	public static Course createCourse() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Id:");
		String id = br.readLine();
		System.out.println("Name:");
		String name = br.readLine();
		System.out.println("Description(full name)");
		String description = br.readLine();
		System.out.println("Course prerequisite:");
		String prId = br.readLine();
		String prName = br.readLine();
		String prDesc = br.readLine();
		int prNumOfCredit = Integer.parseInt(br.readLine());
		System.out.println("To which Faculty course belongs:");
		Faculty faculty = Faculty.convertToFac(Integer.parseInt(br.readLine()));
		System.out.println("Number of Credits:");
		int numOfCredit = Integer.parseInt(br.readLine());
		return new Course(id, name, description , new Course(prId, prName, prDesc, null, faculty, prNumOfCredit), faculty, numOfCredit);
	}
}
