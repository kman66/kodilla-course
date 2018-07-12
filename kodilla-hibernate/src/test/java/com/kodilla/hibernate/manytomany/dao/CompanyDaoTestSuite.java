package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testCompanyAndEmployeeNamedQueries(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company bigStar = new Company("Big star");
        Company apple = new Company("Apple");
        Company dell = new Company("Dell");

        bigStar.getEmployees().add(johnSmith);
        apple.getEmployees().add(stephanieClarckson);
        apple.getEmployees().add(lindaKovalsky);
        dell.getEmployees().add(johnSmith);
        dell.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(bigStar);
        johnSmith.getCompanies().add(dell);
        stephanieClarckson.getCompanies().add(apple);
        lindaKovalsky.getCompanies().add(apple);
        lindaKovalsky.getCompanies().add(dell);

        companyDao.save(bigStar);
        int bigStarId = bigStar.getId();
        companyDao.save(apple);
        int appleId = apple.getId();
        companyDao.save(dell);
        int dellId = dell.getId();

        //When
        List<Employee> employees = employeeDao.retrieveEmployeeWithName("Kovalsky");
        String employeeName = employees.get(0).getLastname();
        List<Company> companies = companyDao.retrieveCompanyWhichThreeFirstCharactersAre("App");
        String companyName = companies.get(0).getName();

        //Then
        Assert.assertEquals(1, employees.size());
        Assert.assertEquals(1, companies.size());
        Assert.assertEquals("Kovalsky", employeeName);
        Assert.assertEquals("Apple", companyName);

        //CleanUp
        try {
            companyDao.delete(bigStar);
            companyDao.delete(apple);
            companyDao.delete(dell);
        } catch (Exception e) {
            //do nothing
        }
    }
}
