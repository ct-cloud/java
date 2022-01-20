package designpattern.construct;

/**
 * 构造者模式，又称生成器模式
 */
public class TestBuilder {
    public static void main(String [] args){
        URLBuilder urlBuilder = URLBuilder.builder().setBody("body");
        System.out.println(urlBuilder.toString());
    }
}

class URLBuilder {
    private String header;
    private String body;

    private static URLBuilder urlBuilder;
    private URLBuilder (){
    }

    public static URLBuilder builder(){
        urlBuilder = new URLBuilder();
        return urlBuilder;
    }

    public URLBuilder setBody(String body){
        this.urlBuilder.body = body;
        return urlBuilder;
    }

    public URLBuilder setHeader(String header){
        this.urlBuilder.header = header;
        return urlBuilder;
    }

    @Override
    public String toString() {
        return "URLBuilder{" +
                "header='" + header + '\'' +
                ", body='" + body +
                '}';
    }
}
