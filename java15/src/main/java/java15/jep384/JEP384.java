package java15.jep384;

import java.io.Serializable;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h1>JEP 384: Records (Second Preview)</h1>
 * 
 * <h2>Summary</h2> Enhance the Java programming language with records, which
 * are classes that act as transparent carriers for immutable data. Records can
 * be thought of as nominal tuples.
 */
public class JEP384 {

    /**
     * a typical java value class/data class
     */
    final class PointVintage implements Serializable {
        private static final long serialVersionUID = 1L;

        @MyAnnotation private final int x;
        private final int y;
    
        PointVintage(int x, int y) { 
            this.x = x;
            this.y = y;
        }
    
        int x() { return x; }
        int y() { return y; }
    
        /**
         * note: additional method besides getters
         */
        public double euclideanNorm() {
            return Math.sqrt(x*x + y*y);
        }

        public boolean equals(Object o) { 
            if (!(o instanceof PointVintage)) return false;
            PointVintage other = (PointVintage) o;
            return other.x == x && other.y == y;
        }
    
        public int hashCode() {
            return Objects.hash(x, y);
        }
    
        public String toString() { 
            return String.format("PointVintage[x=%d, y=%d]", x, y);
        }
    }

    /**
     * minimal working example of a record
     * 
     * all fields are private final and cannot be be made modifieable by reflections(!!!)
     * 
     * default constructor, getters, equals, hashcode and toString are generated inernally
     */
    record PointMinimal(int x, int y) {}

    /**
     * For comparison: Kotlin data class
     * 
     * data class Point(val x: Int, val y: Int)
     */

    /**
     * semantically the same class as PointVintage, but without any boilerplate code
     * 
     * Note: a record is not allowed to use inheritance (no extends),
     *      but can implement interfaces (implements is allowed)
     * 
     * Based on the @Target of the Annotation (Field, Constructor, accessors, ...) the annotation
     * is applied automatically to all valid targets
     */
    record Point(@MyAnnotation int x, int y) implements Serializable {
        /**
         * a record can have static members and static methods, just as a java class does
         */
        private static final long serialVersionUID = 1L;

        /**
         * you can add methods as with usual classes
         */
        public double euclideanNorm() {
            return Math.sqrt(x*x + y*y);
        }
    }

    /**
     * A default constructor with all members as parameters is supplied automatically.
     * You can supply your own complete constructor or amend the default constructor.
     */
    record Range(int lo, int hi) {
        /**
         * additional constructor
         */
        Range(int hi) {
            this(0, hi);
        }

        /**
         * additional logic for the default constructor
         */
        Range {
            if (lo > hi)  // referring here to the implicit constructor parameters
                throw new IllegalArgumentException(String.format("(%d,%d)", lo, hi));
        }
    }

    /**
     * local record are good to hold intermediate values
     */
    public static void localRecord() {
        // local record
        record Merchant(int index, String name) {}

        // returns merchant ids sorted by their name
        IntStream.range(0, 400)
            .boxed()
            .map(index -> new Merchant(index, computeName(index)))
            .sorted((data1, data2) -> data1.name().compareTo(data2.name()))
            .map(Merchant::index)
            .collect(Collectors.toList());

    }

    private static String computeName(Integer index) {
        return "Name is " + Math.random();
    }

    public static void main(String[] args) {
        
        // and now for some new reflection magic
        System.out.println("PointVintage isRecords: " + PointVintage.class.isRecord());
        System.out.println("PointVintage getRecordComponents: ");
        System.out.println(printRecordComponents(PointVintage.class.getRecordComponents()));
        System.out.println();

        System.out.println("Point isRecords: " + Point.class.isRecord());
        System.out.println("Point getRecordComponents: ");
        System.out.println(printRecordComponents(Point.class.getRecordComponents()));

    }

    private static String printRecordComponents(RecordComponent[] recordComponents) {
        if (recordComponents == null) {
            return "";
        } else {
            return Arrays.stream(recordComponents)
                .map(component -> " * " + component.getName())
                .collect(Collectors.joining("\n"));
        }
    }

}
