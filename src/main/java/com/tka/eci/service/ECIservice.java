package com.tka.eci.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.eci.dao.ECAdao;
import com.tka.eci.entity.Candidate;

public class ECIservice {
	
	ECAdao dao = null;
	
	public List<Candidate> allCandidate(){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		return allCandidate;
	}
	
	
	public List<Candidate> listByParty(String party){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		List<Candidate> listByParty = new ArrayList<>();
		
		for(Candidate can : allCandidate) {
			if(party.equalsIgnoreCase(can.getParty())) {
				listByParty.add(can);
			}
		}
		return listByParty;
	}
	
	public List<Candidate> listByAssembly(String assembly){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		List<Candidate> listByAssembly = new ArrayList<>();
		
		for(Candidate can : allCandidate) {
			if(assembly.equalsIgnoreCase(can.getAssembly())) {
				listByAssembly.add(can);
			}
		}
		return listByAssembly;
	}
	
	public List<Candidate> listByStateParty(String state,String party){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		List<Candidate> listByStateParty = new ArrayList<>();
		
		for(Candidate can : allCandidate) {
			if(state.equalsIgnoreCase(can.getState()) && party.equalsIgnoreCase(can.getParty())) {
				listByStateParty.add(can);
			}
		}
		return listByStateParty;
	}
	
	public List<Candidate> listByGender(String gender){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		List<Candidate> listByGender = new ArrayList<>();
		
		for(Candidate can : allCandidate) {
			if(gender.equalsIgnoreCase(can.getGender())) {
				listByGender.add(can);
			}
		}
		return listByGender;
	}
	
	public List<Candidate> listByAge(int age){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		List<Candidate> listByAge = new ArrayList<>();
		
		for(Candidate can : allCandidate) {
			if(can.getAge()>age) {
				listByAge.add(can);
			}
		}
		return listByAge;
	}
	
	public List<Candidate> listByStatus(String status){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		List<Candidate> listByStatus = new ArrayList<>();
		
		for(Candidate can : allCandidate) {
			if(status.equalsIgnoreCase(can.getStatus())) {
				listByStatus.add(can);
			}
		}
		return listByStatus;
	}
	
	public int countOfAcceptedCandidateByAssembly(String assembly){
		dao = new ECAdao();
		List<Candidate> allCandidate = dao.allCandidate();
		int acceptedCount = 0 ;
		for(Candidate can : allCandidate) {
			if(assembly.equalsIgnoreCase(can.getAssembly()) && can.getStatus().equalsIgnoreCase("Accepted")) {
				acceptedCount++;
			}
		}
		return acceptedCount;
	}
	
	public List<Candidate> insertCandidate() {
		dao = new ECAdao();
		List<Candidate> list = dao.insertCandidate();
		return list;
	}
	
	public List<Candidate>  deleteCandidate(int cid){
		dao = new ECAdao();
		List<Candidate> list = dao.deleteCandidate(cid);
		return list;
	}
	
	public List<Candidate>  updateCandidate(int cid){
		dao = new ECAdao();
		List<Candidate> list = dao.updateCandidate(cid);
		return list;
	}

	
	
	
	
	

}
