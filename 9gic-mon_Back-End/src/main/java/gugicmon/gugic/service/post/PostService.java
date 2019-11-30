package gugicmon.gugic.service.post;

import gugicmon.gugic.domain.entity.Co_UserPost;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    public List<Co_UserPost> findAll();

    public void delete(String coUserPostCopname);

    public void delete(Co_UserPost co_userPost);

    //public findPost
}