package common;

import java.util.List;

public interface Repository <ENTITY,ID> {



    ENTITY save(ENTITY entity);
    void delete(ID id);
    List<ENTITY> getAll();


}
