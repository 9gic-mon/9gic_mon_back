package gugicmon.gugic.domain.request;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.util.Date;

public class PostModel {

    String title;

    String deadLine;

    String coUserPostCopname;

    MultipartFile coUserPostImagefile;

    String simpleIntro;

    String context;

    String mainWork;

    String mainWorkStack;

    String welfare;

    String etc;

    MultipartFile backgroundImagefile;

    int grade;

    String subject;

    String region;

    int gradeId = 0;

    String subjectId = "0";

    String regionId = "0";

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

    public MultipartFile getCoUserPostImagefile() {
        return coUserPostImagefile;
    }

    public void setCoUserPostImagefile(MultipartFile coUserPostImagefile) {
        this.coUserPostImagefile = coUserPostImagefile;
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

    public MultipartFile getBackgroundImagefile() {
        return backgroundImagefile;
    }

    public void setBackgroundImagefile(MultipartFile backgroundImagefile) {
        this.backgroundImagefile = backgroundImagefile;
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

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}
