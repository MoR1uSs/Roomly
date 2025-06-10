package dao;

import java.util.List;

public class ManagementDao {
    private DaoManager<Management, Long> daoManager;

    public ManagementDao(){
        daoManager = new DaoManager<>(Management.class);
    }

    public void save(Management management){
        daoManager.save(management);
    }

    public void update(Management management){
        daoManager.update(management);
    }

    public Management findById(Long id){
        return daoManager.findById(id);
    }

    public void deleteById(Long id){
        daoManager.deleteById(id);
    }

    public List<Management> findAll(){
        return daoManager.findAll();
    }
}
