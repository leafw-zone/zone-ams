package cn.leafw.zone.ams.dao.repository;

import cn.leafw.zone.ams.dao.entity.AccountLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:26
 */
@Repository
public interface AccountLogRepository extends JpaRepository<AccountLog,String>,JpaSpecificationExecutor<AccountLog>{
}
