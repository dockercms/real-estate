package com.ztuo.modules.house.vo;

import lombok.Data;

/**
 * @Description:
 * @Author: GuoShuai
 * @Date: 2020/3/10 10:22 上午
 */
@Data
public class UserInfoVO {

    /**
     * 昵称
     * This field corresponds to the database column estate_user.nickname
     *
     * @date 2020-02-11 10:05:12
     */
    private String nickname;

    /**
     * 头像地址
     * This field corresponds to the database column estate_user.avatar_url
     *
     * @date 2020-02-11 10:05:12
     */
    private String avatarUrl;
}
