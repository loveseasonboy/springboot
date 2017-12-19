import entity.Hospital;
import init.ServerInit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@ContextConfiguration(classes={ServerInit.class})
public class ServerTest {

    @Autowired()
    IService iService;

    @Test
    public void test(){
        List<Hospital> hospitalList = iService.getHospitalList();
        System.out.println(hospitalList);
    }


}
