package lv.javaguru.java2.domain.order;

import lombok.Getter;
import lombok.Setter;
import lv.javaguru.java2.domain.BaseEntity;
import lv.javaguru.java2.domain.interfaces.LockedResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    @Getter
    @Setter
    private long id;

    @Column(name = "person")
    @Getter
    @Setter
    private String person;

    @Column(name = "document")
    @Getter
    @Setter
    private String document;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @Column(name = "phone")
    @Getter
    @Setter
    private String phone;

    @Column(name = "order_date")
    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "delivery_date")
    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column(name = "total")
    @Getter
    @Setter
    private long total;

    @Column(name = "user_id")
    @Getter
    @Setter
    private long userId;

    @Column(name = "security_key")
    @Getter
    @Setter
    private String securityKey;

    @Getter
    @Setter
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
