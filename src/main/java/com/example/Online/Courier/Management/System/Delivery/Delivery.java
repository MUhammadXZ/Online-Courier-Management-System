package com.example.Online.Courier.Management.System.Delivery;

import com.example.Online.Courier.Management.System.Shipment.Shipment;
import jakarta.persistence.*;

@Entity
@Table(name="delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "status")
    private String status;



    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    public Delivery() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Delivery(String status, Shipment shipment) {
        this.status = status;
        this.shipment = shipment;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", shipment=" + shipment +
                '}';
    }
}

