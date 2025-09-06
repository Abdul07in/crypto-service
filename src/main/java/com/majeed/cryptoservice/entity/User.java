package com.majeed.cryptoservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users", schema = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Common identifiers
    @Column(nullable = false, unique = true, length = 150)
    private String email;  // also used as username (normalized)

    @Column(nullable = false, length = 100)
    private String displayName;  // e.g., "Alice Doe"

    // For federated login (OAuth2)
    @Column(length = 100)
    private String provider;  // e.g., "MICROSOFT", "LOCAL"

    @Column(length = 255)
    private String providerUserId; // MS/Azure AD objectId or sub claim

    // Security
    @Column(length = 255)
    private String passwordHash; // null if OAuth2-only user

    @Column(nullable = false)
    private Boolean active = true;

    // Metadata
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
