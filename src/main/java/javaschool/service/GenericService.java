package javaschool.service;

public interface GenericService<T, PK> {
    T add(T object);

    T get(PK id);

    void delete(PK id);

    void update(T object);

}
