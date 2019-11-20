package gugicmon.gugic.service.token;

import gugicmon.gugic.service.auth.Co_Token;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    Co_Token createCoToken(String id);

    String verifyToken(String token);

}
