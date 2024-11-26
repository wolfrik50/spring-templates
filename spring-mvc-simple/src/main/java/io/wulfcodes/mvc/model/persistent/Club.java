package io.wulfcodes.mvc.model.persistent;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "clubs")
public class Club {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String photoUrl;
    private String content;
    //@CreationTimestamp
    private LocalDateTime createdOn;
    //@UpdateTimestamp
    private LocalDateTime updatedOn;

    public Club() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public String toString() {
        return "Club{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", photoUrl='" + photoUrl + '\'' +
            ", content='" + content + '\'' +
            ", createdOn=" + createdOn +
            ", updatedOn=" + updatedOn +
            '}';
    }
}
