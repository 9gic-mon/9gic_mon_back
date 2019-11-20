package gugicmon.gugic.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@Entity
@Table(name = "co_user")
public class Co_User {

    @Id
    @Column(name = "co_user_email")
    public String coUserEmail;

    @Column(name = "co_user_password", nullable = false)
    String coUserPassword;

    @Column(name = "co_user_copname")
    String coUserCopname;

    @Column(name = "co_user_tell")
    String coUserTell;

    @Column(name = "co_user_description")
    String coUserDescription;

    @Column(name = "co_user_image_url")
    String coUserImageUrl;


    public Co_User() {}

    public Co_User(String coUserPassword, String coUserEmail, String coUserCopname, String coUserTell, String coUserDescription, String coUserImageUrl)
    {
        this.coUserPassword = coUserPassword;
        this.coUserEmail = coUserEmail;
        this.coUserCopname = coUserCopname;
        this.coUserTell = coUserTell;
        this.coUserDescription = coUserDescription;
        this.coUserImageUrl = coUserImageUrl;
    }

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
}