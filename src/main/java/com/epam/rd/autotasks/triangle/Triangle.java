package com.epam.rd.autotasks.triangle;


import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.cos;
import static java.lang.Math.acos;


class Triangle {

    double x11; double x12; double x13;
    double y11; double y12; double y13;

    double a; double b; double c; // Відрізки

    double s; // Проща
    double h; // Висота
    double p; // Полу-периметр
    double Cent; // центр

    public Triangle(Point a, Point b, Point c) {
        if(a.similar(b) || a.similar(c) || b.similar(c))
        {
            throw new IllegalArgumentException();
        }

        x11 = a.getX(); x12 = b.getX(); x13 = c.getX();
        y11 = a.getY(); y12 = b.getY(); y13 = c.getY();

        this.a = sideLenght(a, b);
        this.b = sideLenght(b, c);
        this.c = sideLenght(a, c);
        System.out.println("Side lenght = " + this.a + " / "+ this.b + " / "+ this.c);
        if(this.a+this.b < this.c) throw new IllegalArgumentException();
        test180Angls();

    }

    double segmentLenght(double x1, double x2, double y1, double y2)
    {
        double result = sqrt(pow(x2-x1, 2) + pow(y2 - y1, 2));
        if(result >0 ) return result;
        else throw new IllegalArgumentException();

    }
    double sideLenght(Point a, Point b)
    {
        double temp = Math.pow(b.getX() - a.getX(), 2);
        temp += Math.pow(b.getY() - a.getY(), 2);
        double result = Math.sqrt(temp);

       // double result = sqrt(pow(b.getX()-a.getX(), 2) + pow(b.getY() - a.getX(), 2));

        if(result >0 ) return result;
        else throw new IllegalArgumentException();

    }

    void test180Angls(){
        double angleAtA = Math.toDegrees(acos((pow(b, 2) + pow(c, 2) - pow(a, 2))/(2*b*c)));
        double angleAtB = Math.toDegrees(acos((pow(a, 2) + pow(c, 2) - pow(b, 2))/(2*a*c)));
        double angleAtC = Math.toDegrees(acos((pow(a, 2) + pow(b, 2) - pow(c, 2))/(2*a*b)));

        System.out.println("Side angle = " + angleAtA + " / "+ angleAtB + " / "+ angleAtC);
        if(Math.abs(angleAtA+angleAtB+angleAtC) > 180.0000005) {
            System.out.println("Wrong angle = " + (angleAtA + angleAtB + angleAtC) + " / ");
            throw new IllegalArgumentException();
        }
        else if (angleAtA >= 180 || angleAtB >= 180 || angleAtC >= 180) {
            throw new IllegalArgumentException();
        }

    }
    public double area() {
        p = (a+b+c)/2;
        s = sqrt(p*(p-a)*(p-b)*(p-c));
        h = ( sqrt(p*(p-a)*(p-b)*(p-c))   )/a;

        return s;
    }

    public Point centroid(){
        double resX = (x11 +x12+x13)/3;
        double resY = (y11+y12+y13)/3;
        return new Point(resX, resY);
    }

}
