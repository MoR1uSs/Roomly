package dao;

import model.Workspace;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class WorkspaceDao {
    private DaoManager<Workspace, Long> daoManager;

    public WorkspaceDao(){
        daoManager = new DaoManager<>(Workspace.class);
    }

    public void save(Workspace workspace){
        daoManager.save(workspace);
    }

    public void update(Workspace workspace){
        daoManager.update(workspace);
    }

    public Workspace getById(Long id){
        return daoManager.findById(id);
    }

    public void deleteById(Long id){
        daoManager.deleteById(id);
    }

    public List<Workspace> getAllWorkspaces(){
        return daoManager.findAll();
    }

    public Workspace getWorkspaceByName(String name){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("FROM Workspace WHERE name = :name", Workspace.class)
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e){
            System.out.println("Error retrieving workspace: " + e.getMessage());
            return null;
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public List<Workspace> searchWorkspacesByName(String name){
        if(name == null || name.isEmpty()){
            return Collections.emptyList();
        }
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Query<Workspace> query = session.createQuery("FROM Workspace WHERE name LIKE :name", Workspace.class);
            query.setParameter("name", "%" + name + "%");
            return query.list();
        } catch (Exception e){
            System.out.println("Error searching workspaces: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
