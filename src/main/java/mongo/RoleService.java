package mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenzhao on 14-5-13.
 */
@Service
public class RoleService {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertRole(Role role){
        this.mongoTemplate.insert(role);
    }

    public void deleteRoleById(String id){
        this.mongoTemplate.remove(Query.query(Criteria.where("id").is(id)),Role.class);
    }

    public List<Role> listRole(){
        return this.mongoTemplate.findAll(Role.class);
    }
}
