package xyz.nyist.entity;


import java.io.Serializable;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2019/11/19 18:36
 */
public class DateTest implements Serializable {

    private Integer id;

    private String name;

    private int a;

    public DateTest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "DateTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    
}
