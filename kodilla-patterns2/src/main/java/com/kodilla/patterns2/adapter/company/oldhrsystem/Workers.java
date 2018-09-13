package com.kodilla.patterns2.adapter.company.oldhrsystem;

import java.util.Optional;

public class Workers {
    private String[][] workers = {
            {"542335513549","John","Smith"},
            {"398479239040","Ivone","Novak"},
            {"344234708847","Jessie","Pinkman"},
            {"243490888979","Walter","White"},
            {"232345989493","Clara","Lanson"}
    };

    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };

    public String getWorker(int n) throws IndexOutOfBoundsException {
        return Optional.of(workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n]).
                orElseThrow(() -> new IndexOutOfBoundsException());
    }

    public String[][] getWorkers() {
        return this.workers;
    }

    public double[] getSalaries() {
        return this.salaries;
    }
}
