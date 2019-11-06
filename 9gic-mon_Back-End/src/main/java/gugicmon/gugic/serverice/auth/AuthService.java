package gugicmon.gugic.serverice.auth;

import gugicmon.gugic.entity.Co_User;
import gugicmon.gugic.repository.Co_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements AuthServicesImpl {

    @Autowired
    Co_UserRepository co_userRepository;

    @Override
    public void saveUser(Co_User co_user) {
        co_userRepository.save(co_user);
    }

    @Override
    public Optional<Co_User> getUserById(String id) {
        return co_userRepository.findById(id);
    }
}