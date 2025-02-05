package az.ingress.service.specification;

import az.ingress.dao.entity.UserEntity;
import az.ingress.model.UserStatus;
import az.ingress.model.criteria.UserCriteria;
import az.ingress.util.PredicateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
@Data
public class UserSpecification implements Specification<UserEntity> {
    private final UserCriteria userCriteria;

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = PredicateUtil.builder()
                .addNullSafety(userCriteria.getName(), name -> cb.like(root.get("name"), applyLikePattern(name)))
                .addNullSafety(userCriteria.getBalanceFrom(), amountFrom-> cb.greaterThanOrEqualTo(root.get("balance"), amountFrom))
                .addNullSafety(userCriteria.getBalanceTo(), amountTo-> cb.lessThanOrEqualTo(root.get("balance"), amountTo ))
                .add(UserStatus.INACTIVE, status -> cb.notEqual(root.get("status"), status))
                .build();
        return cb.and(predicates);
    }
    private String applyLikePattern(String data) {
        return data+"%";
    }
}
