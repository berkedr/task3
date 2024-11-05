
import java.util.ArrayList;

public class Netflix {
    ArrayList<Material> materials;
    User credential;
    boolean isLogin = false;

    public Netflix(ArrayList<Material> materials) {
        this.materials = materials != null ? materials : new ArrayList<>();
    }

    public void login(User user) {
        if ("testUser".equals(user.userName) && "123456".equals(user.password)) {
            isLogin = true;
            credential = user;
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }

    public void addMovie(Movie m) {
        if (isLogin) materials.add(m);
    }

    public void addBook(Book b) {
        if (isLogin) materials.add(b);
    }

    public void addMaterial(Material m) {
        if (isLogin) materials.add(m);
    }

    public void showHighestAvgScoreMaterial() {
        Material maxAvgScoreMaterial = materials.stream()
                .max((m1, m2) -> Double.compare(m1.getAvgScore(), m2.getAvgScore()))
                .orElse(null);
        if (maxAvgScoreMaterial != null) {
            System.out.println("Material with highest avg score:");
            maxAvgScoreMaterial.showDetail();
        }
    }

    public void showLowestAvgScoreMovie() {
        Material minAvgScoreMovie = materials.stream()
                .filter(m -> m instanceof Movie)
                .min((m1, m2) -> Double.compare(m1.getAvgScore(), m2.getAvgScore()))
                .orElse(null);
        if (minAvgScoreMovie != null) {
            System.out.println("Movie with lowest avg score:");
            minAvgScoreMovie.showDetail();
        }
    }

    public void showMostExpensiveMaterialInCategory(int categoryId) {
        Material mostExpensiveMaterial = materials.stream()
                .filter(m -> m.category.id == categoryId)
                .max((m1, m2) -> Integer.compare(m1.price, m2.price))
                .orElse(null);
        if (mostExpensiveMaterial != null) {
            System.out.println("Most expensive material in category " + categoryId + ":");
            mostExpensiveMaterial.showDetail();
        }
    }

    public void showMoviesByActor(int personId) {
        System.out.println("Movies with actor ID " + personId + ":");
        materials.stream()
                .filter(m -> m instanceof Movie)
                .map(m -> (Movie) m)
                .filter(movie -> movie.actors.stream().anyMatch(actor -> actor.id == personId))
                .forEach(Movie::showDetail);
    }
}
