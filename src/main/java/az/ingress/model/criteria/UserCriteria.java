package az.ingress.model.criteria;

import az.ingress.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class UserCriteria {
    private String name;
    private BigDecimal balanceFrom;
    private BigDecimal balanceTo;
    private BigDecimal debtFrom;
    private BigDecimal debtTo;

}
