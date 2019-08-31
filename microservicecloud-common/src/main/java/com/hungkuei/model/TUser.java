package com.hungkuei.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TUser {

    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户性别
     */
    private Integer sex;

}
