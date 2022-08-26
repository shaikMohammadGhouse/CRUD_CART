package com.shoppingcart.app.dto;

import lombok.Data;

@Data
public class FeedBackDto {

	int feedbackId;
	int cutomerId;
	int vegetableId;
	int rating;
	String comments;
}
