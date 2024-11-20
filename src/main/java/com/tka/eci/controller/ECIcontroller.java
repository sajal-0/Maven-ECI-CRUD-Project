package com.tka.eci.controller;

import java.util.List;

import com.tka.eci.entity.Candidate;
import com.tka.eci.service.ECIservice;

public class ECIcontroller {
	
	ECIservice service = null;
	
	public List<Candidate> allCandidate(){
		service = new ECIservice();
		List<Candidate> allCandidate = service.allCandidate();
		return allCandidate;
	}
	
	public List<Candidate> listByParty(String party){
		service = new ECIservice();
		List<Candidate> listByParty = service.listByParty(party);
		return listByParty;
	}
	
	public List<Candidate> listByAssembly(String assembly){
		service = new ECIservice();
		List<Candidate> listByAssembly = service.listByAssembly(assembly);
		return listByAssembly;
	}
	
	public List<Candidate> listByStateParty(String state,String party){
		service = new ECIservice();
		List<Candidate> listByStateParty = service.listByStateParty(state, party);
		return listByStateParty;
	}
	
	public List<Candidate> listByGender(String gender){
		service = new ECIservice();
		List<Candidate> listByGender = service.listByGender(gender);
		return listByGender;
	}
	
	public List<Candidate> listByAge(int age){
		service = new ECIservice();
		List<Candidate> listByAge = service.listByAge(age);
		return listByAge;
	}
	
	
	public List<Candidate> listByStatus(String status){
	service = new ECIservice();
	List<Candidate> listByStatus = service.listByStatus(status);
	return listByStatus;
	}
	
	public int countOfAcceptedCandidateByAssembly(String assembly){
		service = new ECIservice();
		int countOfAcceptedCandidateByAssembly = service.countOfAcceptedCandidateByAssembly(assembly);
		return countOfAcceptedCandidateByAssembly;
	}
	
	public List<Candidate> insertCandidate() {
		service = new ECIservice();
		List<Candidate> list = service.insertCandidate();
		return list;
	}
	
	public List<Candidate>  deleteCandidate(int cid){
		service = new ECIservice();
		List<Candidate> list = service.deleteCandidate(cid);
		return list;
	}
	
	public List<Candidate>   updateCandidate(int cid){
		service = new ECIservice();
		List<Candidate> list = service.updateCandidate(cid);
		return list;
	}
	
	
}
