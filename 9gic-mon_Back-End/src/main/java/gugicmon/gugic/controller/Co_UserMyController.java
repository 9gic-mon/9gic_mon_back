package gugicmon.gugic.controller;

import gugicmon.gugic.domain.entity.Co_User;
import gugicmon.gugic.domain.entity.Co_UserEditMypage;
import gugicmon.gugic.exception.NotFoundException;
import gugicmon.gugic.repository.Co_UserRepository;
import gugicmon.gugic.service.auth.AuthService;
import gugicmon.gugic.service.storage.StorageServiceImpl;
import gugicmon.gugic.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.http.ResponseEntity.ok;

import java.security.Identity;
import java.util.Optional;


@RestController
public class Co_UserMyController {

    @Autowired
    TokenService tokenService;

    private final String UPLOAD_ROOT = "src/main/resources/";

    @Autowired
    StorageServiceImpl storageService;

    @Autowired
    Co_UserRepository co_userRepository;

    @Autowired
    ResourceLoader resourceLoader;

/*     @PostMapping(path = "/9gic/Co_users/myPage/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
   public ResponseEntity<Void> add(
            @RequestHeader("Authorization") String auth,
            @RequestParam("file") MultipartFile file) {

        String identity = tokenService.verifyToken(auth.replace("Bearer ", ""));
        storageService.store(file);

        return ResponseEntity.ok().build();
   }*/
@GetMapping(path = "/9gic/Co_users/myPage/image/{coUserImageUrl}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity getImage(@PathVariable("coUserImageUrl") String filename){
    return ResponseEntity.ok(resourceLoader.getResource("file:" + UPLOAD_ROOT + filename));
}


@PostMapping(path = "/9gic/Co_users/myPage/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> editMyPage(
            @RequestHeader("Authorization") String auth,
            /*@RequestBody Co_UserEditMypage co_userEditMypage*/
            @ModelAttribute Co_UserEditMypage co_userEditMypage) {

        Optional<Co_User> optionalCo_user = co_userRepository.findById(co_userEditMypage.getCoUserEmail());
        String identity = tokenService.verifyToken(auth.replace("Bearer ", ""));

        if (optionalCo_user.isPresent()){
            optionalCo_user.get().setCoUserEmail(co_userEditMypage.getCoUserEmail());
            optionalCo_user.get().setCoUserPassword(co_userEditMypage.getCoUserPassword());
            optionalCo_user.get().setCoUserCopname(co_userEditMypage.getCoUserCopname());
            optionalCo_user.get().setCoUserTell(co_userEditMypage.getCoUserTell());
            optionalCo_user.get().setCoUserDescription(co_userEditMypage.getCoUserDescription());
            optionalCo_user.get().setCoUserImageUrl(co_userEditMypage.getCoUserImageUrl());

            co_userRepository.save(co_userEditMypage.toCo_User());

            return ResponseEntity.ok().build();
        }
        else{
            throw new NotFoundException("아이디가 존재하지않음");
        }
    }

    @PostMapping(path = "/9gic/Co_users/myPage/edit/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Co_User> editMyPageImage(
            @RequestHeader("Authorization") String auth,
            @RequestParam("imageFile") MultipartFile imageFile) {

        String identity = tokenService.verifyToken(auth.replace("Bearer ", ""));
        Optional<Co_User> optionalCo_user = co_userRepository.findById(identity);

        if (optionalCo_user.isPresent()){
            return ResponseEntity.ok().body(optionalCo_user.get());
        } else {
            throw new NotFoundException("Id Not Found");
    }
}


    @PostMapping(path = "/9gic/Co_users/myPage/get")
    public ResponseEntity<Co_User> getMyPage(@RequestHeader("Authorization") String auth) {
        String identity = tokenService.verifyToken(auth.replace("Bearer ", ""));
        Optional<Co_User> optionalCo_user = co_userRepository.findById(identity);

        if (optionalCo_user.isPresent()) {
            return ResponseEntity.ok().body(optionalCo_user.get());
        } else {
            throw new NotFoundException("Id Not Found");
        }
    }
}
