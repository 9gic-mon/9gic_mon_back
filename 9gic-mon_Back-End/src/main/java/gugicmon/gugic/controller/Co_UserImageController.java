package gugicmon.gugic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Co_UserImageController {


    private final String UPLOAD_ROOT = "src/main/resources/static/";

    @Autowired
    ResourceLoader resourceLoader;

    @GetMapping(value = "/9gic/users/image/{coUserImageUri}/", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity getImage(@PathVariable("coUserImageUri") String filename){
        System.out.println("사진이얌");
        return ResponseEntity.ok(resourceLoader.getResource("file:" + UPLOAD_ROOT + filename));
    }
}
