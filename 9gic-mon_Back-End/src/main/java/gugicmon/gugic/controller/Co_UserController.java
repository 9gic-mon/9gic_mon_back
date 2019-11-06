package gugicmon.gugic.controller;

import gugicmon.gugic.entity.Co_User;
import gugicmon.gugic.exception.AlreadyExistException;
import gugicmon.gugic.exception.NotFoundException;
import gugicmon.gugic.repository.Co_UserRepository;
import gugicmon.gugic.serverice.auth.Co_Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/9gic/Co_users")
public class Co_UserController {
    @Autowired
    Co_UserRepository co_userRepository;

    @GetMapping
    public Iterable<Co_User> findAll()
    {
        return co_userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/signin")
    public ResponseEntity<Map<Object, Object>> signIn(@RequestBody Co_User param)
    {
        Optional<Co_User> optionalCo_user = co_userRepository.findById(param.getCoUserEmail());
        Co_User co_user = null;
        try {
            co_user = optionalCo_user.get();
        } catch (NoSuchElementException e){
            throw new NotFoundException("Account Not Found");
        }

        if(co_user.getCoUserPassword().equals(param.getCoUserPassword())){
            return ok(new Co_Token(co_user).getTokenResponse());
        } else {
            throw new NotFoundException("Account Not Found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity<Map<Object, Object>> signUp(@RequestBody Co_User co_user) {
        Optional<Co_User> optionalCo_user = co_userRepository.findById(co_user.getCoUserEmail());
        if (optionalCo_user.isPresent()){
            throw new AlreadyExistException("Account Already Exist");
        } else {
            co_userRepository.save(co_user);
        }

        Co_Token co_token = new Co_Token(co_user);
        return ok(co_token.getTokenResponse());
    }
}
