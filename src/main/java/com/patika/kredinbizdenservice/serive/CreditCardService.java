package com.patika.kredinbizdenservice.serive;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public class CreditCardService {

    public List<CreditCard> sortCreditCardsByCampaignCount(List<CreditCard> creditCards) {
        return creditCards.stream()
                .sorted(Comparator.comparingInt((CreditCard card) -> card.getCampaignList().size()).reversed())
                .collect(Collectors.toList());
    }

}
