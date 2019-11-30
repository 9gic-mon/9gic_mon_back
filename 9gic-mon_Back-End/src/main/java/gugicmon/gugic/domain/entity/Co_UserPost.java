package gugicmon.gugic.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Cleanup;
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

    @Column(name = "dead_line")
    String deadLine;

    @Column(name = "co_user_post_copname")
    String coUserPostCopname;

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

    @Column(name = "background_image_url")
    String backgroundImageUrl;

    @Column(name = "grade")
    int grade;

    @Column(name = "subject")
    String subject;

    @Column(name = "region")
    String region;

    @JsonIgnore
    @Column(name = "grade_id")
    int gradeId = 0;

    @JsonIgnore
    @Column(name = "subject_id")
    String subjectId = "0";

    @JsonIgnore
    @Column(name = "region_id")
    String regionId = "0";

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getCoUserPostCopname() {
        return coUserPostCopname;
    }

    public void setCoUserPostCopname(String coUserPostCopname) {
        this.coUserPostCopname = coUserPostCopname;
    }

    public String getCoUserPostImageUrl() {
        return coUserPostImageUrl;
    }

    public void setCoUserPostImageUrl(String coUserPostImageUrl) {
        this.coUserPostImageUrl = coUserPostImageUrl;
    }

    public String getSimpleIntro() {
        return simpleIntro;
    }

    public void setSimpleIntro(String simpleIntro) {
        this.simpleIntro = simpleIntro;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getMainWork() {
        return mainWork;
    }

    public void setMainWork(String mainWork) {
        this.mainWork = mainWork;
    }

    public String getMainWorkStack() {
        return mainWorkStack;
    }

    public void setMainWorkStack(String mainWorkStack) {
        this.mainWorkStack = mainWorkStack;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImage) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Co_UserPost() {
        super();
    }

    public Co_UserPost(String title, String deadLine, String coUserPostCopname, String coUserPostImageUrl, String simpleIntro, String context, String mainWork, String mainWorkStack, String welfare, String etc, String backgroundImageUrl, int grade, String subject, String region) {
        super();
        this.title = title;
        this.deadLine = deadLine;
        this.coUserPostCopname = coUserPostCopname;
        this.coUserPostImageUrl = coUserPostImageUrl;
        this.simpleIntro = simpleIntro;
        this.context = context;
        this.mainWork = mainWork;
        this.mainWorkStack = mainWorkStack;
        this.welfare = welfare;
        this.etc = etc;
        this.backgroundImageUrl = backgroundImageUrl;
        this.grade = grade;
        this.subject = subject;
        this.region = region;
    }

    public int getGradeId() {
        return gradeId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getRegionId() {
        return regionId;
    }
}