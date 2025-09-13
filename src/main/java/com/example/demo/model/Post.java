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
@Table(name = "posts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Title is required")
    @Size(max = 300, message = "Title must not exceed 300 characters")
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "post_type")
    @Builder.Default
    private String postType = "TEXT";
    
    @Size(max = 500, message = "URL must not exceed 500 characters")
    private String url;
    
    @Column(name = "image_url")
    @Size(max = 500, message = "Image URL must not exceed 500 characters")
    private String imageUrl;
    
    @Column(name = "video_url")
    @Size(max = 500, message = "Video URL must not exceed 500 characters")
    private String videoUrl;
    
    @Builder.Default
    private Integer upvotes = 0;
    
    @Builder.Default
    private Integer downvotes = 0;
    
    @Builder.Default
    @Column(name = "comment_count")
    private Integer commentCount = 0;
    
    @Builder.Default
    @Column(name = "is_nsfw")
    private Boolean isNsfw = false;
    
    @Builder.Default
    @Column(name = "is_locked")
    private Boolean isLocked = false;
    
    @Builder.Default
    @Column(name = "is_stickied")
    private Boolean isStickied = false;
    
    @NotNull(message = "Author is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
    
    @NotNull(message = "Subreddit is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subreddit_id", nullable = false)
    private Subreddit subreddit;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;
}
