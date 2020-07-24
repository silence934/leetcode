package xyz.nyist.entity;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/24 18:13
 */
public class Element {
    private int point;
    private int length;

    public Element(int point, int length) {
        this.point = point;
        this.length = length;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Element{" +
                "point=" + point +
                ", length=" + length +
                '}';
    }
}
