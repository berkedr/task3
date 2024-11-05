import java.util.ArrayList;

public class Movie extends Material {
    ArrayList<Person> actors;
    Person director;

    public Movie(int id, String name, ArrayList<Integer> scores, int releaseYear, int price, Category category, String type, ArrayList<Person> actors, Person director) {
        super(id, name, scores, releaseYear, price, category, type);
        this.actors = actors != null ? actors : new ArrayList<>();
        this.director = director;
    }

    public void addActor(Person actor) {
        actors.add(actor);
    }

    @Override
    public void showDetail() {
        System.out.println("Movie: " + name + ", Director: " + director.firstName + " " + director.lastName + ", Avg Score: " + getAvgScore());
    }
}
