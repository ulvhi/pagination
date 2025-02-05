package az.ingress.model.dto;

import java.math.BigDecimal;


public record UserDTO(Long id, String name, String surname, int age, BigDecimal balance, BigDecimal debt) {


}
