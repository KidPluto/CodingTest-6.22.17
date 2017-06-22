import java.io.File;

public class Main {

    public static void main(String[] args) {
        // System.out.println("Hello World!");

        Hello hello = new Hello("kidpluto dot net");
        System.out.println( hello.toString());

//        System.out.println(new File("."));

        CreatePigLatin cpl = new CreatePigLatin();
        cpl.Translate();
    }
}
