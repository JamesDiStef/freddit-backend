package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "subreddits")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subreddit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Column(unique = true, nullable = false)
    private String name;
    
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "sidebar_content", columnDefinition = "TEXT")
    private String sidebarContent;
    
    @Column(name = "icon_url")
    @Size(max = 255, message = "Icon URL must not exceed 255 characters")
    private String iconUrl;
    
    @Column(name = "banner_url")
    @Size(max = 255, message = "Banner URL must not exceed 255 characters")
    private String bannerUrl;
    
    @Builder.Default
    @Column(name = "is_private")
    private Boolean isPrivate = false;
    
    @Builder.Default
    @Column(name = "is_nsfw")
    private Boolean isNsfw = false;
    
    @Builder.Default
    @Column(name = "subscriber_count")
    private Integer subscriberCount = 0;
    
    @NotNull(message = "Creator is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "subreddit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;
    
    @OneToMany(mappedBy = "subreddit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subscription> subscriptions;
}
