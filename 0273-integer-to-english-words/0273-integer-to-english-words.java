class Solution {
    private static final Map<Integer, String> numberToWordsMap = new LinkedHashMap<>();

    static {
        numberToWordsMap.put(1000000000, "Billion");
        numberToWordsMap.put(1000000, "Million");
        numberToWordsMap.put(1000, "Thousand");
        numberToWordsMap.put(100, "Hundred");
        numberToWordsMap.put(90, "Ninety");
        numberToWordsMap.put(80, "Eighty");
        numberToWordsMap.put(70, "Seventy");
        numberToWordsMap.put(60, "Sixty");
        numberToWordsMap.put(50, "Fifty");
        numberToWordsMap.put(40, "Forty");
        numberToWordsMap.put(30, "Thirty");
        numberToWordsMap.put(20, "Twenty");
        numberToWordsMap.put(19, "Nineteen");
        numberToWordsMap.put(18, "Eighteen");
        numberToWordsMap.put(17, "Seventeen");
        numberToWordsMap.put(16, "Sixteen");
        numberToWordsMap.put(15, "Fifteen");
        numberToWordsMap.put(14, "Fourteen");
        numberToWordsMap.put(13, "Thirteen");
        numberToWordsMap.put(12, "Twelve");
        numberToWordsMap.put(11, "Eleven");
        numberToWordsMap.put(10, "Ten");
        numberToWordsMap.put(9, "Nine");
        numberToWordsMap.put(8, "Eight");
        numberToWordsMap.put(7, "Seven");
        numberToWordsMap.put(6, "Six");
        numberToWordsMap.put(5, "Five");
        numberToWordsMap.put(4, "Four");
        numberToWordsMap.put(3, "Three");
        numberToWordsMap.put(2, "Two");
        numberToWordsMap.put(1, "One");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        for (Map.Entry<Integer,String> nw : numberToWordsMap.entrySet()) {
            // Check if the number is greater than or equal to the current unit
            if (num >= nw.getKey()) {
                // Convert the quotient to words if the current unit is 100 or greater
                String prefix = (num >= 100) ? numberToWords(num / nw.getKey()) + " " : "";

                // Get the word for the current unit
                String unit = nw.getValue();

                // Convert the remainder to words if it's not zero
                String suffix = (num % nw.getKey() == 0) ? "" : " " + numberToWords(num % nw.getKey());

                return prefix + unit + suffix;
            }
        }

        return "";
    }
}