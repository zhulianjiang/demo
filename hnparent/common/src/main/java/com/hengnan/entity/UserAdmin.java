package com.hengnan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hn.framework.entitesBasic.IdTimeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-06 20:32
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@TableName(value = "user_admin")
public class UserAdmin extends IdTimeEntity {

    @TableField("login_id")
    @ApiModelProperty("登录id")
    private String loginId;

    @TableField("password")
    @ApiModelProperty("登录密码")
    private String passWord;

    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    @TableField("nick_name")
    private String nickName;

    @TableField("full_name")
    @ApiModelProperty("姓名")
    private String fullName;

    @TableField("age")
    @ApiModelProperty("年龄")
    private Integer age;

    @TableField("mobile")
    @ApiModelProperty("手机号")
    private String mobile;

    @TableField("status")
    private Integer status;

    @TableField("flag")
    private Integer flag;

    @TableField(exist = false)
    @ApiModelProperty("token令牌")
    private String token;

}
