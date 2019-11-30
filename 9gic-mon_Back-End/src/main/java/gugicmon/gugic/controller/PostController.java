package gugicmon.gugic.controller;

import gugicmon.gugic.domain.entity.Co_User;
import gugicmon.gugic.domain.entity.Co_UserPost;
import gugicmon.gugic.domain.request.PostModel;
import gugicmon.gugic.exception.ForbiddenException;
import gugicmon.gugic.exception.NotFoundException;
import gugicmon.gugic.exception.PostNotFoundException;
import gugicmon.gugic.repository.Co_UserRepository;
import gugicmon.gugic.repository.PostRepository;
import gugicmon.gugic.service.post.PostService;
import gugicmon.gugic.service.post.PostServiceImpl;
import gugicmon.gugic.service.storage.StorageServiceImpl;
import gugicmon.gugic.service.token.TokenService;
import org.dom4j.tree.AbstractCDATA;
import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceManyToAny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.PartTreeJpaQuery;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private String path = "http://10.156.145.140:8080/static/";
    @Autowired
    TokenService tokenService;

    @Autowired
    StorageServiceImpl storageService;

    @Autowired
    Co_UserRepository co_userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostServiceImpl postService;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "9gic/users/post/{coUserPostCopname}" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Co_UserPost> writePost(@PathVariable("coUserPostCopname") String coUserPostCopname,
                                                 @RequestHeader("Authorization") String auth,
                                                 @ModelAttribute PostModel post){

        String id = auth.replace("Bearer ", "");

        String identity = tokenService.verifyToken(id);
        Co_User optionalCo_user = co_userRepository.findByCoUserEmail(identity).get(0);

        storageService.store(post.getCoUserPostImagefile());
        storageService.store(post.getBackgroundImagefile());

        if (optionalCo_user!=null){
            Co_UserPost co_userPost = new Co_UserPost(
                    post.getTitle(),
                    post.getDeadLine(),
                    post.getCoUserPostCopname(),
                    path + post.getCoUserPostImagefile().getOriginalFilename(),
                    post.getSimpleIntro(),
                    post.getContext(),
                    post.getMainWork(),
                    post.getMainWorkStack(),
                    post.getWelfare(),
                    post.getEtc(),
                    path+ post.getBackgroundImagefile().getOriginalFilename(),
                    post.getGrade(),
                    post.getSubject(),
                    post.getRegion()
            );

            postRepository.save(co_userPost);
            System.out.println("성공");

            return ResponseEntity.ok().build();
        }
        else {
            throw new ForbiddenException();
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "9gic/users/post/get")
    public @ResponseBody List<Co_UserPost> findAll(){
        List<Co_UserPost> postLists = postService.findAll();
        System.out.println("들어오는거 확인");
        return postLists;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "9gic/users/post/{coUserPostCopname}/{idx}/delete")
    public ResponseEntity<Co_UserPost> postDelete(
            @PathVariable("coUserPostCopname") String coUserPostCopname,
            @PathVariable("idx") Long idx,
            @RequestHeader("Authorization") String auth) {

        String id = auth.replace("Bearer ", "");

        String identity = tokenService.verifyToken(id);

        Co_UserPost post = postRepository.findBycoUserPostCopname(coUserPostCopname);

        if (post == null){
            throw new NotFoundException("게시글을 찾을 수 없어요");
        } else if (post != null){
            postService.delete(post);
            System.out.println("삭제성공");
            return ResponseEntity.ok().build();
        } else {
            System.out.println("삭제 실패");
            throw new ForbiddenException();
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "9gic/users/post/filter")
    public ResponseEntity<List<Co_UserPost>> PostFilter(
            @RequestParam("grade") int grade,
            @RequestParam("subject") String subject,
            @RequestParam("region") String region,
            @RequestParam("filtering") String filtering){


        List<Co_UserPost> userPost;
        List<Co_UserPost> userPostList = new ArrayList<>();

        if(grade == 0 && subject.equals("0") && region.equals("0")){
            System.out.println("모두 0일때");
            userPost = postRepository.findByGradeIdAndSubjectIdAndRegionId(0, "0", "0");

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }
        else if(grade == 0 && subject.equals("0")){
            System.out.println("학년, 학과가 0일때");
            userPost = postRepository.findByGradeIdAndSubjectIdAndRegion(0, "0", region);

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }
        else if(grade == 0 && region.equals("0")){
            System.out.println("학년, 지역이 0일때");
            userPost = postRepository.findByGradeIdAndSubjectAndRegionId(0, subject, "0");

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }
        else if(subject.equals("0") & region.equals("0")){
            System.out.println("학과, 지역이 0일때");
            userPost = postRepository.findByGradeAndSubjectIdAndRegionId(grade, "0", "0");

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }
        else if(grade == 0){
            System.out.println("학녀만 0일때");
            userPost = postRepository.findByGradeIdAndSubjectAndRegion(0, subject, region);

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }
        else if(subject.equals("0")){
            System.out.println("학과만 0일때");
            userPost = postRepository.findByGradeAndSubjectIdAndRegion(grade, "0", region);

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }
        else if(region.equals("0")){
            System.out.println("지역이 0일때");
            userPost = postRepository.findByGradeAndSubjectAndRegionId(grade, subject, "0");

            if (filtering.equals("")){
                return ResponseEntity.ok().body(userPost);
            }

            for(Co_UserPost post : userPost) {
                if(post.getTitle().contains(filtering) || post.getCoUserPostCopname().contains(filtering)) {
                    userPostList.add(post);
                }
            }

            if(userPostList.isEmpty()) {
                throw new PostNotFoundException("검색결과가 존재하지 않아요");
            }
            else{
                return ResponseEntity.ok().body(userPostList);
            }

        }


        return ResponseEntity.ok().body(userPostList);

    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "9gic/users/post/image" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Co_UserPost> postImage(
            @RequestHeader("Authorization") String auth,
            @RequestParam("imageFile") MultipartFile imageFile,
            @RequestParam("backgroundImageFile") MultipartFile backgroundImage){

        String id = auth.replace("Bearer ", "");

        String identity = tokenService.verifyToken(id);
        Co_User optionalCo_user = co_userRepository.findByCoUserEmail(identity).get(0);

        Co_UserPost co_userPost = new Co_UserPost();

        storageService.store(imageFile);
        storageService.store(backgroundImage);

        if (optionalCo_user!=null){
            co_userPost.setCoUserPostImageUrl(path+ imageFile.getOriginalFilename());
            co_userPost.setCoUserPostImageUrl(path+ imageFile.getOriginalFilename());

            postRepository.save(co_userPost);

            return ResponseEntity.ok().body(co_userPost);
        } else {
            throw new NotFoundException("Id Not Found");
        }
    }
}
