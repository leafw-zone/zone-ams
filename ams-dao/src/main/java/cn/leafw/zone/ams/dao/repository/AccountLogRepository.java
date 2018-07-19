package cn.leafw.zone.ams.dao.repository;

import cn.leafw.zone.ams.api.dto.AccountLogDto;
import cn.leafw.zone.ams.dao.entity.AccountLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:26
 */
@Repository
public interface AccountLogRepository extends JpaRepository<AccountLog,String>,JpaSpecificationExecutor<AccountLog>{

    @Query(nativeQuery = true, value = "SELECT sum(t.change_amount),t.consume_type from account_log t GROUP BY t.consume_type;")
    List<AccountLogDto> queryGroupByConsumeType();
}
