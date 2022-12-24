package ir.maktab.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class LongTermAccount extends Account{
    private double annualProfit;

    public LongTermAccount(String cardNumber, String accountNumber,
                           Date openingDate, Date expiryDate, double amount,
                           int cvv2, double annualProfit) {
        super(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2);
        this.annualProfit = annualProfit;
    }
}
