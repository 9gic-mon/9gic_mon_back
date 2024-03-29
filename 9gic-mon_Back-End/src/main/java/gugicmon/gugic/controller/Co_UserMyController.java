package gugicmon.gugic.controller;

import gugicmon.gugic.domain.entity.Co_User;
import gugicmon.gugic.domain.request.Co_UserEditMyPageModel;
import gugicmon.gugic.exception.NotFoundException;
import gugicmon.gugic.repository.Co_UserRepository;
import gugicmon.gugic.service.storage.StorageServiceImpl;
import gugicmon.gugic.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;


@RestController
public class Co_UserMyController {
    private String path = "http://10.156.145.140:8080/static/";

    @Autowired
    TokenService tokenService;

    @Autowired
    StorageServiceImpl storageService;

    @Autowired
    Co_UserRepository co_userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/9gic/users/myPage/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<Void> editMyPage(
                @RequestHeader("Authorization") String auth,
                @ModelAttribute Co_UserEditMyPageModel co_usereditmypagemodel) {

        String id = auth.replace("Bearer ", "");
        String identity = tokenService.verifyToken(id);
        Co_User optionalCo_user = co_userRepository.findByCoUserEmail(identity).get(0);

        storageService.store(co_usereditmypagemodel.getCoUserImageFile());

        if (optionalCo_user!=null){
            optionalCo_user.setCoUserEmail(co_usereditmypagemodel.getCoUserEmail());
            optionalCo_user.setCoUserPassword(co_usereditmypagemodel.getCoUserPassword());
            optionalCo_user.setCoUserCopname(co_usereditmypagemodel.getCoUserCopname());
            optionalCo_user.setCoUserTell(co_usereditmypagemodel.getCoUserTell());
            optionalCo_user.setCoUserDescription(co_usereditmypagemodel.getCoUserDescription());
            optionalCo_user.setCoUserImageUrl(path + co_usereditmypagemodel.getCoUserImageFile().getOriginalFilename());
            optionalCo_user.setCoUserEstablish(co_usereditmypagemodel.getCoUserEstablish());
            optionalCo_user.setCoUserMember(co_usereditmypagemodel.getCoUserMember());
            optionalCo_user.setCoUserCapital(co_usereditmypagemodel.getCoUserCapital());
            optionalCo_user.setCoUserAddress(co_usereditmypagemodel.getCoUserAddress());
            optionalCo_user.setCoUserMilitary(co_usereditmypagemodel.getCoUserMilitary());
            optionalCo_user.setCoUserPlace(co_usereditmypagemodel.getCoUserPlace());

            co_userRepository.save(optionalCo_user);
            System.out.println("수정완료");

            return ResponseEntity.ok().build();
        }
        else{
            throw new NotFoundException("아이디가 존재하지않음");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/9gic/users/myPage/edit/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Co_User> editMyPageImage(
            @RequestHeader("Authorization") String auth,
            @RequestParam("imageFile") MultipartFile imageFile) {

        String id = auth.replace("Bearer ", "");
        String identity = tokenService.verifyToken(id);
        Co_User optionalCo_user = co_userRepository.findByCoUserEmail(identity).get(0);

        storageService.store(imageFile);

        if (optionalCo_user!=null){
            Co_User user = optionalCo_user;
            user.setCoUserImageUrl(path + imageFile.getOriginalFilename());
            co_userRepository.save(user);
            System.out.println("있음");
            return ResponseEntity.ok().body(optionalCo_user);
        } else {
            System.out.println("없음");
            throw new NotFoundException("Id Not Found");
    }
}

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/9gic/users/myPage/get")
    public ResponseEntity<Co_User> getMyPage(@RequestHeader("Authorization") String auth) {
        String id = auth.replace("Bearer ", "");
        String identity = tokenService.verifyToken(id);
        Co_User optionalCo_user = co_userRepository.findByCoUserEmail(identity).get(0);

        if (optionalCo_user!=null) {
            return ResponseEntity.ok().body(optionalCo_user);
        } else {
            throw new NotFoundException("Id Not Found");
        }
    }
}
