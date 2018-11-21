package es.ulpgc.gs1.gs1prototype.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vetorders")
public class VetOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;

    private Date OrderCreatedDate;
    private String PaymentType;
    private double amount;
    @OneToOne(fetch = FetchType.EAGER)
    private Address billAddress;
    private boolean payed;
    @OneToOne(fetch = FetchType.EAGER)
    private PayerInfo payerinfo;

    public VetOrder(Date orderCreatedDate, String paymentType, double amount, Address billAddress, boolean payed, PayerInfo payerinfo) {
        OrderCreatedDate = orderCreatedDate;
        PaymentType = paymentType;
        this.amount = amount;
        this.billAddress = billAddress;
        this.payed = payed;
        this.payerinfo = payerinfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderCreatedDate() {
        return OrderCreatedDate;
    }

    public void setOrderCreatedDate(Date orderCreatedDate) {
        OrderCreatedDate = orderCreatedDate;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public PayerInfo getPayerinfo() {
        return payerinfo;
    }

    public void setPayerinfo(PayerInfo payerinfo) {
        this.payerinfo = payerinfo;
    }
}
