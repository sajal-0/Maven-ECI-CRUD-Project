package com.tka.eci.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tka.eci.entity.Candidate;
import com.tka.eci.utility.Utility;

public class ECAdao {

	 List<Candidate> list = null;
	    Session session = null;
	    Transaction t = null;
	    Scanner sc = new Scanner(System.in);
	

	public List<Candidate> allCandidate() {
	   
		list = new ArrayList<>();
		
	    try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Candidate.class).buildSessionFactory()) {
	        
	    	session = sessionFactory.openSession();
	        t = session.beginTransaction();
	        
	        Query query = session.createQuery("from Candidate"); 
	        list = query.list();
	        
	        t.commit();
	    } catch (Exception e) {
	        if (t != null) {
	            t.rollback(); 
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close(); 
	        }
	    }
	    
	    return list;
	}





	public List<Candidate> insertCandidate() {
	   list = new ArrayList<>();
	   sc = new Scanner(System.in);
	   

	    try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Candidate.class).buildSessionFactory()) {
	    	
	    	 Session session = sessionFactory.openSession();

	        System.out.println("Enter candidate details:");

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Party: ");
	        String party = sc.nextLine();

	        System.out.print("Enter State: ");
	        String state = sc.nextLine();

	        System.out.print("Enter Assembly: ");
	        String assembly = sc.nextLine();

	        System.out.print("Enter Assembly No: ");
	        int assemblyNo = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Status (Accepted/Rejected/Withdrawn): ");
	        String status = sc.nextLine();

	        System.out.print("Enter Gender (Male/Female): ");
	        String gender = sc.nextLine();

	        System.out.print("Enter Age: ");
	        int age = sc.nextInt();

	        Candidate candidate = new Candidate();
	        candidate.setName(name);
	        candidate.setParty(party);
	        candidate.setState(state);
	        candidate.setAssembly(assembly);
	        candidate.setAssembly_no(assemblyNo);
	        candidate.setStatus(status);
	        candidate.setGender(gender);
	        candidate.setAge(age);

	      
	        t = session.beginTransaction();
	        session.save(candidate);
	        list.add(candidate);

	        t.commit();
	        System.out.println("Candidate inserted successfully!");

	    } catch (Exception e) {
	        if (t != null) {
	            t.rollback(); 
	        }
	        e.printStackTrace();
	    }

	    return list;
	}

	
	
	public List<Candidate> deleteCandidate(int candidateId) {
	    list = new ArrayList<>();
	    
	    try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Candidate.class).buildSessionFactory()) {
	    	 
	    	Session session = sessionFactory.openSession();
	    	t = session.beginTransaction();
	        Candidate candidate = session.get(Candidate.class, candidateId);
	        
	       
	        if (candidate != null) {
	            session.delete(candidate);
	            System.out.println("Candidate deleted successfully!");
	        } else {
	            System.out.println("Candidate with ID " + candidateId + " not found.");
	        }

	        t.commit();

	        // Fetch updated list of all candidates
	        list = session.createQuery("from Candidate", Candidate.class).getResultList();

	    } catch (Exception e) {
	        if (t != null) {
	            t.rollback();
	        }
	        e.printStackTrace();
	    }

	    return list;
	}

	
	public List<Candidate> updateCandidate(int cid) {
	    list = new ArrayList<>();
	    sc = new Scanner(System.in);
	    try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Candidate.class).buildSessionFactory()) {
	    	
	    	Session session = sessionFactory.openSession();
	    	t = session.beginTransaction();
	    	Candidate candidate = session.get(Candidate.class, cid);
	    	
	        if (candidate != null) {

	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();
	            candidate.setName(name);

	            System.out.print("Enter Party: ");
	            String party = sc.nextLine();
	            candidate.setParty(party);

	            System.out.print("Enter State: ");
	            String state = sc.nextLine();
	            candidate.setState(state);

	            System.out.print("Enter Assembly: ");
	            String assembly = sc.nextLine();
	            candidate.setAssembly(assembly);

	            session.update(candidate);
	            t.commit();
	            System.out.println("Candidate updated successfully!");
	        } else {
	            System.out.println("Candidate with ID " + cid + " not found.");
	        }

	        list = session.createQuery("from Candidate", Candidate.class).getResultList();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


}
