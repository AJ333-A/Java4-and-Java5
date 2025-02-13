
    
class Vehicle {
    protected String brand;
    protected int speed;

    // Constructor for Vehicle class
    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Method to accelerate the vehicle by a given amount
    public void accelerate(int increase) {
        speed += increase;
    }

    // Method to brake the vehicle by a given amount (speed cannot go below 0)
    public void brake(int decrease) {
        speed = Math.max(0, speed - decrease);
    }

    // Method to show details of the vehicle (overridden in subclasses)
    public void showDetails() {
        System.out.println("Vehicle Brand: " + brand);
        System.out.println("Vehicle Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    private int fuelLevel;

    // Constructor for Car class
    public Car(String brand, int speed, int fuelLevel) {
        super(brand, speed);
        this.fuelLevel = fuelLevel;
    }

    // Method to refuel the car, ensuring the fuel level doesn't exceed 100
    public void refuel(int amount) {
        fuelLevel = Math.min(100, fuelLevel + amount); // Fuel level cannot exceed 100
    }

    // Overriding showDetails to display car-specific details (including fuel level)
    @Override
    public void showDetails() {
        super.showDetails();  // Call the parent class method
        System.out.println("Fuel Level: " + fuelLevel + "%");
    }
}

class Bike extends Vehicle {
    private boolean helmetOn;

    // Constructor for Bike class
    public Bike(String brand, int speed, boolean helmetOn) {
        super(brand, speed);
        this.helmetOn = helmetOn;
    }

    // Method to wear the helmet
    public void wearHelmet() {
        helmetOn = true;
    }

    // Overriding showDetails to display bike-specific details (including helmet status)
    @Override
    public void showDetails() {
        super.showDetails();  // Call the parent class method
        System.out.println("Helmet On: " + (helmetOn ? "Yes" : "No"));
    }
}public class VehicleSystem {
    public static void main(String[] args) {
        // Create a Car object with initial values
        Car car = new Car("Toyota", 60, 50);

        // Perform operations on the car
        car.accelerate(20);  // Accelerate by 20
        car.brake(30);       // Brake by 30
        car.refuel(30);      // Refuel by 30

        // Display the car details after operations
        car.showDetails();

        System.out.println();  // Empty line for separation

        // Create a Bike object with initial values
        Bike bike = new Bike("Yamaha", 40, false);

        // Perform operations on the bike
        bike.accelerate(15);  // Accelerate by 15
        bike.brake(10);       // Brake by 10
        bike.wearHelmet();    // Wear helmet

        // Display the bike details after operations
        bike.showDetails();
    }
}

