package recursion.assignment;

public class PairStar {
    public static String addStars(String s) {
        if(s.length()==1){
            return s;
        }

        String smallAnswer = addStars(s.substring(1));

        if(s.charAt(0) == smallAnswer.charAt(0)) {
            return s.charAt(0) + "*" + smallAnswer;
        }
        else
            return s.charAt(0)+smallAnswer;

    }

    public static void main(String[] args) {
        String stars = addStars("aababbacc");
        System.out.println(stars);
    }
}
