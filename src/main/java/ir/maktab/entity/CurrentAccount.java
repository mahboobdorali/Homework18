package ir.maktab.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class CurrentAccount extends Account {
    @Column(columnDefinition = "boolean default true")
    private boolean isIssuingCheck;

    public CurrentAccount(String cardNumber, String accountNumber,
                          Date openingDate, Date expiryDate, double amount,
                          int cvv2, boolean isIssuingCheck) {
        super(cardNumber, accountNumber, openingDate, expiryDate, amount, cvv2);
        this.isIssuingCheck = isIssuingCheck;
    }
}
