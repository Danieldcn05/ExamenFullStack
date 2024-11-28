package com.cinexpress.videofriend.models.dtos;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;

    private String title;

    private String format;

    private String genre;
    private String language;
    private Boolean availability;

    private Company company;


    private Customer customer;


    private Inventory inventory; 
}
