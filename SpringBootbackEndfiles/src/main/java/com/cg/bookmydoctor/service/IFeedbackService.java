package com.cg.bookmydoctor.service;

import org.springframework.http.ResponseEntity;

import com.cg.bookmydoctor.exception.FeedbackException;
import com.cg.bookmydoctor.model.Feedback;

public interface IFeedbackService {
	
	public Iterable<Feedback> viewAllFeedback();
	public Feedback viewFeedback(Long feedbackId) throws FeedbackException;
	public ResponseEntity<?> addFeedback(Feedback feedback);
	public Feedback updateFeedback(Feedback feedback) throws FeedbackException;
	public String removeFeedback(Long feedbackId) throws FeedbackException;

}