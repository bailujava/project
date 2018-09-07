import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;

public class xx {
    @Test
    public  void xi(){
        String s = new String("123456");
        char salt = s.charAt(0);

        byte[] bytes = DigestUtils.md5Digest((s+salt).getBytes());
        String s2 = DigestUtils.md5DigestAsHex((s + salt).getBytes());
        System.out.println(s2);
        System.out.println(bytes);
        BigInteger bigInteger = new BigInteger(1, bytes);
        String s1 = bigInteger.toString(16);
        System.out.println(s1);

    }
}
