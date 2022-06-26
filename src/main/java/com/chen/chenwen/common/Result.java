package com.chen.chenwen.common;

import com.chen.chenwen.common.constant.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value="Response对象", description="全局统一返回结果")
public class Result implements Serializable {
    @ApiModelProperty(value = "是否成功")
    private Boolean flag;

    @ApiModelProperty(value = "状态码")
    private String code;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private List<Object> data = new ArrayList<>();

    private Result(){}

    private Result(Boolean flag, String code, String message){
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    /**
     * 请求成功并有数据
     */
    public static Result ok(Object value){
        Result result = new Result(ResultCodeEnum.SUCCESS.getFlag(),
                ResultCodeEnum.SUCCESS.getCode(),
                ResultCodeEnum.SUCCESS.getMessage());
                result.data(value);
                return result;
    }

    /**
     * 请求成功没数据
     */
    public static Result ok(){
        return new Result(ResultCodeEnum.SUCCESS.getFlag(),
                ResultCodeEnum.SUCCESS.getCode(),
                ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 请求失败
     */
    public static Result fail(){
        return new Result(ResultCodeEnum.FAIL.getFlag(),
                ResultCodeEnum.FAIL.getCode(),
                ResultCodeEnum.FAIL.getMessage());
    }

    /**
     * 系统异常
     */
    public static Result error(){
        return new Result(ResultCodeEnum.ERROR.getFlag(),
                ResultCodeEnum.ERROR.getCode(),
                ResultCodeEnum.ERROR.getMessage());
    }

    public Result data(List<Object> data){
        this.setData(data);
        return this;
    }
    public Result data(Object value){
        this.data.add(value);
        return this;
    }
    public Result message(String message){
        this.setMessage(message);
        return this;
    }
    public Result flag(Boolean flag){
        this.setFlag(flag);
        return this;
    }
    public Result code(String code){
        this.setCode(code);
        return this;
    }
}
