package com.library.subscription.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.library.subscription.repository.Subscription;

public interface SubscriptionService {
	
	ResponseEntity<List<Subscription>>getSubscriptions();
	ResponseEntity<Subscription>getSubscriptionByName(String Name);
	ResponseEntity<String> addNewSubscription(Subscription subscription);
	void returnBook(Subscription subscription);
}
