package com.pger.de.strategy.userlogin;


public abstract class Handler<T> {
    protected Handler next;

    public void next(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(String userId);

    public static class Builder<T> {
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler handler) {
            do {
                if (this.head == null) {
                    this.head = this.tail = handler;
                    return this;
                }
                this.tail.next(handler);
                this.tail = handler;
            } while (false);
            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }

}
