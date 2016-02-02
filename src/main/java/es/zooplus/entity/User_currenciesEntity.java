package es.zooplus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "User_currencies")
@Table(name="USER_CURRENCIES")
public class User_currenciesEntity {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;

    @Column(name="ID_USER")
    private Integer id_user;
    
    @Column(name="EURO")
    private String euro;
 
    @Column(name="SP")
    private String sp;
 
    @Column(name="YEN")
    private String yen;    

    @Column(name="TIME_CREATED")
    private Date time_created; 
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }
    
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    } 
    
    public String getEuro() {
        return euro;
    }
    
    public void setEuro(String euro) {
        this.euro = euro;
    }

    public String getSp() {
        return sp;
    }
    
    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getYen() {
        return yen;
    }
    
    public void setYen(String yen) {
        this.yen = yen;
    }

    public Date getTime_created() {
        return time_created;
    }
    
    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }     
}
