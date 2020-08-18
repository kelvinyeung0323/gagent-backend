package com.kelvin.goodsagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 16:30
 * @description:
 */
@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaSpecificationExecutor<T>, JpaRepository<T,ID> {

}
