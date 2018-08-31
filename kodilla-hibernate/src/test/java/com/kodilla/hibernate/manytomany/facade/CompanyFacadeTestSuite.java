package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTestSuite {
    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testRetrieveCompanyWithNameLike() {
        //Given
        Company bigStar = new Company("Big star");
        Company apple = new Company("Apple");
        Company dell = new Company("Dell");

        companyDao.save(bigStar);
        int bigStarId = bigStar.getId();
        companyDao.save(apple);
        int appleId = apple.getId();
        companyDao.save(dell);
        int dellId = dell.getId();

        try {
            //When
            List<Company> companies = companyFacade.retrieveCompanyWithNameLike("ppp");
            String companyName = companies.get(0).getName();
            int companyId = companies.get(0).getId();
            //Then
            Assert.assertNotNull(companies);
            Assert.assertEquals(1, companies.size());
            Assert.assertEquals("Apple", companyName);
            Assert.assertEquals(appleId, companyId);
        } catch (CompanyRetrievalException e) {
            // business exception - should be handled in real application
        } finally {
            try {
                companyDao.delete(bigStar);
                companyDao.delete(apple);
                companyDao.delete(dell);
            } catch (IllegalArgumentException e) {
                // some information
            }
        }
    }

    @Test
    public void testRetrieveEmployeeWithLastnameLike() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        int johnSmithsId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonsId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskysId = lindaKovalsky.getId();

        try {
            //When
            List<Employee> employees = companyFacade.retrieveEmployeeWithLastnameLike("val");
            String employeeName = employees.get(0).getLastname();
            int employeeId = employees.get(0).getId();
            //Then
            Assert.assertNotNull(employees);
            Assert.assertEquals(1, employees.size());
            Assert.assertEquals("Kovalsky", employeeName);
            Assert.assertEquals(lindaKovalskysId, employeeId);
        } catch (CompanyRetrievalException e) {
            // business exception - should be handled in real application
        } finally {
            try {
                employeeDao.delete(johnSmith);
                employeeDao.delete(stephanieClarckson);
                employeeDao.delete(lindaKovalsky);
            } catch (IllegalArgumentException e) {
                // some information
            }
        }
    }
}