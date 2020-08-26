package com.library.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.subscription.repository.Subscription;

@RestController
public class SubscriptionServiceRestController implements SubscriptionService {

	@Autowired
	private SubscriptionServiceImpl subscriptionServiceImpl;
	
	@GetMapping("/subscriptions")
	public ResponseEntity<List<Subscription>> getSubscriptions() {
		return subscriptionServiceImpl.getSubscriptions();
	}

	@GetMapping("/subscriptions/{name}")
	public ResponseEntity<Subscription> getSubscriptionByName(@PathVariable("name")String name) {
		return subscriptionServiceImpl.getSubscriptionByName(name);
	}

	@PostMapping("/subscriptions")
	public ResponseEntity<String> addNewSubscription(@RequestBody Subscription subscription) {
		return subscriptionServiceImpl.addNewSubscription(subscription);
	}

	public void returnBook(Subscription subscription) {
		// TODO Auto-generated method stub

	}

}
