package com.mysite.sbb.createId;

import lombok.Getter;


@Getter
public enum loginRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    loginRole(String value) {
        this.value = value;
    }

    private String value;
}
