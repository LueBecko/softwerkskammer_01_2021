package java15.jep375;

/**
 * JEP 375: Pattern Matching for instanceof (Second Preview)
 *
 * <h2>Summary</h2>
 * Enhance the Java programming language with pattern matching for the instanceof operator.
 * Pattern matching allows common logic in a program, namely the conditional extraction of components from objects,
 * to be expressed more concisely and safely. This is a preview language feature in JDK 15.
 */
public class JEP375 {

    public static void main(String[] args) {
        final JEP375 instanceOfPatternMatching = new JEP375();

        System.out.println("JEP375 example");
        System.out.println("--------------");
        System.out.println("oldStyle:");
        System.out.println(instanceOfPatternMatching.oldStyle("BLUB"));
        System.out.println(instanceOfPatternMatching.oldStyle(12));

        System.out.println("--------------");
        System.out.println("newStyle:");
        System.out.println(instanceOfPatternMatching.newStyle("BLUB"));
        System.out.println(instanceOfPatternMatching.newStyle(12));
    }

    public String oldStyle(Object value) {
        final String returnValue;

        if (value instanceof String) {
            // note: explicite cast here
            String valueString = (String) value;
            returnValue = valueString + "X";
        } else if (value instanceof Integer) {
            // note: explicite cast here
            Integer valueInteger = (Integer) value;
            returnValue = String.valueOf(valueInteger + 1);
        } else {
            returnValue = "";
        }

        return returnValue;
    }


    private String newStyle(Object value) {
        final String returnValue;

        if (value instanceof String valueString) {
            // note: no explicite cast here
            returnValue = valueString + "X";
        } else if (value instanceof Integer valueInteger) {
            // note: no explicite cast here
            returnValue = String.valueOf(valueInteger + 1);
        } else {
            returnValue = "";
        }

        return returnValue;
    }

}