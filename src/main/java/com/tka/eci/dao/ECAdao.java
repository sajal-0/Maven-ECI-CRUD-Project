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

import com.tka.eci.entity.Candidate;
import com.tka.eci.utility.Utility;

public class ECAdao {

	List<Candidate> allCandidate = null;
	Scanner sc = null;

	String sql = "SELECT * FROM advjava193.candidate";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public List<Candidate> allCandidate() {

		try {
			conn = Utility.support();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			allCandidate = new ArrayList<>();

			while (rs.next()) {
				int cid = rs.getInt("cid");
				String name = rs.getString("name");
				String party = rs.getString("party");
				String state = rs.getString("state");
				String assembly = rs.getString("assembly");
				int assem_no = rs.getInt("assembly_no");
				String status = rs.getString("status");
				String gen = rs.getString("gender");
				int age = rs.getInt("age");

				Candidate obj = new Candidate(cid, name, party, state, assembly, assem_no, status, gen, age);
				allCandidate.add(obj);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return allCandidate;
	}

	public List<Candidate> insertCandidate() {

		String sql = "INSERT INTO advjava193.candidate VALUES(?,?,?,?,?,?,?,?,?)";
		sc = new Scanner(System.in);

		try {
			conn = Utility.support();
			PreparedStatement st = conn.prepareStatement(sql);

			allCandidate = new ArrayList<>();

			System.out.print("Enter Candidate ID: ");
			int cid = sc.nextInt();
			st.setInt(1, cid);
			sc.nextLine();

			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			st.setString(2, name);

			System.out.print("Enter Party: ");
			String party = sc.nextLine();
			st.setString(3, party);

			System.out.print("Enter State: ");
			String state = sc.nextLine();
			st.setString(4, state);

			System.out.print("Enter Assembly: ");
			String assembly = sc.nextLine();
			st.setString(5, assembly);

			System.out.print("Enter Assembly No: ");
			int assemblyNo = sc.nextInt();
			st.setInt(6, assemblyNo);
			sc.nextLine();

			System.out.print("Enter Status (Accepted/Rejected/Withdrawn): ");
			String status = sc.nextLine();
			st.setString(7, status);

			System.out.print("Enter Gender (Male/Female): ");
			String gender = sc.nextLine();
			st.setString(8, gender);

			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			st.setInt(9, age);

			int eu = st.executeUpdate();

			if (eu > 0) {
				System.out.println("Data inserted");
			} else {
				System.out.println("Not inserted");
			}

			Candidate candidate = new Candidate(cid, name, party, state, assembly, assemblyNo, status, gender, age);
			allCandidate.add(candidate);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return allCandidate;
	}
	
	
	public List<Candidate> deleteCandidate(int cid) throws SQLException {
		
		String  sql = "DELETE FROM advjava193.candidate WHERE cid = ?";
	
		conn = Utility.support();
		PreparedStatement pstmt = conn.prepareStatement(sql);
	       
		pstmt.setInt(1, cid);
	        
	    int rowsAffected = pstmt.executeUpdate();
		
		if(rowsAffected>0) {
			 System.out.println("candidate has been removed");
		 }else {
			 System.out.println("No candidate found");
		 }
		
		return allCandidate();
		
	}
	
	public List<Candidate> updateCandidate(int cid) throws SQLException  {
	    String sql = "UPDATE advjava193.candidate SET name = ?, party = ?, state = ?, assembly = ? WHERE cid = ?";
	    sc = new Scanner(System.in);

	    conn = Utility.support();
	    PreparedStatement st = conn.prepareStatement(sql);

	    System.out.print("Enter Name: ");
	    String name = sc.nextLine();
	    st.setString(1, name);

	    System.out.print("Enter Party: ");
	    String party = sc.nextLine();
	    st.setString(2, party);

	    System.out.print("Enter State: ");
	    String state = sc.nextLine();
	    st.setString(3, state);

	    System.out.print("Enter Assembly: ");
	    String assembly = sc.nextLine();
	    st.setString(4, assembly);

	   	   
	    st.setInt(5, cid);

	    int eu = st.executeUpdate();

	    if (eu > 0) {
	        System.out.println("Data updated");
	    } else {
	        System.out.println("Update failed");
	    }

	    return allCandidate();
	}

}
