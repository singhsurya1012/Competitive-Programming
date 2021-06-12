package easy;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {

    private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();

    public int reverseBits(int n) {

        int ret = 0, power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >>> 1;
            power -= 1;
        }
        return ret;
    }


    public int reverseBitsOptimised(int n){

        byte[] bytes = new byte[4];

        for(int i=0; i<4;i++){
            bytes[i] = (byte)((n>>>8*i) & 0xFF);
        }

        int result = 0;

        for(int i=0; i<4;i++){
            result +=reverseByte(bytes[i]);

            if(i<3)
                result<<=8;
        }

        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b); // first look up from cache
        if (value != null)
            return value;
        value = 0;

        // reverse by bit
        for (int i = 0; i < 8; i++) {
            value += ((b >>> i) & 1);
            if (i < 7)
                value <<= 1;
        }
        cache.put(b, value);
        return value;
    }
}
