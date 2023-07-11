package com.cg.bookmydoctor.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Feedback;
import com.cg.bookmydoctor.repository.IFeedbackRepository;

@Service
public class FeedbackServiceImplementation implements IFeedbackService {
	
	@Autowired
	IFeedbackRepository ifeedbackrepository;

	//view all feedbacks
	@Override
	public Iterable<Feedback> viewAllFeedback() {
		return ifeedbackrepository.findAll();
	}

	//view feedback by id
	@Override
	public Feedback viewFeedback(Long feedbackId) throws FeedbackException {
		Optional<Feedback> findById = ifeedbackrepository.findById(feedbackId);
		if (findById.isPresent()) {
			return findById.get();
		}
		
		else
		{
			throw new FeedbackException("Feedback with Id:"+feedbackId+" not exists");
		}
	}

	//add feedback
	@Override
	public ResponseEntity<?> addFeedback(Feedback feedback) {
		Optional<Feedback> findById = ifeedbackrepository.findById(feedback.getFeedbackId());
		try {
			if (!findById.isPresent()) {
				ifeedbackrepository.save(feedback);
				return new ResponseEntity<>(feedback,HttpStatus.OK);
			}
			else {
				throw new FeedbackException("Feedback with Id:"+feedback.getFeedbackId()+" already present");
			}
		}
		catch(FeedbackException e)
		{
			return new ResponseEntity<>(feedback,HttpStatus.NOT_FOUND);
		}
	}
	
	//modify feedback
	@Override
	public Feedback updateFeedback(Feedback feedback) throws FeedbackException {
		Optional<Feedback> findById = ifeedbackrepository.findById(feedback.getFeedbackId());
		if(findById.isPresent()) {
			ifeedbackrepository.save(feedback);
		}
		else
			throw new FeedbackException("Feedback with Id: "+feedback.getFeedbackId()+" not exists");
		return feedback;
	}

	@Override
	public String removeFeedback(Long feedbackId) throws FeedbackException {
		Optional<Feedback> findById = ifeedbackrepository.findById(feedbackId);
		if(findById.isPresent()) {
			ifeedbackrepository.deleteById(feedbackId);
			return "Feedback removed";
		}
		else
		{
			throw new FeedbackException("Feedback with Id: "+feedbackId+" does not exist");
		}
	}
}