package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanySalaryProcessor implements SalaryProcessor {

    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        BigDecimal sum;
        sum = employees.stream()
                .map(e -> e.getBaseSalary())
                .reduce(BigDecimal.ZERO, (res, current) -> res = res.add(current));
        return sum;
    }
}
