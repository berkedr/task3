import java.util.ArrayList;

public abstract class Material {
    int id;
    String name;
    ArrayList<Integer> scores;
    int releaseYear;
    Category category;
    int price;
    String type;

    public Material(int id, String name, ArrayList<Integer> scores, int releaseYear, int price, Category category, String type) {
        this.id = id;
        this.name = name;
        this.scores = scores != null ? scores : new ArrayList<>();
        this.releaseYear = releaseYear;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public double getAvgScore() {
        return scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public abstract void showDetail();
}
