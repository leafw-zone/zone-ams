package cn.leafw.zone.ams.dao.repository;

import cn.leafw.zone.ams.dao.entity.ConsumeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 15:35
 */
@Repository
public interface ConsumeConfigRepository extends JpaRepository<ConsumeConfig,String> {

    List<ConsumeConfig> findByChangeType(String changeType);
}
