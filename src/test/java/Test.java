import dao.BaseDao;
import entity.Hospital;
import init.InitWeb;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import propertity.ReadPropertity;

import java.util.List;
import java.util.Map;

/**
 * 总结 ：@SpringBootTest 和 @ContextConfiguration 是等价的
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@SpringBootTest(classes = {HelloWorldController.class})
@ContextConfiguration(classes = {InitWeb.class})
//@Import(ReadPropertity.class)
public class Test {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    BaseDao baseDao;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @org.junit.Test
    public void helloWordTest(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/hello")).andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    @Transactional
    public void getNameTest(){
        List<Hospital> all = baseDao.findAll();
        System.out.println(all);
    }
}
