package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.dtos.CompanyDTO;

public interface CompanyService {
    Company createCompany(CompanyDTO company);
    void deleteCompany(Long id);
    Company updateCompany(Long id,CompanyDTO company);
}
