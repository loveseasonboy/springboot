package service;

import dao.BaseDao;
import entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceImpl implements IService {
    @Override
    public Hospital getHospital() {
        //获取类上面的@Controller注解
        //Controller  controller =IServiceImpl.class.getAnnotation(Controller.class);

        return null;
    }

    @Autowired
    BaseDao baseDao;
    @Override
    public List<Hospital> getHospitalList() {
        return baseDao.findAll();
    }
}
