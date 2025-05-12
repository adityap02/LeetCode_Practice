class Solution {
    public String validIPAddress(String queryIP) {
        boolean isip4;
         if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            isip4 = true;
         }else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            isip4 = false;
        } else return "Neither";
        //String[] ip = queryIP.split("[\\.]");
        //boolean isip4 = true;
        // if(ip.length==1){
        //     ip = queryIP.split(":");
        //     isip4 = false;
        // }
        // if(ip.length==1){
        //     return "Neither";
        // }
        if(isip4){
            String[] ip = queryIP.split("\\.", -1);
            for(String s : ip){
                if(!isValidipv4(s)){
                    return "Neither";
                }
            }
            return "IPv4";
        }else if(!isip4){
            String[] ip = queryIP.split(":", -1);
            for(String s : ip){
                if((s.length()<1 || s.length()>4) || !isValidipv6(s)){
                    return "Neither";
                }
            }
            return "IPv6";
        }else{
            return "Neither";
        }
    }
    boolean isValidipv4(String s){
        int i ;
        try {
        i = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        }
        if(i<0 || i>255){
                return false;
        }
        if(s.length() >1 && s.charAt(0)=='0'){
            return false;
        }
        return true;
    }
        boolean isValidipv6(String s){ 
            for(char ch : s.toCharArray()){
                if((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F') && (ch < 'a' || ch > 'f')) return false;
            }
        return true;
    }
}