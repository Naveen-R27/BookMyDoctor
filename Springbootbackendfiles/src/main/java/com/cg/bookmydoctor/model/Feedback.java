package com.cg.bookmydoctor.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;


import javax.persistence.CascadeType;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long feedbackId;
	
	private int rating;
	
	
	private String feedbackComment;
	 private String patientName;
	 
	 private String doctorName;

	public String getPatientName() {
		return patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	

	public long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	public String getFeedbackComment() {
		return feedbackComment;
	}

	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
	}
}
