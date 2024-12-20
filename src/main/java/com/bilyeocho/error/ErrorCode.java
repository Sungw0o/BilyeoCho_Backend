package com.bilyeocho.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),
    MISSING_USER_ID(HttpStatus.BAD_REQUEST, "사용자 ID는 공백일 수 없습니다."),
    MISSING_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호는 공백일 수 없습니다."),
    MISSING_USER_NAME(HttpStatus.BAD_REQUEST, "사용자 이름이 누락되었습니다"),
    MISMATCHED_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다"),
    MISSING_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "리프레시 토큰이 누락되었습니다"),
    MISSING_ITEM_NAME(HttpStatus.BAD_REQUEST, "아이템 이름은 공백일 수 없습니다."),
    MISSING_ITEM_CATEGORY(HttpStatus.BAD_REQUEST, "아이템 카테고리는 공백일 수 없습니다."),
    MISSING_ITEM_PHOTO(HttpStatus.BAD_REQUEST, "아이템 사진은 필수입니다."),
    MISSING_ITEM_DESCRIPTION(HttpStatus.BAD_REQUEST, "아이템 설명은 공백일 수 없습니다."),
    MISSING_ITEM_PRICE(HttpStatus.BAD_REQUEST, "아이템 가격은 공백일 수 없습니다."),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "존재하지 않는 Id입니다"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다"),

    /* 403 FORBIDDEN : 권한이 없는 사용자 */
    FORBIDDEN(HttpStatus.FORBIDDEN, "권한이 없습니다"),
    FORBIDDEN_RENT_ACCESS(HttpStatus.FORBIDDEN, "이 사용자는 해당 물품을 대여하지 않았습니다."),
    FORBIDDEN_ADMIN_ACCESS(HttpStatus.FORBIDDEN, "관리자 권한이 없습니다."),


    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "물품을 찾을 수 없습니다"),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "리뷰를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다"),
    RENT_NOT_FOUND(HttpStatus.NOT_FOUND, "대여 정보를 찾을 수 없습니다"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "파일이 존재하지 않습니다"),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    ALREADY_EXIST_MEMBER(HttpStatus.CONFLICT, "이미 존재하는 Id입니다"),
    ALREADY_RENTED(HttpStatus.CONFLICT, "해당 물품은 이미 대여 중입니다"),

    /* 500 INTERNAL_SERVER_ERROR : 서버오류 */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류");

    private final HttpStatus httpStatus;
    private final String detail;

}
