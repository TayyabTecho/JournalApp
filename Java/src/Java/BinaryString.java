package Java;

public class BinaryString {
    public static void main(String[] args) {

        //decimal to binary
        int i=9;
        String j=Integer.toBinaryString(i);
        System.out.println(j);

    //binary to decimm
        String s="1001";
        int k=Integer.parseInt(s,2);
        //radix or base=2 y smjhna pdega
        System.out.println(k);

        // left shift <<
        int d=4 << 1 ;
        System.out.println(d);
        //yha hm c k binary ko 1 se peeche krrhe hain

        //only line print
        System.out.println();

        //next line ka bhi isee line me print hoga
        //System.out.print();
        //System.out.printf();
int a=1;
int b=2;
String c="sum";
        System.out.printf("%s of %d & %d: %d", c, a, b, a+b);
        System.out.println();
        String sss="mohd";
         String ss="ati";
        System.out.println(ss.concat(sss));

        //random nr:'
int l=(int)(Math.random()*1000);
        System.out.println(i);
         }



}
