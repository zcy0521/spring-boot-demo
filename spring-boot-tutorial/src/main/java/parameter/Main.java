package parameter;

/**
 * 方法参数：
 *
 * 基本类型：值传递
 * 引用类型：引用传递
 */
public class Main {

	public static void main(String[] args) {
        int i = 1;
		fun1(i);
        System.out.println(i);

        Demo demo = new Demo();
        demo.setI(1);
        fun2(demo);
        System.out.println(demo);
	}

	private static void fun1(int i) {
	    i++;
    }

    private static void fun2(Demo demo) {
        int i = demo.getI();
        i++;
        demo.setI(i);
    }

    private static void fun3(String... args) {

    }

}