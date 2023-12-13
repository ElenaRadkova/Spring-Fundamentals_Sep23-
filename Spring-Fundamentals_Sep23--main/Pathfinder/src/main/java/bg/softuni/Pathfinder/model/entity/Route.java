package bg.softuni.Pathfinder.model.entity;

import bg.softuni.Pathfinder.model.enums.SectionEnum;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private SectionEnum section;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private User author;
    @ManyToMany
//    @JoinTable(name = "routes_categories", joinColumns = {@JoinColumn(name = "route_entity_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "categories_id", referencedColumnName = "id")})
    private Set<Categories> categories;

    @Column(name = "video_url")
    private String videoUrl;

    public Route() {
        this.categories = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public SectionEnum getSection() {
        return section;
    }

    public void setSection(SectionEnum section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addCategories(Set<Categories> categories) {
        this.categories.addAll(categories);
    }
}
