package com.clausene.outpatien.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Clausene
 * @Title: CommontResult
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/2 16:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    /***
     * @author Clausene
     * @date 2022/10/2 16:44
     * @Description: 声明只有返回编码和描述的构造函数
     * @param: code
     * @param: message
     * @return
     */
    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
