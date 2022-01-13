public class GradeAverage {

    private int [] scores;

    public GradeAverage(int [] s)
    {
        scores = s;
    }

    private double mean(int first, int last) {
        double sum = 0;
        for (int i = first; i <= last; i++){
            sum += scores[i];
        }
        return sum / (last - first + 1);
    }

    private boolean showsImprovement() {
        for (int i = 0; i < scores.length-1; i++){
            if (scores[i] > scores[i+1]) return false;
        }
        return true;
    }

    public double finalGrade() {
        if (showsImprovement() == false) return mean(0,scores.length-1);
        return mean(scores.length/2, scores.length-1);
    }

    public static void main(String[] args) {
        int [] s1 = {50,50,20,80,53};
        int [] s2 = {20,50,50,53,80};
        int [] s3 = {20,50,50,85};
        int [] s4 = {35, 50, 45, 60,62};
        int [] s5 = {47, 58, 58, 66, 87, 90,90,90};

        GradeAverage sr1 = new GradeAverage(s1);
        System.out.println(sr1.mean(1,3));
        System.out.println(sr1.showsImprovement());
        System.out.println(sr1.finalGrade());
        GradeAverage sr2 = new GradeAverage(s2);
        System.out.println(sr2.mean(2,4));
        System.out.println(sr2.showsImprovement());
        System.out.println(sr2.finalGrade());
        GradeAverage sr3 = new GradeAverage(s3);
        System.out.println(sr3.mean(0,2));
        System.out.println(sr3.showsImprovement());
        System.out.println(sr3.finalGrade());
        GradeAverage sr4 = new GradeAverage(s4);
        System.out.println(sr4.showsImprovement());
        System.out.println(sr4.finalGrade());
        GradeAverage sr5 = new GradeAverage(s5);
        System.out.println(sr5.showsImprovement());
        System.out.println(sr5.finalGrade());
    }

}