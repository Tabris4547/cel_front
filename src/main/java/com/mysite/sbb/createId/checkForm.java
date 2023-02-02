package com.mysite.sbb.createId;


import java.lang.Integer;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class checkForm {

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String oldpassword;


}
