class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        if(denominator==1){
            return ans.append(numerator).toString();
        }else if(numerator==denominator){
            return "1";
        }else if(numerator==0){
            return "0";
        }
        if((numerator<0 || denominator<0) && !(numerator<0 && denominator<0)){
            ans.append("-");
        }
        //Java int has minimum value of -2,147,483,648 and a maximum value of 2,147,483,647
        // Long because if input is  -2,147,483,648 then it's abs value will not fit in int
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        ans.append(dividend/divisor);
        long remainder = dividend%divisor;

        if(remainder==0){
            return ans.toString();
        }

        ans.append(".");//if we have remiander....

        Map<Long,Integer> map = new HashMap<>(); //to break in case of repeating decimal

        while(remainder!=0){
            if(map.containsKey(remainder)){
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }
            map.put(remainder, ans.length());
            remainder*=10;
            ans.append(String.valueOf(remainder/divisor));

            remainder = remainder % divisor;
        }
    return ans.toString();

        // StringBuilder sb = new StringBuilder("");
        // if(numerator<denominator){
        //     sb.append("0");
        // }else if(denominator==1){
        //     sb.append(Integer.valueOf(numerator).toString());
        //     return sb.toString();
        // }else if(numerator==denominator){
        //     sb.append(Integer.valueOf(1).toString());
        //     return sb.toString();
        // }
        // else{
        //     sb.append(Integer.valueOf(numerator/denominator).toString());
        // }
        // int temp =numerator % denominator; 
        // Map<Integer,Integer> map = new HashMap<>();
        // StringBuilder sbt = new StringBuilder("");
        // if( temp==0){
        //     return sb.toString();
        // }else{
        //     sbt.append(".");
            

        //     while(temp!=0){
        //         temp = temp*10;

        //         if(!map.containsKey(temp)){
        //             map.put(temp,temp/denominator);
        //             while(temp<denominator){
        //                 sbt.append("0");
        //                 temp = temp*10;
        //                 map.put(temp,temp/denominator);
        //             }
        //             sbt.append(Integer.valueOf(temp/denominator).toString());
                    
        //             temp =temp % denominator;
        //         }else{
        //             sbt.insert(sbt.indexOf(Integer.valueOf(map.get(temp)).toString()),"(");
        //             sbt.append(")");
        //             sb.append(sbt.toString());
        //             return sb.toString();
        //         }
               
        //     }
        // }
        // return sb.append(sbt.toString()).toString();

    }
}