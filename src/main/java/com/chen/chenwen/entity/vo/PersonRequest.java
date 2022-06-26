package com.chen.chenwen.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @Author 范小城
 * @Date 2022-06-25 0:38
 */
@Data
public class PersonRequest {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "技能")
    @NotBlank(message = "技能不能为空！")
    private String skill;

}
