package com.cinexpress.videofriend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.dtos.CompanyDTO;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
  
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(CompanyDTO company) {
       Company newCompany = new Company();

       newCompany.setName(company.getName());
       newCompany.setDescription(company.getDescription());
       newCompany.setMovies(company.getMovies());
       newCompany.setCustomers(company.getCustomers());

       return companyRepository.save(newCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company updateCompany(Long id ,CompanyDTO company) {
        Company updatedCompany = companyRepository.findById(id).get();

        updatedCompany.setName(company.getName());
        updatedCompany.setDescription(company.getDescription());
        updatedCompany.setMovies(company.getMovies());
        updatedCompany.setCustomers(company.getCustomers());

        return companyRepository.save(updatedCompany);
    }
    
}
