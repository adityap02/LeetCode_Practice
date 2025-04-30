class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        if(x < arr[0]){
            for(int i =0;i<k;i++){
                ans.add(arr[i]);
            }
        }
        if(x > arr[arr.length-1]){
            for(int i =arr.length-1;i>=arr.length-k;i--){
                ans.add(arr[i]);
            }
        }
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        ans = list.stream()
                .sorted(Comparator.comparingInt(elem -> Math.abs(elem - x)))
                .limit(k)
                .sorted()
                .collect(Collectors.toList());

        return ans;
    }
}