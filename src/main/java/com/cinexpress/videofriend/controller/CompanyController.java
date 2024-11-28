package com.cinexpress.videofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.dtos.CompanyDTO;
import com.cinexpress.videofriend.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
     @Autowired
    CompanyService companyService;
    
    @PostMapping("")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDTO companyDTO) {
        Company newCompany = companyService.createCompany(companyDTO);
        return new ResponseEntity<>(newCompany, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        try {
            companyService.deleteCompany(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id,@RequestBody CompanyDTO companyDTO) {
        Company updatedCompany = companyService.updateCompany(id,companyDTO);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);

    }
}
