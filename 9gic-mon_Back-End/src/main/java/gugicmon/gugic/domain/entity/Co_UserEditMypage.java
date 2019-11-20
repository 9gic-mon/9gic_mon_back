package gugicmon.gugic.domain.entity;


import org.springframework.web.multipart.MultipartFile;

public class Co_UserEditMypage {

    private String coUserEmail;
    private String coUserPassword;
    private String coUserCopname;
    private String coUserTell;
    private String coUserDescription;
    private String coUserImageUrl;

    public Co_UserEditMypage() {}

    public String getCoUserEmail() {
        return coUserEmail;
    }

    public void setCoUserEmail(String coUserEmail) {
        this.coUserEmail = coUserEmail;
    }

    public String getCoUserPassword() {
        return coUserPassword;
    }

    public void setCoUserPassword(String coUserPassword) {
        this.coUserPassword = coUserPassword;
    }

    public String getCoUserCopname() {
        return coUserCopname;
    }

    public void setCoUserCopname(String coUserCopname) {
        this.coUserCopname = coUserCopname;
    }

    public String getCoUserTell() {
        return coUserTell;
    }

    public void setCoUserTell(String coUserTell) {
        this.coUserTell = coUserTell;
    }

    public String getCoUserDescription() {
        return coUserDescription;
    }

    public void setCoUserDescription(String coUserDescription) {
        this.coUserDescription = coUserDescription;
    }

    public String getCoUserImageUrl() {
        return coUserImageUrl;
    }

    public void setCoUserImageUrl(String coUserImageUrl) {
        this.coUserImageUrl = coUserImageUrl;
    }
    public Co_User toCo_User() {
        return new Co_User(coUserPassword, coUserEmail, coUserCopname, coUserTell, coUserDescription, coUserImageUrl);
    }
}
