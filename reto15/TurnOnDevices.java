public class TurnOnDevices {

    public static void main(String[] args) {

        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
        turnOnDevice(new Adapter(new CoffeMaker()));
    }

    private static void turnOnDevice(Connectable device) {
        device.turnOn();
        System.out.println(device.isOn());
    }

    static class Connectable {
        private boolean isOn;

        public void turnOn() {
            isOn = true;
        }

        public void turnOff() {
            isOn = false;
        }

        public boolean isOn() {
            return isOn;
        }
    }

    static class Lamp extends Connectable {
    }

    static class Computer extends Connectable {
    }

    static class CoffeMaker {
        private boolean isOn;

        public void On() {
            isOn = true;
        }

        public void Off() {
            isOn = false;
        }

        public boolean isOff() {
            return !isOn;
        }
    }

    static class Adapter extends Connectable {
        private CoffeMaker coffeMaker;

        public Adapter(CoffeMaker coffeMaker) {
            this.coffeMaker = coffeMaker;
        }

        public void turnOn() {
            coffeMaker.On();
        }

        public void turnOff() {
            coffeMaker.Off();
        }

        public boolean isOn() {
            return !coffeMaker.isOff();
        }
    }
}