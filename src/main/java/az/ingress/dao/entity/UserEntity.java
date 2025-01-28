package az.ingress.dao.entity;

import az.ingress.model.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private BigDecimal balance;
    private BigDecimal debt;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
