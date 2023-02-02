package com.mysite.sbb.createStudy;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class studyForm {
    @NotEmpty(message="스터디명은 필수입니다")
    private String studyName;


    private String studyIntro;

    @NotEmpty(message="스터디규칙은 필수입니다")
    private String studyRule;
    private String mentor;
    @NotEmpty(message = "키워드1 입력해주세요")
    private String keyOne;

    @NotEmpty(message = "키워드2 입력해주세요")
    private String keyTwo;

    @NotEmpty(message = "키워드3 입력해주세요")
    private String keyThree;


}
