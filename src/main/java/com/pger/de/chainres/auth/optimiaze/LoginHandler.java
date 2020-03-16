package com.pger.de.chainres.auth.optimiaze;

import com.pger.de.chainres.auth.Member;

/**
 */
public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
