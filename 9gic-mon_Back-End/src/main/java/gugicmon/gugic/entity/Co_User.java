package gugicmon.gugic.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;

@Getter
@Setter
@Entity
@Table(name = "co_user")
public class Co_User {

    @Id
    @Column(name = "co_user_email")
    public String coUserEmail;
    @Column(name = "co_user_password")
    String coUserPassword;
    @Column(name = "co_user_copname")
    String coUserCopname;
    @Column(name = "co_user_tell")
    int coUserTell;

    public Co_User() {}

    public Co_User(String coUserPassword, String coUserEmail, String coUserCopname, int coUserTell)
    {
        this.coUserPassword = coUserPassword;
        this.coUserEmail = coUserEmail;
        this.coUserCopname = coUserCopname;
        this.coUserTell = coUserTell;
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

    public int getCoUserTell() {
        return coUserTell;
    }

    public void setCoUserTell(int coUserTell) {
        this.coUserTell = coUserTell;
    }
}