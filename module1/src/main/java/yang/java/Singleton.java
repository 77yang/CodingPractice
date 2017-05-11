package yang.java;

/**
 * Created by Dev_yang on 2017/5/11.
 */
public class Singleton {
/**
 * 今天笔试写单例忽视的问题
 * 1.构造器忘记private
 * 2.getSingleton()方法忘记加static修饰
 * 3.双重锁检查没有写出来（在jdk1.5版本前，双重检查锁形式的单例模式是无法保证线程安全的。）
 * */

    private Singleton(){}
/*
    private  Singleton singleton=new Singleton();
    public static Singleton getSingleton1(){
        return  singleton;
    }
    */

/*
    private  Singleton singleton;
    public  static synchronized Singleton  getSingleton(){
        if(singleton==null){
            singleton=new Singleton();
        }

        return singleton;
    }*/



private static Singleton singleton;
    public static Singleton  getSingleton(){
        synchronized (singleton){
            if (singleton==null){
                singleton=new Singleton();
            }
        }
        return singleton;
    }

}
