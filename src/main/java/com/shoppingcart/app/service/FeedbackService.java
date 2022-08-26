package com.shoppingcart.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.FeedBackDto;

@Service
public interface FeedbackService {

	FeedBackDto addFeedback(FeedBackDto fdbck);
	List<FeedBackDto> viewAllFeedbacks(int vegId);
	List<FeedBackDto> viewFeedBack(int custId);
}
