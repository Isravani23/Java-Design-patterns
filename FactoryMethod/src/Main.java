public class Main {
    public static void main(String[] args) {
        Creator creator = new ElectronicsCreator();
        Product product = creator.factoryMethod();
        product.display();  // Output: Electronics product.

        creator = new ClothingCreator();
        product = creator.factoryMethod();
        product.display();  // Output: Clothing product.
    }
}