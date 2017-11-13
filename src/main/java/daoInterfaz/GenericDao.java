package daoInterfaz;

import java.util.List;

public interface GenericDao<E> {
	public void guardar(E entidad);
	public E get(String id);
	public void delete(String id);
	public List<E> leer();
}
