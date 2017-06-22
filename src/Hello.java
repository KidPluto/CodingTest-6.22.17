/**
 * Created by Chris on 6/19/2017.
 */
public class Hello {

    private String str;

    public Hello() {
    }

    public Hello(String Parm01) {
        str = Parm01;
    }

    @Override
    public String toString() {
        return "Hello " + str;
    }
}
