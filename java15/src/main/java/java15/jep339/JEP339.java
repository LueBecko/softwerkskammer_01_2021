package java15.jep339;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

/**
 * <h1>JEP 339:* Edwards-Curve Digital Signature Algorithm (EdDSA)</h1>
 * 
 * <h2>Summary</>
 * Implement cryptographic signatures using the Edwards-Curve Digital
 * Signature Algorithm (EdDSA) as described by RFC 8032.
 */
public class JEP339 {

    public static void main(String[] args)
        throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
        KeyPair kp = kpg.generateKeyPair();

        byte[] msg = "abc".getBytes(StandardCharsets.UTF_8);

        Signature sig = Signature.getInstance("Ed25519");
        sig.initSign(kp.getPrivate());
        sig.update(msg);
        byte[] s = sig.sign();

        System.out.println(Base64.getEncoder().encodeToString(s));

    }
}