package com.cg.bookmydoctor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmydoctor.model.Feedback;

@Repository
public interface IFeedbackRepository extends CrudRepository <Feedback, Long>
{
	
}