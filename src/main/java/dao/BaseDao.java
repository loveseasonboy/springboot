package dao;

import entity.Hospital;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by hehd on 2017/2/22.
 *
 * @author 何海东
 */
public interface BaseDao {
    List<Hospital> findAll();

    Map<String, Object> findOneById(int val);

    Map<String, Object> findOneByName(@Param("name") String name);

    Map<String, Object> findOne(Map map);

    List<Map<String, Object>> searchInfo(Hospital hospital);

    List<Map<String,Object>> test1();

}
