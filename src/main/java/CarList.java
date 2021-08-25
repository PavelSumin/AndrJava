public interface CarList {

    Car getInfo(int index);

    boolean getInfo (Car car);

    void add(Car car);

    boolean remove(Car car);

    boolean removeAt(int index);

    int size();

    void clear();

}
