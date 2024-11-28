package com.cinexpress.videofriend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.repository.CustomerRepository;
import com.cinexpress.videofriend.services.PremiumSubscriptionService;

@Service
public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public PremiumSubscription activatePremiumSubscription(Long customerId, PremiumSubscription ps) {
        
        Customer customer = customerRepository.findById(customerId).get();

        customer.setPremiumSubscription(ps);

        return customerRepository.save(customer).getPremiumSubscription();
    }

    @Override
    public Boolean hasDiscount(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();

        return customer.getPremiumSubscription().getDiscounts();
    }

    @Override
    public Boolean hasExcusiveCatalog(Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        return customer.getPremiumSubscription().getExclusiveCatalog();
    }
    
}
