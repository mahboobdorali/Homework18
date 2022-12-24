package ir.maktab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    List<Account> accountList = new ArrayList<>();
    private String firstname;
    private String lastname;

    public Person(List<Account> accountList, String firstname, String lastname) {
        this.accountList = accountList;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
