package practice.utils.security;
import java.security.*;

public class Sign {

    private RuntimeException exception;
    public void verifySignature() {
        try {
            var key = KeyPairGenerator.getInstance("EC").generateKeyPair();
            var blankSignature = new byte[64];
            var sig = Signature.getInstance("SHA256WithECDSAInP1363Format");
            sig.initVerify(key.getPublic());
            sig.update("Hello World.".getBytes());
            sig.verify(blankSignature);
            this.exception =  null;

        } catch(NoSuchAlgorithmException | InvalidKeyException |SignatureException e) {
            String message = String.format("%s : %s",e.getClass().toString(), e.getMessage());
            RuntimeException ex = new RuntimeException(message);
            ex.setStackTrace(e.getStackTrace());
            this.exception =  ex;
        }
    }
    public RuntimeException getException() {
        return exception;
    }
    public boolean hasException() {
        return exception != null;
    }

}
