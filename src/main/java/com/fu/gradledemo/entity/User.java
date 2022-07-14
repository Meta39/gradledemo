package com.fu.gradledemo.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 用户ID（唯一）
     */
    private Long id;

    /**
     * 用户名（唯一）
     */
    private String name;

    /**
     * MD5密码
     */
    private String password;

    /**
     * UUID盐（前端校验ID或账号成功时返回给前端）
     */
    private String salt;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 私钥
     */
    private String privateKey;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String eMail;

    /**
     * 禁用：0否，1是
     */
    private Boolean disabled;

    /**
     * 删除：0否，1是
     */
    private Boolean deleted;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

}

