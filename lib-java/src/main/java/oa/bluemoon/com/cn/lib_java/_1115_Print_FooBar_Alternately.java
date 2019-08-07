package oa.bluemoon.com.cn.lib_java;

/**
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1115_Print_FooBar_Alternately {

    public static void main(String[] args) {
        final FooBar fooBar = new FooBar(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class FooBar {
        private int n;

        private int fooN = 0, barN = 0;

        public FooBar(int n) {
            this.n = n;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooPerson(printFoo);
            }
        }

        public synchronized void fooPerson(Runnable printFoo) throws InterruptedException {
            if (fooN == barN) {
                fooN++;
                printFoo.run();
                notify();
            } else {
                wait();
                fooPerson(printFoo);
            }
        }


        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barPerson(printBar);
            }
        }

        public synchronized void barPerson(Runnable printBar) throws InterruptedException {
            if (fooN == barN + 1) {
                barN++;
                printBar.run();
                notify();
            } else {
                wait();
                barPerson(printBar);
            }
        }
    }
}
