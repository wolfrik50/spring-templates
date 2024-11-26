package io.wulfcodes.mvc.model.data;

public class ClubData {
    private Long id;
    private String title;
    private String photoUrl;
    private String content;

    public static class ClubDataBuilder {
        private Long id;
        private String title;
        private String photoUrl;
        private String content;

        private ClubDataBuilder() {}

        public ClubDataBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ClubDataBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ClubDataBuilder setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public ClubDataBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public ClubData build() {
            return new ClubData(id, title, photoUrl, content);
        }
    }

    public ClubData() {}

    public ClubData(Long id, String title, String photoUrl, String content) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.content = content;
    }

    public static ClubDataBuilder getBuilder() {
        return new ClubDataBuilder();
    }

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

    @Override
    public String toString() {
        return "Club{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", photoUrl='" + photoUrl + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
