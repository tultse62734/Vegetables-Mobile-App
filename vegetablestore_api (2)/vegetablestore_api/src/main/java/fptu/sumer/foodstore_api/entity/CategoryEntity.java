package fptu.sumer.foodstore_api.entity;

import javax.persistence.*;

@Entity
@Table(name = "Category", schema = "dbo", catalog = "SmartFarm")
public class CategoryEntity {
    private int categoryId;
    private String categoryName;
    private String categoryUrl;
    public CategoryEntity() {
    }

    @Id
    @Column(name = "CategoryId")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @Basic
    @Column(name = "CategoryUrl")
    public String getCategoryUrl() {
        return categoryUrl;
    }
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }
}
