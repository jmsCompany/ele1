package qingyun.ele.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import qingyun.ele.domain.db.CustomerDevice;


public interface CustomerDeviceRepository extends JpaRepository<CustomerDevice,Long> {

    @Query("select c from CustomerDevice c where c.idCustomer=?1 and c.deleted=0")
    public Page<CustomerDevice> findByProjectId(Long projectId, Pageable pageable);
    
    @Query("select c from CustomerDevice c where c.dataloggerSn=?1 and c.deleted=0")
    public List<CustomerDevice> findBydataloggerSn(String dataloggerSn);
    
}
