package com.library.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.subscription.model.Book;
import com.library.subscription.repository.Subscription;
import com.library.subscription.repository.SubscriptionRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<List<Subscription>> getSubscriptions() {
		List<Subscription> subscriptions = (List<Subscription>) subscriptionRepository.findAll();
		return new ResponseEntity<List<Subscription>>(subscriptions, HttpStatus.OK);
	}

	public ResponseEntity<Subscription> getSubscriptionByName(String name) {
		Subscription subscription = subscriptionRepository.findBySubscriberName(name);
		return new ResponseEntity<Subscription>(subscription, HttpStatus.OK);
	}

	public ResponseEntity<String> addNewSubscription(Subscription subscription) {
		/*Application application = eurekaClient.getApplication(bookServiceId);*/
		/*InstanceInfo instanceInfo = application.getInstances().get(0);*/
		
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("bookService", false);
		StringBuilder builder = new StringBuilder("http://localhost:");
		builder.append(instanceInfo.getPort())
			   .append("/getBooks/")
			   .append(subscription.getBookId());
		
		System.out.println("url: "+ builder.toString());
		Book book = restTemplate.getForObject(builder.toString(), Book.class);
		
		if(book.getAvailableCopies() > 0) {
			subscriptionRepository.save(subscription);
			builder.setLength(0);
			builder.append("http://localhost:")
				   .append(instanceInfo.getPort())
				   .append("/books/UpdateAvailability/")
				   .append(book.getBookID())
				   .append("/-1");
			
			Book bookUpdated = restTemplate.getForObject(builder.toString(), Book.class);
			
			if(bookUpdated.getAvailableCopies() == (book.getAvailableCopies() - 1))
				return ResponseEntity.status(201).body("Successful creation of subscription record");
		}else
			
			return ResponseEntity.status(422).body("book copies not available for subscription");
		
		
		return ResponseEntity.badRequest().body("bad request");
	}

	public void returnBook(Subscription subscription) {
		// TODO Auto-generated method stub

	}

}
