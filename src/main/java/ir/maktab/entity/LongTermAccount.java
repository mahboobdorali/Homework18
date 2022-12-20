package ir.maktab.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class LongTermAccount extends Account{

}
