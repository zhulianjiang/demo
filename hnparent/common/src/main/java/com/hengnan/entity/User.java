package com.hengnan.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-02 14:46
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@Table(name = "user")
public class User {

    @Column(name = "id")
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "name")
    @ApiModelProperty("名称")
    private String name;

    @Column(name = "age")
    @ApiModelProperty("年龄")
    private Integer age;

}
