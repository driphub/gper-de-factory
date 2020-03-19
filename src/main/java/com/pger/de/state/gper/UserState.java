package com.pger.de.state.gper;

public abstract class UserState {
    protected AppContext context;

    public void addContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);


}
