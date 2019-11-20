package gugicmon.gugic.domain.entity;

/*
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "co_user_post")
public class Co_UserPost {


    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @json
    public Long idx;

    @Column(name = "title")
    String title;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "dead_line")
    Date deadLine;

    @OneToOne
    @JoinColumn(name = "co_user_post_copname", referencedColumnName = "co_user_copname")
    String coUserPostCopname;

    @OneToOne
    @JoinColumn(name = "co_user_imageurl", referencedColumnName = "co_user_post_imageurl")
    String coUserPostImageUrl;

    @Column(name = "simple_intro")
    String simpleIntro;

    @Column(name = "context")
    String context;

    @Column(name = "main_work")
    String mainWork;

    @Column(name = "main_work_stack")
    String mainWorkStack;

    @Column(name = "welfare")
    String welfare;

    @Column(name = "etc")
    String etc;

}
*/