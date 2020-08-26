package com.library.subscription.repository;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.sun.istack.Nullable;

@Entity
public class Subscription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUST_SEQ")
	@SequenceGenerator(allocationSize =1, name = "CUST_SEQ")
	private int subscriptionId;
	
	private String subscriberName;
	
	@Temporal(TemporalType.DATE)
	@Nullable
	private Date dateSubscribed;
	
	@Temporal(TemporalType.DATE)
	@Nullable
	private Date dateReturned;
	
	private String bookId;
	
	@Transient
	private boolean notify;
	
	public Subscription() {
		
	}
	

	public Subscription(int subscriptionId, String subscriberName, Date dateSubscribed, Date dateReturned,
			String bookId, boolean notify) {
		super();
		this.subscriptionId = subscriptionId;
		this.subscriberName = subscriberName;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
		this.bookId = bookId;
		this.notify = notify;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public Date getDateSubscribed() {
		return dateSubscribed;
	}

	public void setDateSubscribed(Date dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public boolean isNotify() {
		return notify;
	}


	public void setNotify(boolean notify) {
		this.notify = notify;
	}
	
	
	
	
	
	

}
