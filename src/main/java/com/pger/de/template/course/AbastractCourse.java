package com.pger.de.template.course;

public abstract class AbastractCourse {

    public final void createCourse() {
        postPreResource();

        createPpt();

        liveVideo();

        postResource();

        postHomework();

        if (needCheckHomework()) {
            checkHomework();
        }
    }

    // 钩子方法
    protected boolean needCheckHomework() {
        return false;
    }

    protected abstract void checkHomework();

    protected void postPreResource() {
        System.out.printf("发布预习资料");
    }

    protected void createPpt() {
        System.out.printf("制作课件");
    }

    protected void liveVideo() {
        System.out.printf("直播授课");
    }

    protected void postHomework() {
        System.out.printf("布置作业");
    }

    protected void postResource() {
        System.out.printf("上传课后资料");
    }

}
