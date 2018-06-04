package com.kodilla.good.patterns.challenges;

import java.util.List;

public class InformationServiceMailImpl implements InformationService {
    @Override
    public void inform(User user, List<Product> productList) {
        System.out.println("Sending mail to user: " + user);
        System.out.println("User email: " + user.getEmail());
        System.out.println("The following products have been ordered:");
        productList.stream()
                .forEach(p -> System.out.println(p));
    }
}
