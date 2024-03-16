package com.patika.kredinbizdenservice.serive;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.time.LocalDateTime;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationService {

    private List<Application> applications;

    public User findMostApplicantUser() {
        Map<User, Integer> userApplicationCount = new HashMap<>();
        for (Application application : applications) {
            userApplicationCount.put(application.getUser(), userApplicationCount.getOrDefault(application.getUser(), 0) + 1);
        }

        Map.Entry<User, Integer> maxEntry = null;
        for (Map.Entry<User, Integer> entry : userApplicationCount.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry != null ? maxEntry.getKey() : null;
    }

    public User findUserWithHighestLoanRequest(List<Application> applications) {
        Application maxLoanApplication = applications.stream()
                .max(Comparator.comparing(application -> application.getLoan().getAmount()))
                .orElse(null);

        return maxLoanApplication != null ? maxLoanApplication.getUser() : null;
    }

    public BigDecimal findHighestLoanAmount(List<Application> applications) {
        return applications.stream()
                .map(application -> application.getLoan().getAmount())
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    public List<Application> findApplicationsLastMonth(List<Application> applications) {
        LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
        return applications.stream()
                .filter(application -> application.getLocalDateTime().isAfter(oneMonthAgo))
                .collect(Collectors.toList());
    }

    public List<Application> findApplicationsByEmail(List<Application> applications, String email) {
        return applications.stream()
                .filter(application -> application.getUser().getEmail().equals(email))
                .collect(Collectors.toList());
    }



}
