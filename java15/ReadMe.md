# JAVA 15 - Overview

**JEP** - *JDK Enhancement Proposal*

 * **New Functionality:**
   * *JEP 339:* Edwards-Curve Digital Signature Algorithm (EdDSA) – This feature improves security and performance by implementing cryptographic signatures using the EdDSA as described by RFC 8032.
   * *JEP 371:* Hidden Classes – This feature improves productivity by improving how Java works with frameworks that generate classes at run time and use them indirectly, via reflection.
 * **Preview Features Now Finalized:**
   * *JEP 378:* Text Blocks – This feature, which was a preview feature in JDK 13 and JDK 14, improves developer productivity by adding multi-line string literals and automatically formatting strings in a predictable way.
   * *JEP 377:* ZGC – This scalable, low-latency garbage collector moves to production after being introduced as an experimental feature in JDK 11.
 * **Incubating and Preview Features:**
   * *JEP 360:* Sealed Classes – This preview feature improves developer productivity by enhancing the Java programming language with sealed classes and interfaces. Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.
   * *JEP 375:* Pattern Matching for instanceof – This preview feature, which was first introduced in JDK 14, improves developer productivity by eliminating the need for common boilerplate code and should allow more concise type safe code.
   * *JEP 384:* Records – This preview feature, first introduced in JDK 14, improves developer productivity by providing a compact syntax for declaring classes which hold shallowly immutable data.
   * *JEP 383:* Foreign-Memory Access API – This incubating feature, which was first introduced in JDK 14, defines an API to allow Java programs to safely and efficiently access foreign memory outside of the Java heap.
* **Modernizing Existing Code:**
  * *JEP 373:* Reimplementation of the Legacy Datagram Socket and MulticastSocket APIs – This feature improves the maintainability and stability of the JDK by replacing the underlying implementations of the java.net.DatagramSocket and java.net.MulticastSocket APIs with simpler and more modern implementations.
* **Cleanup:**
    * As with previous feature releases, JDK 15 deprecates outdated functionality (JEP 374: Biased Locking, JEP 385: RMI Activation) and removes previously deprecated functionality (JEP 372: Nashorn JavaScript Engine) and ports (JEP 381: Solaris and Sparc).
