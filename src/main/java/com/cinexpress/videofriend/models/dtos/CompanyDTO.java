package com.cinexpress.videofriend.models.dtos;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private Long id;
    private String name;
    private String description;
    private List<Movie> movies;
    private List<Customer> customers;
}
