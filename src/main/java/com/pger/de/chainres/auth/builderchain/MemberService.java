package com.pger.de.chainres.auth.builderchain;


import com.pger.de.chainres.auth.Member;

/**
 * Created by Tom.
 */
public class MemberService {

    public void login(String loginName, String loginPass) {

        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler());
//                .addHandler(new LoginHandler())
//                .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName, loginPass));


        //用过Netty的人，肯定见过
    }

}
