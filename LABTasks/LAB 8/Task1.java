public class Task1 {
    public static String integerToBinary(int n) {
        if(n == 0){
            return "0";
        }
        String returnx = "";
        float x = n;
        for(int i = 0; i < x; i++) { 
            x = x/2.0f;
           // x = (float)Math.ceil(n/2.0);
            //System.out.println("value of x:"+ x);
            
           // n = (int)x;
            //System.out.println("Value of n: " + n);
            if(x%2 != 0){
                returnx += "1";

            }
            else{
                returnx += "0";
            }
            returnx += "1";
    }
        return returnx;
}
    public static void main(String[] args) {
        
        System.out.println(integerToBinary(13));
        double x = Math.ceil(13.0/2);
        int n = (int) x;
        System.out.println(n);
    }    
}
