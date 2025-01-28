package az.ingress.mapper;

import az.ingress.dao.entity.UserEntity;
import az.ingress.model.response.UserResponse;

public enum UserMapper {
    USER_MAPPER;

    public UserResponse mapEntityToDto(UserEntity entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .age(entity.getAge())
                .balance(entity.getBalance())
                .debt(entity.getDebt())
                .build();
    }
}
