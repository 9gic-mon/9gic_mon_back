package gugicmon.gugic.domain.entity;


import gugicmon.gugic.domain.entity.Co_User;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


public class Co_UserEditMypage {

    private String coUserID;
    private String coUserEmail;
    private String coUserPassword;
    private String coUserCopname;
    private String coUserTell;
    private String coUserDescription;
    private String coUserImageUrl;
    private String coUserEstablish;
    private String coUserMember;
    private String coUserCapital;
    private String coUserAddress;
    private String coUserMilitary;
    private String coUserPlace;

    public Co_UserEditMypage() {}

    public String getCoUserID() {
        return coUserID;
    }

    public void setCoUserID(String coUserID) {
        this.coUserID = coUserID;
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

    public String getCoUserMilitary() {
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

    public Co_User toCo_User() {
        return new Co_User(coUserID, coUserPassword, coUserEmail, coUserCopname, coUserTell, coUserDescription, coUserImageUrl, coUserEstablish, coUserMember, coUserCapital, coUserAddress, coUserMilitary, coUserPlace);
    }
}
