public class Vector_Tests {

  public static void main(String[] args) {
    Vector v = new Vector(0,0,2,2);
    System.out.println(String.format("\nTesting %s\n", v.toString()));
    System.out.println(v.containsPoint(1,1)); //true
    System.out.println(v.containsPoint(-1,-1)); //false
    System.out.println(v.containsPoint(2,2)); //true
    System.out.println(v.containsPoint(-1,1)); //false
    System.out.println(v.containsPoint(1,-1)); //false

    Vector v1 = new Vector(-1,-1,2,2);
    System.out.println(String.format("\nTesting %s\n", v1.toString()));
    System.out.println(v1.containsPoint(1,1));  //true
    System.out.println(v1.containsPoint(-1,-1)); //true
    System.out.println(v1.containsPoint(2,2)); //true
    System.out.println(v1.containsPoint(-1,1)); //false
    System.out.println(v1.containsPoint(1,-1)); //false

    Vector v2 = new Vector(-1,1,2,2);
    System.out.println(String.format("\nTesting %s\n", v2.toString()));
    System.out.println(v2.containsPoint(1,1)); //false
    System.out.println(v2.containsPoint(-1,-1)); //false
    System.out.println(v2.containsPoint(2,2)); //true
    System.out.println(v2.containsPoint(-1,1)); //true
    System.out.println(v2.containsPoint(1,-1)); //false
    System.out.println(v2.containsPoint(0,1)); //false

    Vector v3 = new Vector(-10,-10,20,20);
    System.out.println(String.format("\nTesting %s\n", v3.toString()));
    System.out.println(v3.containsPoint(1,1));  //true
    System.out.println(v3.containsPoint(-1,-1)); //true
    System.out.println(v3.containsPoint(2,2)); //true
    System.out.println(v3.containsPoint(-1,1)); //false
    System.out.println(v3.containsPoint(1,-1)); //false
    System.out.println(v3.containsPoint(-5,-5)); //true
    System.out.println(v3.containsPoint(-10,-10)); //true
    System.out.println(v3.containsPoint(-9,-9)); //true
    System.out.println(v3.containsPoint(4,4)); //true
    System.out.println(v3.containsPoint(7,7)); //true

    Vector v4 = new Vector(3,3,6,-9);
    System.out.println(String.format("\nTesting %s\n", v4.toString()));
    System.out.println(v4.containsPoint(3,3)); //true
    System.out.println(v4.containsPoint(4,-1));  //true
    System.out.println(v4.containsPoint(5,-5)); //true
    System.out.println(v4.containsPoint(6,-9)); //true

    Vector v5 = new Vector(0,0,0,10);
    System.out.println(String.format("\nTesting %s\n", v5.toString()));
    System.out.println(v5.containsPoint(0,0)); //true
    System.out.println(v5.containsPoint(0,1)); //true
    System.out.println(v5.containsPoint(0,2)); //true
    System.out.println(v5.containsPoint(0,3)); //true
    System.out.println(v5.containsPoint(0,4)); //true
    System.out.println(v5.containsPoint(0,5)); //true
    System.out.println(v5.containsPoint(0,6)); //true
    System.out.println(v5.containsPoint(0,10)); //true

    Vector v6 = new Vector(0,0,2,10);
    System.out.println(String.format("\nTesting %s\n", v6.toString()));
    System.out.println(v6.containsPoint(1,5)); //true

    Vector v7 = new Vector(0,0,6,40);
    System.out.println(String.format("\nTesting %s\n", v7.toString()));
    System.out.println(v7.containsPoint(3,20)); //true

    Vector v8 = new Vector(-2,-1,1,5);
    System.out.println(String.format("\nTesting %s\n", v8.toString()));
    System.out.println(v8.containsPoint(-1,1)); //true
    System.out.println(v8.containsPoint(0,3)); //true
    System.out.println(v8.containsPoint(1,5)); //true
    System.out.println(v8.containsPoint(0,0)); //false
    System.out.println(v8.containsPoint(1,4)); //false

    Vector v9 = new Vector(-1,-6,7,6);
    System.out.println(String.format("\nTesting %s\n", v9.toString()));
    System.out.println(v9.containsPoint(3,0)); //true
    System.out.println(v9.containsPoint(5,3)); //true
    System.out.println(v9.containsPoint(1,-3)); //true
    System.out.println(v9.containsPoint(0,0)); //false
    System.out.println(v9.containsPoint(2,0)); //false

    Vector v10 = new Vector(-4,4,80,1);
    v10.populatePoints();

    for (Integer[] point : v10.points) {
        System.out.println(point[0] + ", " + point[1]);
    }

    Vector v11 = new Vector(0,10,500,1000);
    v11.populatePoints();

    for (Integer[] point : v11.points) {
        System.out.println(point[0] + ", " + point[1]);
    }

  }
}
