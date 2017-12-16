package service;

import dao.BaseDao;
import entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceImpl implements IService {

    @Autowired
    BaseDao baseDao;
    @Override
    public List<Hospital> getHospitalList() {
        return baseDao.findAll();
    }
}
