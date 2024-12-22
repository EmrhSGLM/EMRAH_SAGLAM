package pojos;

import java.util.List;

public class PetPojo {

    private int id;
    private CategoryPojo category;
    private String name;
    private List<String> photoUrls;
    private List<TagPojo> tags;
    private String status;

    public PetPojo() {
    }

    public PetPojo(int id, CategoryPojo category, String name, List<String> photoUrls, List<TagPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryPojo getCategory() {
        return category;
    }

    public void setCategory(CategoryPojo category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<TagPojo> getTags() {
        return tags;
    }

    public void setTags(List<TagPojo> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetPojo{" + '\n' +
                "\t id=" + id + '\n' +
                "\t category=" + category + '\n' +
                "\t name='" + name + '\n' +
                "\t photoUrls=" + photoUrls + '\n' +
                "\t tags=" + tags + '\n' +
                "\t status='" + status + '\n' +
                '}';
    }
}
