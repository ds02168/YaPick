package com.main_39.Spring.member.mapper;

import com.main_39.Spring.member.dto.KakaoDto;
import com.main_39.Spring.member.dto.KakaoProfile;
import com.main_39.Spring.member.dto.LocalDto;
import com.main_39.Spring.member.dto.OAuthToken;
import com.main_39.Spring.member.entity.Kakao;
import com.main_39.Spring.member.entity.Local;
import com.main_39.Spring.store.dto.StoreDto;
import com.main_39.Spring.store.entity.Store;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface MemberMapper {

    Local localPostToLocal(LocalDto.Post localPost);
    LocalDto.postResponse localToLocalPostResponse(Local local);
    default LocalDto.response localToLocalDtoResponse(Local local){
        Store store = local.getStore();
        StoreDto.response storeResponse = new StoreDto.response(
                store.getStoreId(), store.getStorePhone(), store.getStoreNumber(), store.getStoreName(), store.getStoreContent(), store.getStoreImage(),
                store.getStoreType(),store.getStoreStatus()
        );
        LocalDto.response response = new LocalDto.response(
                local.getLocalId(),storeResponse,local.getProfileNickname(),local.getProfileImage(),local.getName(),local.getAccountEmail(),local.getPhoneNumber(),
                local.getRole()
        );
        return response;
    }
    default Kakao kakaoProfileToKakao(KakaoProfile kakaoProfile, OAuthToken oAuthToken){
        return Kakao.builder()
                .kakaoId(kakaoProfile.getId())
                .nickname(kakaoProfile.getProperties().getNickname())
                .connectedAt(kakaoProfile.getConnected_at())
                .profileImage(kakaoProfile.getProperties().getProfile_image())
                .thumbnailImage(kakaoProfile.getProperties().getThumbnail_image())
                .email(kakaoProfile.getKakao_account().getEmail())
                .refreshToken(oAuthToken.getRefresh_token())
                .build();
    }

    KakaoDto.response kakaoToKakaoDtoResponse(Kakao kakao);

    default LocalDto.searchIdResponse localToLocalDtoSearchIdResponse(Local local){
        return new LocalDto.searchIdResponse(local.getAccountEmail());
    }
    default LocalDto.searchPwResponse localToLocalDtoSearchPwResponse(Local local){
        return new LocalDto.searchPwResponse(local.getLocalPassword());
    }

    KakaoDto.mileageDto kakaoToKakaoDtoMileage(Kakao kakao);
}