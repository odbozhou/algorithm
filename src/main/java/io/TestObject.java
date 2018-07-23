package io;

import java.io.Serializable;

/**
 * 测试类
 *
 * @author zhoubo
 * @create 2018-07-23 11:26
 */
public class TestObject implements Serializable {

    private static final long serialVersionUID = -2558953765389122654L;
    private Integer id;
    private String name;
    private Integer age;
//    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
}
