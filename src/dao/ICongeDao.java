package dao;

public interface ICongeDao<T, ID> {

    T trouverParId(ID id);
}
