package az.ingress.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PageableResponse {
    private List<UserResponse> users;
    private int lastPageNumber;
    private long totalElements;
    private boolean hasNextPage;
}
