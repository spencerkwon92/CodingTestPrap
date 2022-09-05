import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        String[] arr = s.split("");

        Map<String, Integer> data = new HashMap<>();
        data.put("I", 1);
        data.put("V", 5);
        data.put("X", 10);
        data.put("L", 50);
        data.put("C", 100);
        data.put("D", 500);
        data.put("M", 1000);

        int result = 0;

        for(int i=0; i<arr.length;i++){
            if(arr[i] != null){
                if(i!=arr.length-1){
                    if(data.get(arr[i]) < data.get(arr[i+1])){
                        result += (data.get(arr[i+1]) - data.get(arr[i]));
                        arr[i+1] = null;
                    }else{
                        result += data.get(arr[i]);
                    }
                }else{
                    result += data.get(arr[i]);
                }

            }
        }

        return result;
    }

    public static void main(String[] argv){
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
