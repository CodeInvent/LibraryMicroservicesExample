package com.library.subscription.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

	Subscription findBySubscriberName(String name);
}
