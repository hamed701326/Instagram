package configue.hibernate;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public abstract class CrudRepository <Entity,Id extends Serializable> {
    private Session session;

    protected abstract Class<Entity> getEntityClass();
    protected abstract Session getSession();

    public Id save(Entity entity){
        Id id = null;
        getSession().beginTransaction();
        id = (Id)getSession().save(entity);
        getSession().getTransaction();
        return id;
    }

    public void update(Entity entity){
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction();
    }

    public Entity findById(Id id){
        getSession().beginTransaction();
        Entity entity = (Entity) getSession().load(getEntityClass().getName(), (Serializable) id);
        getSession().getTransaction();
        return entity;
    }

    public List<Entity> findAll(){
        getSession().beginTransaction();
        List<Entity> entities = (List<Entity>) getSession()
                .createQuery("from "+getEntityClass().getName());
        getSession().getTransaction();
        return entities;
    }

    public void remove(Entity entity){
        getSession().beginTransaction();
        getSession().remove(entity);
        getSession().getTransaction().commit();
    }

    public<Attribute> Entity load(Attribute attribute){
        getSession().beginTransaction();
        Entity entity = (Entity) getSession()
                .createQuery("from "+ getEntityClass()+" where "+attribute);
        getSession().getTransaction();
        return entity;
    }
}

