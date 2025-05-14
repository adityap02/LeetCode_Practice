class ExamRoom {
    int N;
    TreeSet<Integer> students;
    public ExamRoom(int n) {
        this.N = n;
        students = new TreeSet<>();
    }
    
    public int seat() {
        int position = 0;

        if(students.size()>0){
            int dist = students.first();
            Integer prev = null;
            for(Integer s : students){
                if(prev!=null){
                    int temp = (s-prev) /2;
                    if(temp>dist){
                        dist=temp;
                        position = prev+temp;
                    }
                }
                prev = s;
            }
             if (N - 1 - students.last() > dist)
                position = N - 1;

        }

        students.add(position);
        return position;
    }
    
    public void leave(int p) {
        students.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */