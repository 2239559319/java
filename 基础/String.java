import java.util.Scanner;

public class Test1 {
    public static void main(String[] args){
        String a="Hello World",b="";
        //字符串输入
        Scanner input=new Scanner(System.in);
        String c=input.next();      //next()读取空白结束的字符串，读取以回车结束的用input.nextLine()
        System.out.println(c);

        System.out.println(a.charAt(2));        //取字符
        System.out.println(a.length());         //取长度
        System.out.println(a.isEmpty());        //判断非空
        System.out.println(b.isEmpty());        //同上
        System.out.println(a.equals(b));        //比较返回boolen
        System.out.println(a.toLowerCase());    //转换成小写
        System.out.println(a.concat(c));        //连接两个字符串，也可以用+
        System.out.println(a.compareTo(c));     //返回一个大于小于等于0的整数
        System.out.println(a.startsWith("H"));  //以特定前缀开始，返回true,同样的函数还有endsWith()
        System.out.println(a.contains("Hello"));//参数是字符串的子串返回true
        System.out.println(a.substring(4));     //返回子串起始位置到结尾，参数是起始位置
        System.out.println(a.substring(2,5));//返回两个参数中间的子串
        System.out.println(a.indexOf("l"));     /*返回字符串中第一个出现参数的下标，没有匹配返回-1,
        参数也可以是字符串*/
        int d=Integer.parseInt(c);              //字符串转换成数字
        System.out.println(d);
        String e=14124+"";
        System.out.println(e);                  //数字转换成字符串
    }
}
