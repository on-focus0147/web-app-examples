package on.focus0147.model;

public class FullPaths {
    public static final String BASE_URI = "http://localhost:8888/";

    public static final String HELLO_WORLD1 = BASE_URI + "hello";
    public static final String HELLO_WORLD2 = BASE_URI + "hello/Garry";
    public static final String HELLO_WORLD3 = BASE_URI + "hello/low/garry";
    public static final String HELLO_WORLD4 = BASE_URI + "hello/query?name=Ron";

    public static final String SIMPLE_SEND1 = BASE_URI + "res/fis";
    public static final String SIMPLE_SEND2 = BASE_URI + "res/view";

    public static final String DI1 = BASE_URI + "message";

    public static final String VAL1 = BASE_URI + "valid/q";

    public String getHelloWorld1(){
        return HELLO_WORLD1;
    }

    public String getHelloWorld2(){
        return HELLO_WORLD2;
    }

    public String getHelloWorld3(){
        return HELLO_WORLD3;
    }

    public String getHelloWorld4(){
        return HELLO_WORLD4;
    }

    public String getSimpleSend1(){
        return SIMPLE_SEND1;
    }

    public String getSimpleSend2(){
        return SIMPLE_SEND2;
    }

    public String getDi1(){
        return DI1;
    }

    public String getVal1(){return VAL1;}

}
