package com.pger.de.state.gper;

public class AppContext {
    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UNLOGIN = new UnLoginState();

    private UserState currentState = STATE_UNLOGIN;

    {
        STATE_LOGIN.addContext(this);
        STATE_UNLOGIN.addContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
        this.currentState.addContext(this);
    }

    public UserState getState() {
        return this.currentState;
    }

    public void favorite() {
        this.currentState.favorite();
    }

    public void comment(String comment) {
        this.currentState.comment(comment);
    }


}
