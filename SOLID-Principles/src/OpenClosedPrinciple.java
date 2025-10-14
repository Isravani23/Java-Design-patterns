public class OpenClosedPrinciple {
    //Classes should be open for extension, closed for modification
    interface Shape {
        double getVolume();
    }

    class Cuboid implements Shape {
        double length, breadth, height;
        public double getVolume() {
            return length * breadth * height;
        }
    }

    class Sphere implements Shape {
        double radius;
        public double getVolume() {
            return (4.0 / 3) * Math.PI * radius * radius * radius;
        }
    }

    class Application {
        public double get_total_volume(Shape[] shapes) {
            double vol_sum = 0;
            for (Shape shape : shapes) {
                vol_sum += shape.getVolume();
            }
            return vol_sum;
        }
    }
}
