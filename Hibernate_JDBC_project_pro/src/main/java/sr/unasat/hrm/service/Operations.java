package sr.unasat.hrm.service;

public interface Operations<T> {

    void save(T entity);
    void findAll();
    void findById(int id);
    void update(T entity);
    void delete(T entity);
}
