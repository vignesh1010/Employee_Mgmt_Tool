package com.rbsagile.tcsrbs.Repository;

import com.rbsagile.tcsrbs.domain.BackLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackLogRepository extends CrudRepository<BackLog,Long> {

}
