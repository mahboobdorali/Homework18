package ir.maktab.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class ShortTermAccount extends Account{
    private double profit;

    public ShortTermAccount(String cardNumber, String accountNumber,
                            Date openingDate, Date expiryDate, double amount,
                            int cvv2, double profit) {
        super(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2);
        this.profit = profit;
    }
}
