package passwordEncryption;
import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;



public class EncryptDecrypt {
	
	private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567891234567".getBytes();
    
    public static void main(String args[]) throws Exception {
        Key key = generateKey();
       String encriptValue = encrypt("YOUR_SECRETE_KEY",key);
       decrypt(encriptValue,key);

   }
 
    public static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
    
    public static String encrypt(String valueToEnc, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] valueToEncBytes = valueToEnc.getBytes(StandardCharsets.UTF_8);
        int blockSize = cipher.getBlockSize();
        byte[] paddedValueToEncBytes = new byte[blockSize * ((valueToEncBytes.length + blockSize - 1) / blockSize)];
        System.arraycopy(valueToEncBytes, 0, paddedValueToEncBytes, 0, valueToEncBytes.length);
        byte[] encryptedValueBytes = cipher.doFinal(paddedValueToEncBytes);

        byte[] encryptedByteValue = Base64.encodeBase64(encryptedValueBytes);
        System.out.println("Encrypted Value :: " + new String(encryptedByteValue));

        return new String(encryptedByteValue);
    }

    
    public static String decrypt(String encryptedValue, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] encryptedValueBytes = Base64.decodeBase64(encryptedValue.getBytes());
        byte[] decryptedValueBytes = cipher.doFinal(encryptedValueBytes);

        int padding = decryptedValueBytes[decryptedValueBytes.length - 1];
        byte[] decryptedValueBytesWithoutPadding = new byte[decryptedValueBytes.length - padding];
        System.arraycopy(decryptedValueBytes, 0, decryptedValueBytesWithoutPadding, 0, decryptedValueBytesWithoutPadding.length);

        System.out.println("Decrypted Value :: " + new String(decryptedValueBytesWithoutPadding));
        return new String(decryptedValueBytesWithoutPadding);
    }

    
    }