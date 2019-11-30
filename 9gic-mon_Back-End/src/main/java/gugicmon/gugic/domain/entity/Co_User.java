package gugicmon.gugic.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.CustomLog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "co_user")
public class Co_User {

    @Id
    @JsonIgnore
    @Column(name = "co_user_id")
    public String coUserId = UUID.randomUUID().toString();

    @Column(name = "co_user_email", unique = true)
    public String coUserEmail;

    @Column(name = "co_user_password", nullable = false)
    String coUserPassword;

//    @OneToOne(mappedBy = "co_user_post_copname", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY)
    @Column(name = "co_user_copname")
    String coUserCopname;

    @Column(name = "co_user_tell")
    String coUserTell;

    @Column(name = "co_user_description")
    String coUserDescription;

    @Column(name = "co_user_image_url")
    String coUserImageUrl;

    @Column(name = "co_user_establish")
    String coUserEstablish;

    @Column(name = "co_user_member")
    String coUserMember;

    @Column(name = "co_user_capital")
    String coUserCapital;

    @Column(name = "co_user_address")
    String coUserAddress;

    @Column(name = "co_user_military")
    String coUserMilitary;

    @Column(name = "co_user_place")
    String coUserPlace;


    public Co_User() {}

    public Co_User(String coUserId, String coUserEmail, String coUserPassword, String coUserCopname, String coUserTell, String coUserDescription, String coUserImageUrl, String coUserEstablish, String coUserMember, String coUserCapital, String coUserAddress, String coUserMilitary, String coUserPlace) {
        this.coUserId = coUserId;
        this.coUserEmail = coUserEmail;
        this.coUserPassword = coUserPassword;
        this.coUserCopname = coUserCopname;
        this.coUserTell = coUserTell;
        this.coUserDescription = coUserDescription;
        this.coUserImageUrl = coUserImageUrl;
        this.coUserEstablish = coUserEstablish;
        this.coUserMember = coUserMember;
        this.coUserCapital = coUserCapital;
        this.coUserAddress = coUserAddress;
        this.coUserMilitary = coUserMilitary;
        this.coUserPlace = coUserPlace;
    }

    public Co_User(String coUserId, String coUserPassword, String coUserEmail, String coUserCopname, String coUserTell, String coUserDescription, String coUserImageUrl)
    {
        this.coUserId = coUserId;
        this.coUserPassword = coUserPassword;
        this.coUserEmail = coUserEmail;
        this.coUserCopname = coUserCopname;
        this.coUserTell = coUserTell;
        this.coUserDescription = coUserDescription;
        this.coUserImageUrl = coUserImageUrl;
    }

    public String getCoUserId() {
        return coUserId;
    }

    public void setCoUserId(String coUserId) {
        this.coUserId = coUserId;
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

    public String getCoUserEstablish() {
        return coUserEstablish;
    }

    public void setCoUserEstablish(String coUserEstablish) {
        this.coUserEstablish = coUserEstablish;
    }

    public String getCoUserMember() {
        return coUserMember;
    }

    public void setCoUserMember(String coUserMember) {
        this.coUserMember = coUserMember;
    }

    public String getCoUserCapital() {
        return coUserCapital;
    }

    public void setCoUserCapital(String coUserCapital) {
        this.coUserCapital = coUserCapital;
    }

    public String getCoUserAddress() {
        return coUserAddress;
    }

    public void setCoUserAddress(String coUserAddress) {
        this.coUserAddress = coUserAddress;
    }

    public String isCoUserMilitary() {
        return coUserMilitary;
    }

    public void setCoUserMilitary(String coUserMilitary) {
        this.coUserMilitary = coUserMilitary;
    }

    public String getCoUserPlace() {
        return coUserPlace;
    }

    public void setCoUserPlace(String coUserPlace) {
        this.coUserPlace = coUserPlace;
    }
}