package com.cinexpress.videofriend.models.dtos;

import java.util.List;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.PremiumSubscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String type;
    private List<String> preferences;
    private String subscription;
    private Company company;
    private List<Movie> movies;
    private PremiumSubscription premiumSubscription;
}

