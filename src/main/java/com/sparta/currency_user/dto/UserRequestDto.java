package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserRequestDto {
    @NotNull(message="이름을 입력해 주세요.")
    private String name;

    @Email(message="이메일 형식을 확인해 주세요.")
    @NotNull(message="이메일을 입력해 주세요.")
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
