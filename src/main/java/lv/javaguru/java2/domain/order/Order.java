package lv.javaguru.java2.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lv.javaguru.java2.domain.BaseEntity;
import lv.javaguru.java2.domain.interfaces.LockedResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
public class Order implements BaseEntity, LockedResource {

    private final static String IN_PROGRESS = "In progress";
    private final static String DONE = "Done";
    @Transient
    private boolean isDone = false;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "person")
    private String person;

    @Column(name = "document")
    private String document;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(name = "total")
    private long total;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "security_key")
    private String securityKey;

    @Column(name = "status")
    private String status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();
    
    public String getStatus() {
        return status;
    }
    public void setStatus(boolean isDone){
        if(isDone)
            this.status = DONE;
        else
            this.status = IN_PROGRESS;
    }

    @Override
    public String getKey() {
        return getSecurityKey();
    }
}
