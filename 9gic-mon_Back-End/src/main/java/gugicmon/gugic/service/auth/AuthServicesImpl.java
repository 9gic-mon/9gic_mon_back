package gugicmon.gugic.service.auth;

import gugicmon.gugic.domain.entity.Co_User;
import java.util.Optional;


public interface AuthServicesImpl {

    void saveUser(Co_User co_user);

    Optional<Co_User> getUserById(String id);
}
