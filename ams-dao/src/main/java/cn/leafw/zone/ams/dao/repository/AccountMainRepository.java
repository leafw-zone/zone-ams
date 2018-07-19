package cn.leafw.zone.ams.dao.repository;

import cn.leafw.zone.ams.dao.entity.AccountMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:25
 */
@Repository
public interface AccountMainRepository extends JpaRepository<AccountMain,String>,JpaSpecificationExecutor<AccountMain> {
}
