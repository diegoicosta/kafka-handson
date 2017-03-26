package handson.commons.domain;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by diegoicosta on 26/03/17.
 */
public class IdBuilder {

    private static final String PATTERN = "%s-%s";
    private static final char[] alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int TOKEN_LENGTH = 12;

    public static String generate(String prefix) {
        SecureRandom sr = null;

        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException var4) {
            ;
        }

        char[] token = new char[12];

        for (int i = 0; i < token.length; ++i) {
            token[i] = alphabet[sr.nextInt(alphabet.length)];
        }

        return String.format("%s-%s", new Object[] { prefix, new String(token) });
    }

}
