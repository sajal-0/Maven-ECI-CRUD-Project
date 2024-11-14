package com.tka.eci.client;

import java.util.List;
import java.util.Scanner;

import com.tka.eci.controller.ECIcontroller;
import com.tka.eci.entity.Candidate;

public class ECIclient {
	public static void main(String[] args) throws Exception {
		
		
		ECIcontroller con = new ECIcontroller();
		Scanner sc = null;
		
		List<Candidate> allCandidate = con.allCandidate();
//		System.out.println(allCandidate);
		
		List<Candidate> listByParty = con.listByParty("BJP");
//		System.out.println(listByParty);
		
		List<Candidate> listByAssembly = con.listByAssembly("Katol");
//		System.out.println(listByAssembly);
		
		List<Candidate> listByStateParty = con.listByStateParty("MH", "NCP");
//		System.out.println(listByStateParty);
		
		List<Candidate> listByGender = con.listByGender("Female");
//		System.out.println(listByGender);
		
		List<Candidate> listByAge = con.listByAge(82);
//		System.out.println(listByAge);
		
		List<Candidate> listByStatus = con.listByStatus("Rejected");
//		System.out.println(listByStatus);
		
		
//		sc = new Scanner(System.in);
//		String assem = sc.nextLine();
//		int countOfAcceptedCandidateByAssembly = con.countOfAcceptedCandidateByAssembly(assem);
//		System.out.println(countOfAcceptedCandidateByAssembly);
		
//		List<Candidate> list = con.insertCandidate();
//		System.out.println(list);
		
//		List<Candidate> list2 = con.deleteCandidate(98);
//		System.out.println(list2);
		
		List<Candidate> list3 = con.updateCandidate(99);
		System.out.println(list3);
		
		
	}

}
