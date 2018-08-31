package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public List<Company> retrieveCompanyWithNameLike(final String name) throws CompanyRetrievalException {
        LOGGER.info("Searching for companies with name like '" + name + "'");
        List<Company> companies = companyDao.retrieveCompanyWithNameLike(name);
        int companiesSize = companies.size();
        if (companiesSize == 0) {
            LOGGER.error("No companies found which correspond to '" + name + "'");
            throw new CompanyRetrievalException(CompanyRetrievalException.ERR_NOT_FOUND);
        }
        LOGGER.info("Found " + companiesSize +  (companiesSize == 1 ? " company" : " companies") + " which correspond to '" + name + "'");
        return companies;
    }

    public List<Employee> retrieveEmployeeWithLastnameLike(final String lastname) throws CompanyRetrievalException {
        LOGGER.info("Searching for employees with lastname like '" + lastname + "'");
        List<Employee> employees = employeeDao.retrieveEmployeeWithLastnameLike(lastname);
        int employeesSize = employees.size();
        if (employeesSize == 0) {
            LOGGER.error("No employees found which correspond to '" + lastname + "'");
            throw new CompanyRetrievalException(CompanyRetrievalException.ERR_NOT_FOUND);
        }
        LOGGER.info("Found " + employeesSize +  (employeesSize== 1 ? " employee" : " employees") + " which correspond to '" + lastname + "'");
        return employees;
    }

}
