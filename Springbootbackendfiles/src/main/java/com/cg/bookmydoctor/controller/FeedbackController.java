package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.bookmydoctor.exception.*;
import com.cg.bookmydoctor.model.Feedback;
import com.cg.bookmydoctor.service.IFeedbackService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired(required = true)
	IFeedbackService ifeedbackservice;
	
	@GetMapping("/viewFeedback/{id}")
	@ExceptionHandler(FeedbackException.class)
	public Feedback viewFeedback(@PathVariable("id")Long feedbackId) throws FeedbackException
	{
		return ifeedbackservice.viewFeedback(feedbackId);
	}
	
	@GetMapping("/allFeedback")
	public Iterable<Feedback> viewAllFeedback()
	{
		return ifeedbackservice.viewAllFeedback();
	}

	@PostMapping("/addFeedback")
	@ExceptionHandler(FeedbackException.class)
	public void addFeedback(@RequestBody Feedback feedback)
	{
		ifeedbackservice.addFeedback(feedback);
	}
	
	@PutMapping("/updateFeedback")
	@ExceptionHandler(FeedbackException.class)
	public void updateFeedback(@RequestBody Feedback feedback) throws FeedbackException
	{
		ifeedbackservice.updateFeedback(feedback);
	}
	
	@DeleteMapping("/deleteFeedback/{id}")
	@ExceptionHandler(FeedbackException.class)
	public void removeFeedback(@PathVariable("id")Long feedbackId) throws FeedbackException
	{
		ifeedbackservice.removeFeedback(feedbackId);
	}
}