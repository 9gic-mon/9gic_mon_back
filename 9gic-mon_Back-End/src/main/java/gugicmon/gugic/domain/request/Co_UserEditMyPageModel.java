package gugicmon.gugic.domain.request;

import org.springframework.web.multipart.MultipartFile;

public class Co_UserEditMyPageModel {

    String coUserEmail;
    String coUserPassword;
    String coUserCopname;
    String coUserTell;
    String coUserDescription;
    MultipartFile coUserImageFile;

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

    public MultipartFile getCoUserImageFile() {
        return coUserImageFile;
    }

    public void setCoUserImageFile(MultipartFile coUserImageFile) {
        this.coUserImageFile = coUserImageFile;
    }



}
