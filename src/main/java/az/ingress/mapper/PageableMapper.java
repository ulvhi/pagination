package az.ingress.mapper;

import az.ingress.dao.entity.UserEntity;
import az.ingress.model.response.PageableResponse;

import java.util.List;

import static az.ingress.mapper.UserMapper.USER_MAPPER;


public enum PageableMapper {
    PAGEABLE_MAPPER;



    public PageableResponse buildPageableResponse(List<UserEntity> users,
                                                  boolean hasNextPage,
                                                  int lastPageNumber,
                                                  long totalElements) {
        var userList = users.stream().map(USER_MAPPER::mapEntityToDto).toList();
        return PageableResponse.builder()
                .users(userList)
                .hasNextPage(hasNextPage)
                .lastPageNumber(lastPageNumber)
                .totalElements(totalElements)
                .build();
    }
}
