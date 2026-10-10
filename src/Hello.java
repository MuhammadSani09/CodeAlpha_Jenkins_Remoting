public class Hello {
    public static void main(String[] args) {
        if (2 + 3 != 5) {
            throw new AssertionError("Calculation failed");
        }
        System.out.println("Java test passed!");
    }
}
