package gugicmon.gugic.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "co_user_post")
public class Co_UserPost {


    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Long idx;

    @Column(name = "title")
    String title;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "dead_line")
    Date deadLine;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "co_user_post_copname", referencedColumnName = "co_user_copname")
    @Column(name = "co_user_post_copname")
    String coUserPostCopname;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "co_user_image_url", referencedColumnName = "co_user_post_imageurl")
    @Column(name = "co_user_post_image_url")
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