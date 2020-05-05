package com.pger.collections;

import java.io.*;

public class User implements Serializable {
    private String name;

    private transient String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User  deepClone() {
        try {
            // 序列化：写
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            // 反序列化：读
            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            User user = (User) ois.readObject();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(sex);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        sex = (String) ois.readObject();
    }


}
