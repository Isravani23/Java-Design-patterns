public class Singleton {
    //Static variable to hold single instance
    private static Singleton instance = null;
    // Private constructor prevents instantiation from outside
    private Singleton(){

    }
    // Static method to get the instance (lazy initialization)
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        // s1 and s2 reference the same object
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
