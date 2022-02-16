package edu.school21.launcher.models;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingWords {
    MessageDigest md = MessageDigest.getInstance("MD5");

    public HashingWords() throws NoSuchAlgorithmException {}

    public String convert (String str) throws UnsupportedEncodingException {
        md.update(str.getBytes("UTF-8"));
        // digest() method is called to calculate message digest
        //  of an input digest() return array of byte
        byte[] digest = md.digest();
        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, digest);
        // Convert message digest into hex value
        String myHash = no.toString(16);
        while (myHash.length() < 32) {
            myHash = "0" + myHash;
        }
        return myHash;
    }
}
