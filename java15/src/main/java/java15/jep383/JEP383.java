package java15.jep383;

import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryHandles;
import jdk.incubator.foreign.MemorySegment;

/**
 * <h1>JEP 383: Foreign-Memory Access API (Second Incubator)</h1>
 * 
 * <h2>Summary</h2> Introduce an API to allow Java programs to safely and
 * efficiently access foreign memory outside of the Java heap.
 */
public class JEP383 {
    
    public static void main(String[] args) {

        // used in accessing foreign memory
        VarHandle intHandle = MemoryHandles.varHandle(
            int.class, ByteOrder.nativeOrder());

        // MemorySegment represents a fixed size block of foreign memory. Needs to be closed after usage.
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {

            // An adress in foreign memory
            MemoryAddress base = segment.baseAddress();

            // print memory address
            System.out.println(base);                 

            // set value 999 into the foreign memory
            intHandle.set(base, 999);                 

            // get the value from foreign memory
            System.out.println(intHandle.get(base));  

        }

    }

}
