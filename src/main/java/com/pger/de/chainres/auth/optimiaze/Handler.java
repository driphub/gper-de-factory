package com.pger.de.chainres.auth.optimiaze;

import com.pger.de.chainres.auth.Member;

/**
 * Created by Tom.
 */
public abstract class Handler {
    protected Handler next;
    public void next(Handler next){ this.next = next;}

    public abstract void doHandler(Member member);
}
