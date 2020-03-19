package com.pger.de.state.gper;

public class GperTest {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("评论：好文章！！");
    }
}
