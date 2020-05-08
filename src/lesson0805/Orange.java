package lesson0805;

public class Orange {
    int weight;
    String sort;

    public Orange(int weight, String sort) {
        this.weight = weight;
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                ", sort='" + sort + '\'' +
                '}';
    }
}
