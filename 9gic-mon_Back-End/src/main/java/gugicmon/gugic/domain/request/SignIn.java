package gugicmon.gugic.domain.request;

public class SignIn {

    public String coUserEmail;

    String coUserPassword;

    public String getCoUserEmail() {
        return coUserEmail;
    }

    public String getCoUserPassword() {
        return coUserPassword;
    }

    public void setCoUserPassword(String coUserPassword) {
        this.coUserPassword = coUserPassword;
    }

    public void setCoUserEmail(String coUserEmail) {
        this.coUserEmail = coUserEmail;
    }
}
