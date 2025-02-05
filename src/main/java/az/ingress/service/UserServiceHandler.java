package az.ingress.service;

import az.ingress.dao.repository.UserRepository;
import az.ingress.model.criteria.PageCriteria;
import az.ingress.model.criteria.UserCriteria;
import az.ingress.model.response.PageableResponse;
import az.ingress.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static az.ingress.mapper.PageableMapper.PAGEABLE_MAPPER;



@Service
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {
    private final UserRepository userRepository;

    @Override
    public PageableResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria) {
        var pageRequest = PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount());
        var specification = new UserSpecification(userCriteria);
        var ordersPage = userRepository.findAll(specification, pageRequest);
        return PAGEABLE_MAPPER.buildPageableResponse(ordersPage.getContent(),
                ordersPage.hasNext(),
                ordersPage.getTotalPages(),
                ordersPage.getTotalElements()
        );
    }
}
