package bg.softuni.Pathfinder.model.bindingModel;

import bg.softuni.Pathfinder.model.enums.CategoriesEnum;
import bg.softuni.Pathfinder.model.enums.LevelEnum;

import java.util.Set;


public class AddRouteBidingModel {
    private String name;
    private String description;

    private Set<CategoriesEnum> categories;

//    private String gpxCoordinate;

    private LevelEnum level;
    private String videoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoriesEnum> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesEnum> categories) {
        this.categories = categories;
    }
}
