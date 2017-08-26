package qingyun.ele.domain.db;
// Generated 2017-7-2 10:45:38 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRole generated by hbm2java
 */
@Entity
@Table(name="user_role"
    ,catalog="ele"
)
public class UserRole  implements java.io.Serializable {


     private Long id;
     private Long idUser;
     private Long idRole;
     private Long isPrim;

    public UserRole() {
    }

    public UserRole(Long idUser, Long idRole, Long isPrim) {
       this.idUser = idUser;
       this.idRole = idRole;
       this.isPrim = isPrim;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="id_user")
    public Long getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    @Column(name="id_role")
    public Long getIdRole() {
        return this.idRole;
    }
    
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
    
    @Column(name="is_prim")
    public Long getIsPrim() {
        return this.isPrim;
    }
    
    public void setIsPrim(Long isPrim) {
        this.isPrim = isPrim;
    }




}

