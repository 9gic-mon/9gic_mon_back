package gugicmon.gugic.service.post;

import gugicmon.gugic.domain.entity.Co_UserPost;
import gugicmon.gugic.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    public List<Co_UserPost> findAll() {
        return (List<Co_UserPost>) postRepository.findAll();
    }

    public void delete(String coUserPostCopname) {
        String a = coUserPostCopname;
    }

    public void delete(Co_UserPost co_userPost) {
        postRepository.delete(co_userPost);
    }

 //   public findPost(int grade, int subject, int region){
 //       return postRepository.findByGradeAndSubjectAndRegion(grade, subject, region);
 //   }
}

