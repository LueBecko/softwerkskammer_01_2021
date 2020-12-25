package java15.jep371;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Base64;

/**
 * <h1>JEP 371: Hidden Classes</h1>
 * 
 * <h2>Summary</h2> Introduce hidden classes, which are classes that cannot be
 * used directly by the bytecode of other classes. Hidden classes are intended
 * for use by frameworks that generate classes at run time and use them
 * indirectly, via reflection. A hidden class may be defined as a member of an
 * access control nest, and may be unloaded independently of other classes.
 */
public class JEP371 {

    //Here is the Base64 encoded class.
    /*
    package com.mkyong.java15.jep371;

    public class LookUpProxy{

        public static Integer lookup() {
            return 1;
        }
    }*/
    static final String CLASS_IN_BASE64 = "yv66vv//ADsAGAcAAgEAGWphdmExNS9qZXAzNzEvTG9va1VwUHJveHkHAAQBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWAQAEQ29kZQoAAwAJDAAFAAYBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAbTGphdmExNS9qZXAzNzEvTG9va1VwUHJveHk7AQAGbG9va3VwAQAVKClMamF2YS9sYW5nL0ludGVnZXI7CgARABMHABIBABFqYXZhL2xhbmcvSW50ZWdlcgwAFAAVAQAHdmFsdWVPZgEAFihJKUxqYXZhL2xhbmcvSW50ZWdlcjsBAApTb3VyY2VGaWxlAQAQTG9va1VwUHJveHkuamF2YQAhAAEAAwAAAAAAAgABAAUABgABAAcAAAAvAAEAAQAAAAUqtwAIsQAAAAIACgAAAAYAAQAAAAMACwAAAAwAAQAAAAUADAANAAAACQAOAA8AAQAHAAAAJQABAAAAAAAFBLgAELAAAAACAAoAAAAGAAEAAAAGAAsAAAACAAAAAQAWAAAAAgAX";

    public static void main(String[] args) throws Throwable {

        // byte[] array = Files.readAllBytes(
        //       Paths.get("~/Dropbox/programming/java15/java15/target/classes/java15/jep371/LookUpProxy.class"));
        // String s = Base64.getEncoder().encodeToString(array);
        // System.out.println(s);

        withoutHiddenClass();
        accessNotHiddenClass();

        withHiddenClass();
        accessHiddenClass();

    }

    // create a NOT hidden class and run its static method
    private static void withoutHiddenClass() throws Throwable {

        System.out.println("----------");
        System.out.println("Define a non hidden class");
        
        byte[] classInBytes = Base64.getDecoder().decode(CLASS_IN_BASE64);

        Class<?> proxy = MethodHandles.lookup()
                .defineClass(classInBytes);

        // output: java15.jep371.LookUpProxy
        System.out.println(proxy.getName());

        MethodHandle mh = MethodHandles.lookup().findStatic(proxy,
                "lookup",
                MethodType.methodType(Integer.class));

        Integer status = (Integer) mh.invokeExact();
        System.out.println(status);

    }

    private static void accessNotHiddenClass() throws Throwable {
        System.out.println("----------");
        System.out.println("You can access this none hidden class from everywhere, as long as you know it's name");

        Class<?> proxy = Class.forName("java15.jep371.LookUpProxy");

        MethodHandle mh = MethodHandles.lookup().findStatic(proxy,
                "lookup",
                MethodType.methodType(Integer.class));

        Integer status = (Integer) mh.invokeExact();
        System.out.println(status);
    }

    private static void withHiddenClass() throws Throwable {
        System.out.println("----------");
        System.out.println("Define a hidden class");

        byte[] classInBytes = Base64.getDecoder().decode(CLASS_IN_BASE64);

        Class<?> proxy = MethodHandles.lookup()
                .defineHiddenClass(classInBytes,
                        true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();

        // output: java15.jep371.LookUpProxy/0x0000000800b98840
        System.out.println(proxy.getName());

        MethodHandle mh = MethodHandles.lookup().findStatic(proxy,
                "lookup",
                MethodType.methodType(Integer.class));

        Integer status = (Integer) mh.invokeExact();
        System.out.println(status);

    }

    private static void accessHiddenClass() throws Throwable {
        System.out.println("----------");
        System.out.println("You cannot access this hidden class from everywhere");

        Class<?> proxy = Class.forName("java15.jep371.LookUpProxy/0x0000000800b98840");

        MethodHandle mh = MethodHandles.lookup().findStatic(proxy,
                "lookup",
                MethodType.methodType(Integer.class));

        Integer status = (Integer) mh.invokeExact();
        System.out.println(status);
    }

}
