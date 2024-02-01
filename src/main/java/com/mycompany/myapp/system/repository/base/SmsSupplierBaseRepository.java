package com.mycompany.myapp.system.repository.base;

import com.diboot.core.mapper.BaseCrudMapper;
import com.mycompany.myapp.system.domain.SmsSupplier;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.NoRepositoryBean;

// jhipster-needle-add-import - JHipster will add getters and setters here, do not remove

/**
 * Spring Data JPA repository for the SmsSupplier entity.
 */
@SuppressWarnings("unused")
@NoRepositoryBean
public interface SmsSupplierBaseRepository<E extends SmsSupplier> extends BaseCrudMapper<SmsSupplier> {
    default List<SmsSupplier> findAll() {
        return this.selectList(null);
    }

    default Optional<SmsSupplier> findById(Long id) {
        return Optional.ofNullable(this.selectById(id));
    }
    // jhipster-needle-repository-add-method - JHipster will add getters and setters here, do not remove

}
