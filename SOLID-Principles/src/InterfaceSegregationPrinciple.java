public class InterfaceSegregationPrinciple {
    //Don't force classes to implement methods they don't need! Split big interfaces into small, client-specific ones.
    interface Workable {
        void work();
    }
    interface Eatable {
        void eat();
    }
    class Robot implements Workable {
        public void work() {}
    }

}
