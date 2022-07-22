package mate.academy.model.dto;

import javax.validation.constraints.NotBlank;

public class UserLoginDto {
    @NotBlank(message = "Login can't be null of blank!")
    private String email;
    @NotBlank(message = "Password can't be null or blank!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
