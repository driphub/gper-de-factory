package com.pger.de.chainres.auth.builderchain;


import com.pger.de.chainres.auth.Member;

public class MemberService {

    public void login(String loginName, String loginPass) {

        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler());
//                .addHandler(new LoginHandler())
//                .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName, loginPass));
    }

}
