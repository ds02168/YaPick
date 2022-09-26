package com.main_39.Spring.member.dto;

import com.main_39.Spring.member.entity.Local;
import com.main_39.Spring.store.dto.StoreDto;
import com.main_39.Spring.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LocalDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank(message = "닉네임은 공백이 아니어야 합니다.")
        private String profileNickname;

        private String profileImage;

        @NotBlank(message = "이름은 공백이 아니어야 합니다.")
        private String name;

        @NotBlank
        @Email
        private String accountEmail;

        @Pattern(regexp = "^\\w{6,16}$",
                message = "비밀번호느 6자리이상 16자리 이하로 가능합니다!")
        private String localPassword;

        @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
                message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
        private String phoneNumber;
    }

    @Getter
    @AllArgsConstructor
    public static class response{
        private Long localId;
        private StoreDto.response store;
        private String profileNickname;
        private String profileImage;
        private String name;
        private String accountEmail;
        private String phoneNumber;
        private Local.Role role;
    }

    @Getter
    @AllArgsConstructor
    public static class Login{
        @NotBlank
        @Email
        private String accountEmail;

        @Pattern(regexp = "^\\w{6,16}$",
                message = "비밀번호느 6자리이상 16자리 이하로 가능합니다!")
        private String localPassword;
    }

    @Getter
    @AllArgsConstructor
    public static class postResponse{
        private String profileNickname;
        private String profileImage;
    }

    @Getter
    @AllArgsConstructor
    public static class searchIdDto{
        private String name;
        private String phoneNumber;
    }

    @Getter
    @AllArgsConstructor
    public static class searchIdResponse{
        private String localEmail;
    }

    @Getter
    @AllArgsConstructor
    public static class searchPwDto{
        private String accountEmail;
        private String name;
        private String phoneNumber;
    }

    @Getter
    @AllArgsConstructor
    public static class searchPwResponse{
        private String localPassword;
    }

}