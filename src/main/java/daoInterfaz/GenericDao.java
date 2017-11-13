package daoInterfaz;

public interface GenericDao<E> {
	public E crear();
	public void guardar(E entidad);
	public E get(String id);
	public void delete(String id);
}
