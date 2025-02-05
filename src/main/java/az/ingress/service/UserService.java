package az.ingress.service;

import az.ingress.model.criteria.PageCriteria;
import az.ingress.model.criteria.UserCriteria;
import az.ingress.model.response.PageableResponse;

public interface UserService {
    PageableResponse getUsers(PageCriteria pageCriteria, UserCriteria userCriteria);
}
