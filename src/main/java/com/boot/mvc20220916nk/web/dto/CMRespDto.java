package com.boot.mvc20220916nk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CMRespDto<T> {

    private int code; // 1 : 성공, -1 : 실패
    private String msg; // commit 메세지
    private T data; // 응답 데이터


}
