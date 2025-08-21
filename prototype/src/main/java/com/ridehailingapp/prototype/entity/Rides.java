package com.ridehailingapp.prototype.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rides")
@Data
@NoArgsConstructor

public class Rides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    // You don't need these direct column mappings. The @ManyToOne and @JoinColumn
    // annotations below handle it for you.
    // private Long passengerId;
    // private Long driverId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_requested")
    private VehicleType vehicleRequested;

    @Column(name = "pickup_latitude")
    private Double pickupLatitude;

    @Column(name = "pickup_longitude")
    private Double pickupLongitude;

    @Column(name = "destination_latitude")
    private Double destinationLatitude;

    @Column(name = "destination_longitude")
    private Double destinationLongitude;

    @Column(name = "fare")
    private Double fare;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private User passenger;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}