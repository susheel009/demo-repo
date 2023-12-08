import java.sql.SQLOutput;

class Test
{
    Test m1()
    {
        System.out.println("m1 method");
        Test t=new Test();
        return t;
    }
    Test m2()
    {
        Test t2=new Test();
        System.out.println("m2 method");
        t2.m1();
        return this;
    }
    public static void main(String[] args)
    {
        Test t1=new Test();
        t1.m1();
        t1.m2();
    }
}