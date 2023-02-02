package com.mysite.sbb.createId;
import java.lang.Integer;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class CreateIdForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;


    @NotEmpty(message = "직업은 필수항목입니다.")
    private String career;
    @NotEmpty(message = "성별은 필수항목입니다.")
    private String gender;
    @NotNull(message = "나이는 필수항목입니다.")
    private Integer age;


}
