package dao;

import model.Workspace;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class WorkspacesDao {
    public void saveWorkspace(Workspace workspace) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(workspace);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error saving workspace: " + e.getMessage());
        }
    }

    public Workspace getWorkspaceById(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Workspace.class, id);
        } catch (Exception e){
            System.out.println("Error retrieving workspace: " + e.getMessage());
            return null;
        }
    }

    public Workspace getWorkspaceByName(String name){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Workspace WHERE name = :name", Workspace.class)
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e){
            System.out.println("Error retrieving workspace: " + e.getMessage());
            return null;
        }
    }

    public List<Workspace> getAllWorkspaces(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Workspace", Workspace.class).list();
        } catch (Exception e){
            System.out.println("Error retrieving workspaces: " + e.getMessage());
            return null;
        }
    }
}
