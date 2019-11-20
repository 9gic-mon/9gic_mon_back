package gugicmon.gugic.repository;

import gugicmon.gugic.domain.entity.Co_User;
import org.springframework.data.repository.CrudRepository;

public interface Co_UserRepository extends CrudRepository<Co_User, String> {

    Co_User findByCoUserEmail(String email);
}
