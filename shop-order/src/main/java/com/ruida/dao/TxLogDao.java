package com.ruida.dao;

import com.ruida.domain.TxLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxLogDao extends JpaRepository<TxLog,String> {
}
