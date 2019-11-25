package gugicmon.gugic.repository;

import gugicmon.gugic.domain.entity.Co_User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Co_UserRepository extends CrudRepository<Co_User, String> {

    Co_User findByCoUserId(String id);

    List<Co_User> findByCoUserEmail(String email);
}
