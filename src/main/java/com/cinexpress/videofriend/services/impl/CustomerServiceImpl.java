package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.models.dtos.CustomerDTO;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.repository.CustomerRepository;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.repository.PremiumSubscriptionRepository;
import com.cinexpress.videofriend.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PremiumSubscriptionRepository premiumSubscriptionRepository;


    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setType(customerDTO.getType());
        customer.setPreferences(customerDTO.getPreferences());
        customer.setSubscription(customerDTO.getSubscription());
        customer.setCompany(customerDTO.getCompany());
        customer.setMovies(customerDTO.getMovies());
        customer.setPremiumSubscription(customerDTO.getPremiumSubscription());


        return customerRepository.save(customer);
    }

    @Override
    public void addClientToCompany(Long customerId, Long companyId) {
        Customer customer = customerRepository.findById(customerId).get();
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isEmpty()){
            Company updateCompany = company.get();
            updateCompany.getCustomers().add(customer);
            customer.setCompany(updateCompany);
            companyRepository.save(updateCompany);
        }
    }

    @Override
    public void addMovieToCustomer(Long customerId, Long movieId) {
        
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        movieRepository.findById(movieId).ifPresent(movie -> {
            movie.setCustomer(customer);
            movieRepository.save(movie);
        });
    }

    @Override
    public List<Movie> listAllCustomerMovies(Long id) {
        return customerRepository.findMoviesByCustomerId(id).get();
    }




    @Override
    public boolean hasPremiumSubscription(Long customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        return customer.getPremiumSubscription().getDiscounts() || customer.getPremiumSubscription().getExclusiveCatalog() || customer.getPremiumSubscription().getPreReleases();
    }

    

    @Override
    public void deactivatePremiumSubscription(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){
            Customer niCustomer = customer.get();
            PremiumSubscription premium = new PremiumSubscription();
            premium.setDiscounts(false);
            premium.setExclusiveCatalog(false);
            premium.setPreReleases(false);
            premium.setCustomer(niCustomer);
            premiumSubscriptionRepository.save(premium);
            niCustomer.setPremiumSubscription(premium);
            customerRepository.save(niCustomer);
        }
        
    }

    


    
    
}
