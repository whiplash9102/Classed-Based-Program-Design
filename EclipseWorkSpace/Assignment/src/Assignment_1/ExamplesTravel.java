package Assignment_1;

public class ExamplesTravel {
  // Housing Examples
  public Hut hovel = new Hut(5, 1);
  public Castle winterfell = new Castle("Winterfell", "Stark", 500, 6);
  public Inn crossroads = new Inn("Inn At The Crossroads", 40, 20, 12);
  public Hut pinehut = new Hut("Pine Hut", 6, 4);
  public Inn riverinn = new Inn("River Inn", 50, 35, 15);
  public Castle stonecastle = new Castle("Stonecastle", "Lannister", 300, 4);

  // Transportation Examples
  public Horse horse1 = new Horse(hovel, crossroads, "Shadow", "Black");
  public Horse horse2 = new Horse(stonecastle, pinehut, "Blaze", "White");
  public Carriage carriage1 = new Carriage(crossroads, winterfell, 10);
  public Carriage carriage2 = new Carriage(winterfell, riverinn, 15);

  // Main method to display examples (optional)
  public static void main(String[] args) {
      ExamplesTravel examples = new ExamplesTravel();

      // Display Housing Examples
      System.out.println("=== Housing Examples ===");
      System.out.println("Hovel: Capacity = " + examples.hovel.capacity + ", Population = " + examples.hovel.population);
      System.out.println("Winterfell: Name = " + examples.winterfell.name + ", Family Name = " + examples.winterfell.familyName
              + ", Population = " + examples.winterfell.population + ", Carriage Capacity = " + examples.winterfell.carriageCapacity);
      System.out.println("Crossroads Inn: Name = " + examples.crossroads.name + ", Capacity = " + examples.crossroads.capacity
              + ", Population = " + examples.crossroads.population + ", Stalls = " + examples.crossroads.stalls);
      System.out.println("Pine Hut: Name = " + examples.pinehut.name + ", Capacity = " + examples.pinehut.capacity
              + ", Population = " + examples.pinehut.population);
      System.out.println("River Inn: Name = " + examples.riverinn.name + ", Capacity = " + examples.riverinn.capacity
              + ", Population = " + examples.riverinn.population + ", Stalls = " + examples.riverinn.stalls);
      System.out.println("Stonecastle: Name = " + examples.stonecastle.name + ", Family Name = " + examples.stonecastle.familyName
              + ", Population = " + examples.stonecastle.population + ", Carriage Capacity = " + examples.stonecastle.carriageCapacity);

      // Display Transportation Examples
      System.out.println("\n=== Transportation Examples ===");
      System.out.println("Horse1: Name = " + examples.horse1.name + ", Color = " + examples.horse1.color
              + ", From = " + (examples.horse1.from instanceof Hut ? "Hovel" : examples.horse1.from.name)
              + ", To = " + examples.horse1.to.name);
      System.out.println("Horse2: Name = " + examples.horse2.name + ", Color = " + examples.horse2.color
              + ", From = " + examples.horse2.from.name + ", To = " + examples.horse2.to.name);
      System.out.println("Carriage1: Tonnage Limit = " + examples.carriage1.tonnageLimit
              + ", From = " + examples.carriage1.from.name + ", To = " + examples.carriage1.to.name);
      System.out.println("Carriage2: Tonnage Limit = " + examples.carriage2.tonnageLimit
              + ", From = " + examples.carriage2.from.name + ", To = " + examples.carriage2.to.name);
  }
}