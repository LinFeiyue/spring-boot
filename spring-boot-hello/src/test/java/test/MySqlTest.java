package test;

import com.springboot.example.configuration.JpaConfiguration;
import com.springboot.example.entity.User;
import com.springboot.example.repository.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MySqlTest {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MySqlTest.class);

	//话说是代码检查的问题，去intellij的setting里面设置下级别就好了
    //不通过@ContextConfiguration(classes = {JpaConfiguration.class})去加载上下文
    //直接使用@SpringBootTest注解,或 @DataJpaTest
    @Autowired
    UserRepository userRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();;
    }

    public void findPage(){
        Pageable pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));

        Page<User> page = userRepository.findAll(pageable);

        Assert.notNull(page);

        for (User user : page){
            logger.info("===user=== user name:{},department name:{},role name:{}",
                        user.getName(),user.getDepartment().getName(),user.getRoles().get(0).getName());
        }
    }

}
