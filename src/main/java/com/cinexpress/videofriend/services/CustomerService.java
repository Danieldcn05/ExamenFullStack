package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.dtos.CustomerDTO;

public interface CustomerService {
    Customer createCustomer(CustomerDTO customer);
    void addMovieToCustomer(Long customerId, Long movieId);
    void addClientToCompany(Long customerId, Long companyId);
    List<Movie> listAllCustomerMovies(Long id);
    boolean hasPremiumSubscription(Long customerId);
    void deactivatePremiumSubscription(Long customerId);

    
}