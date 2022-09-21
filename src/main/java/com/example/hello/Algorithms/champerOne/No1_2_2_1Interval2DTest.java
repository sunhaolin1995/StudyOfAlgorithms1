package com.example.hello.Algorithms.champerOne;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;

/**
 * Intelval2D的测试用例
 * @author 孙浩林
 * @date: 2022/9/21 20:58
 */
public class No1_2_2_1Interval2DTest {
    public static void main(String[] args) {
        double xlo =.2;
        double xhi =.5;
        double ylo =.5;
        double yhi =.6;
        int T =50000;

        Interval1D xinterval = new Interval1D(xlo,xhi);
        Interval1D yinterval = new Interval1D(ylo,yhi);
        Interval2D box = new Interval2D(xinterval,yinterval);
        box.draw();

        Counter c =new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x =Math.random();
            double y =Math.random();
            Point2D p = new Point2D(x,y);
            if (box.contains(p)){
                c.increment();
            }else {
                p.draw();
            }
        }

        System.out.println(c);
        System.out.println(box.area());

    }
}
