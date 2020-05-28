package com.tangwh.lambdaDemo.xinLamdba;


public class Apple {
    /**
     * 颜色
     */
    private String color;

    /**
     * 颜色
     */
    private long weight;


    public Apple() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(final long weight) {
        this.weight = weight;
    }

    public Apple(final String color, final long weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Apple{");
        sb.append("color='").append(color).append('\'');
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
