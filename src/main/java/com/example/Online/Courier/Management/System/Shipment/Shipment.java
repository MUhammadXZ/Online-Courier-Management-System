package com.example.Online.Courier.Management.System.Shipment;
import com.example.Online.Courier.Management.System.Delivery.Delivery;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "destination")
    private String destination;



    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveries = new ArrayList<>();;

    public Shipment() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public Shipment(String description, String destination, List<Delivery> deliveries) {
        this.description = description;
        this.destination = destination;
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", destination='" + destination + '\'' +
                ", deliveries=" + deliveries +
                '}';
    }
}

