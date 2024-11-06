import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create Persons
        Person writer1 = new Person(1, "berke", "nurcan", 40);
        Person actor1 = new Person(2, "berra", "talha", 35);
        Person director1 = new Person(3, "adem", "mehmet", 50);

        // Create Categories
        Category category1 = new Category(1, "FIC", "Fiction");
        Category category2 = new Category(2, "ACT", "Action");

        // Create Movies
        ArrayList<Integer> movieScores = new ArrayList<>();
        movieScores.add(8);
        movieScores.add(9);
        ArrayList<Person> actors = new ArrayList<>();
        actors.add(actor1);
        Movie movie1 = new Movie(1, "Action Movie", movieScores, 2021, 100, category2, "movie", actors, director1);

        // Create Books
        ArrayList<Integer> bookScores = new ArrayList<>();
        bookScores.add(7);
        bookScores.add(6);
        Book book1 = new Book(2, "Great Book", bookScores, 2020, 50, category1, "book", writer1, 300);

        // Create User
        User user = new User(10, "Alice", "Johnson", 30, "testUser", "123456");

        // Create Netflix instance
        Netflix netflix = new Netflix(new ArrayList<>());

        // Login and add materials
        netflix.login(user);
        netflix.addMovie(movie1);
        netflix.addBook(book1);

        // Run Netflix functionalities
        netflix.showHighestAvgScoreMaterial();
        netflix.showLowestAvgScoreMovie();
        netflix.showMostExpensiveMaterialInCategory(1);
        netflix.showMoviesByActor(2);
    }
}
