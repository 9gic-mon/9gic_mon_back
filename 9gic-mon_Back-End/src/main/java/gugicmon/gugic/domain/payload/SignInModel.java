package gugicmon.gugic.domain.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gugicmon.gugic.domain.entity.Co_User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignInModel {
    private String coUserEmail;
    private String coUserPassword;

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
