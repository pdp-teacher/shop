package common;

import java.util.List;

public interface Repository<ENTITY extends BaseEntity<ID>,ID> {


 ENTITY save(ENTITY entity);

 void delete(ID id);

 ENTITY findByID(ID id);

 List<ENTITY> getAll();




}
