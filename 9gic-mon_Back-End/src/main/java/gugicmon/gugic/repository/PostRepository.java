package gugicmon.gugic.repository;

import gugicmon.gugic.domain.entity.Co_User;
import gugicmon.gugic.domain.entity.Co_UserPost;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Co_UserPost, Long>, JpaSpecificationExecutor<Co_UserPost> {
    Co_UserPost findBycoUserPostCopname(String coUserPostCopname);

    List<Co_UserPost> findByGradeAndSubjectAndRegion(int grade, String subject, String region);

    List<Co_UserPost> findByGradeIdAndSubjectAndRegion(int gradeId, String subject, String region);

    List<Co_UserPost> findByGradeAndSubjectIdAndRegion(int grade, String subjectId, String region);

    List<Co_UserPost> findByGradeAndSubjectAndRegionId(int grade, String subject, String regionId);

    List<Co_UserPost> findByGradeAndSubjectIdAndRegionId(int grade, String subjectId, String regionId);

    List<Co_UserPost> findByGradeIdAndSubjectAndRegionId(int gradeId, String subject, String regionId);

    List<Co_UserPost> findByGradeIdAndSubjectIdAndRegion(int greadeId, String subjectId, String region);

    List<Co_UserPost> findByGradeIdAndSubjectIdAndRegionId(int gradeId, String subjectId, String regionId);

}
