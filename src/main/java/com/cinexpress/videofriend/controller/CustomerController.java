package com.cinexpress.videofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.models.dtos.CustomerDTO;
import com.cinexpress.videofriend.services.CustomerService;
import com.cinexpress.videofriend.services.PremiumSubscriptionService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
   @Autowired
    private CustomerService customerService;

    @Autowired
    private PremiumSubscriptionService premiumSubscriptionService;

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        
        Customer newCustomer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
    
    @PostMapping("/addClientToCompany/{customerId}/{companyId}")
    public ResponseEntity<Void> addClientToCompany(@PathVariable Long customerId, @PathVariable Long companyId){
        try{
            customerService.addClientToCompany(customerId, companyId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
                
    }

    @PostMapping("/addMovieToCustomer/{customerId}/{movieId}")
    public ResponseEntity<Void> addMovieToCustomer(@PathVariable Long customerId, @PathVariable Long movieId){
        try{
            customerService.addMovieToCustomer(customerId, movieId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
                
    }

    @GetMapping("/listMovies/{id}")
    public ResponseEntity<?> listAllCustomerMovies(@PathVariable Long id){
        return ResponseEntity.ok(customerService.listAllCustomerMovies(id));
    }

    @PutMapping("/activatePremiumSubscription/{customerId}")
    public ResponseEntity<PremiumSubscription> activatePremiumSubscription(@PathVariable Long customerId, @RequestBody PremiumSubscription ps){

        return ResponseEntity.ok(premiumSubscriptionService.activatePremiumSubscription(customerId, ps));
    
    }


    @GetMapping("/hasPremiumSubscription/{customerId}")
    public ResponseEntity<Boolean> hasPremiumSubscription(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.hasPremiumSubscription(customerId));
    }

    @PutMapping("/deactivatePremiumSubscription/{customerId}")
    public ResponseEntity<Void> deactivatePremiumSubscription(@PathVariable Long customerId){
        customerService.deactivatePremiumSubscription(customerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/hasDiscount/{customerId}")
    public ResponseEntity<Boolean> hasDiscount(@PathVariable Long customerId){
        return ResponseEntity.ok(premiumSubscriptionService.hasDiscount(customerId));
    }

    @GetMapping("/hasExclusiveCatalog/{customerId}")
    public ResponseEntity<Boolean> hasExclusiveCatalog(@PathVariable Long customerId){
        return ResponseEntity.ok(premiumSubscriptionService.hasExcusiveCatalog(customerId));
    }
}
