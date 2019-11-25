package gugicmon.gugic.controller;

import gugicmon.gugic.domain.entity.Co_User;
import gugicmon.gugic.domain.payload.SignInModel;
import gugicmon.gugic.exception.AlreadyExistException;
import gugicmon.gugic.exception.ForbiddenException;
import gugicmon.gugic.exception.NotFoundException;
import gugicmon.gugic.repository.Co_UserRepository;
import gugicmon.gugic.service.auth.Co_Token;
import gugicmon.gugic.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/9gic/users")
public class Co_UserController {
    Co_User user;

    @Autowired
    private TokenService tokenService;

    @Autowired
    Co_UserRepository co_userRepository;

    @GetMapping
    public Iterable<Co_User> findAll()
    {
        return co_userRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, path = "/signin")
    public ResponseEntity<Co_Token> signIn(@RequestBody SignInModel signIn)
    {
        user = co_userRepository.findByCoUserEmail(signIn.getCoUserEmail()).get(0);
        System.out.println(co_userRepository.findByCoUserId(signIn.getCoUserEmail()));
        System.out.println("들어옴");
        if (user == null) {
            System.out.println("아이디가없음");
            throw new NotFoundException("Account Not Found");

        }

        if (user.getCoUserPassword().equals(signIn.getCoUserPassword())) {
            System.out.println("성공");
            return ok(tokenService.createCoToken(signIn.getCoUserEmail()));
        } else {
            System.out.println("중복됨");
            throw new ForbiddenException();
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ResponseEntity<Void> signUp(@RequestBody Co_User co_user) {
        Optional<Co_User> optionalCo_user = co_userRepository.findById(co_user.getCoUserEmail());

        if (optionalCo_user.isPresent()){
            throw new AlreadyExistException("Account Already Exist");
        } else {
            co_userRepository.save(co_user);
        }
        return ok().build();
    }
}
