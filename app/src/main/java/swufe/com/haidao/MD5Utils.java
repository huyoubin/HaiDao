package swufe.com.haidao;

import android.os.Message;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String md5(String text){
        MessageDigest digest = null;
        try{
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for(byte b : result){
                int number = b & 0xff;
                String hex = (String) Integer.toHexString(number);
                if(hex.length()==1){
                    sb.append(hex);
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
