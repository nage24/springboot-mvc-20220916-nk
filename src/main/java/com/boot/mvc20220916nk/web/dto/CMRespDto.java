package com.boot.mvc20220916nk.web.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CMRespDto<T extends Object> {

    private int code; // 1 : 성공, -1 : 실패
    private String msg; // commit 메세지
    private Object data; // 응답 데이터


}
