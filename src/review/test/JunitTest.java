package review.test;

public class JunitTest {
    public String getLevel(int score) {
        if (score <= 0) {
            throw new IllegalArgumentException();
        } else if (score < 60) {
            return "不及格";
        } else if (score < 70) {
            return "差";
        } else if (score < 80) {
            return "中";
        } else if (score < 90) {
            return "良";
        } else {
            return "优";
        }
    }
}
