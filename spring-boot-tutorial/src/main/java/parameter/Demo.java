package parameter;

public class Demo {

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("parameter.Demo{");
        sb.append("i=").append(i);
        sb.append("}");
        return sb.toString();
    }

}
