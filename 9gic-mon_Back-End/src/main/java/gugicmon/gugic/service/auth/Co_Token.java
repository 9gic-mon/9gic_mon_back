package gugicmon.gugic.service.auth;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Co_Token {
    private String token;

    public Co_Token(String token) {
        this.token = token;
    }
}