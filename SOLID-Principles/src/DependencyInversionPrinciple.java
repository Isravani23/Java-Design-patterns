public class DependencyInversionPrinciple {
    //Depend on abstractions—not concrete implementations!

    interface Switchable {
        void turnOn();
        void turnOff();
    }
    class LightBulb implements Switchable {
        public void turnOn() {}
        public void turnOff() {}
    }
    class Switch {
        private Switchable device;
        public Switch(Switchable device) { this.device = device; }
    }
    //By relying on the Switchable interface, Switch can work with any device!
}
