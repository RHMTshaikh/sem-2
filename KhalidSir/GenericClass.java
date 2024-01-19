package KhalidSir;

class ThreeValues<T> {
    private T a;
    private T b;
    private T c;
    public ThreeValues(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public T getA() {
        return a;
    }
    public T getB() {
        return b;
    }
    public T getC() {
        return c;
    }
    public T sum() {
        try {
            if (a instanceof Number && b instanceof Number && c instanceof Number) {
                // Ensure all values are of Number type for numeric addition
                double sum = ((Number) a).doubleValue() + ((Number) b).doubleValue() + ((Number) c).doubleValue();
                // double sum = a+b+c;
                return (T) Double.valueOf(sum);
            } else {
                throw new UnsupportedOperationException("Sum operation is only supported for numeric types.");
            }
        } catch (Exception e) {
            System.err.println("Error calculating sum: " + e.getMessage());
            return null;
        }
    }
    public T product() {
        try {
            if (a instanceof Number && b instanceof Number && c instanceof Number) {
                // Ensure all values are of Number type for numeric multiplication
                double product = ((Number) a).doubleValue() * ((Number) b).doubleValue() * ((Number) c).doubleValue();
                return (T) Double.valueOf(product);
            } else {
                throw new UnsupportedOperationException("Product operation is only supported for numeric types.");
            }
        } catch (Exception e) {
            System.err.println("Error calculating product: " + e.getMessage());
            return null;
        }
    }
}
public class GenericClass {
    public static void main(String[] args) {
        // Test with Integer values
        ThreeValues<Integer> intValues = new ThreeValues<>(2, 3, 4);
        System.out.println("Integer Sum: " + intValues.sum());
        System.out.println("Integer Product: " + intValues.product());

        // Test with Double values
        ThreeValues<Double> doubleValues = new ThreeValues<>(2.5, 3.5, 4.5);
        System.out.println("Double Sum: " + doubleValues.sum());
        System.out.println("Double Product: " + doubleValues.product());

        // Test with String values
        ThreeValues<String> stringValues = new ThreeValues<>("Hello", ", ", "World");
        System.out.println("String Concatenation: " + stringValues.sum());

        // Test with Byte values
        ThreeValues<Byte> byteValues = new ThreeValues<>((byte) 1, (byte) 2, (byte) 3);
        System.out.println("Byte Sum: " + byteValues.sum());
        System.out.println("Byte Product: " + byteValues.product());

        // Test with Short values
        ThreeValues<Short> shortValues = new ThreeValues<>((short) 5, (short) 6, (short) 7);
        System.out.println("Short Sum: " + shortValues.sum());
        System.out.println("Short Product: " + shortValues.product());

        // Test with Long values
        ThreeValues<Long> longValues = new ThreeValues<>(100L, 200L, 300L);
        System.out.println("Long Sum: " + longValues.sum());
        System.out.println("Long Product: " + longValues.product());

        // Test with Float values
        ThreeValues<Float> floatValues = new ThreeValues<>(1.1f, 2.2f, 3.3f);
        System.out.println("Float Sum: " + floatValues.sum());
        System.out.println("Float Product: " + floatValues.product());

        // Test with Character values
        ThreeValues<Character> charValues = new ThreeValues<>('A', 'B', 'C');
        System.out.println("Char Concatenation: " + charValues.sum());
    }
}

