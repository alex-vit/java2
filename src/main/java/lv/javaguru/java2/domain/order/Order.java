package lv.javaguru.java2.domain.order;

import lombok.Getter;
import lombok.Setter;
import lv.javaguru.java2.domain.BaseEntity;
import lv.javaguru.java2.domain.interfaces.LockedResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
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

    @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines = new ArrayList<>();

    @Column(name = "status")
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(boolean isDone){
        this.status = isDone ? DONE : IN_PROGRESS;
    }

    @Override
    public String getKey() {
        return getSecurityKey();
    }
}
