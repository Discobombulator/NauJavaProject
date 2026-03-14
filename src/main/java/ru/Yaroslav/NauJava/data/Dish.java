package ru.Yaroslav.NauJava.data;

public class Dish {
    private Long id;
    private String name;
    private Double weight;
    private Integer kilocalories;
    private Integer protein;
    private Integer fat;
    private Integer carbohydrates;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getKilocalories() {
        return kilocalories;
    }

    public Integer getFat() {
        return fat;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setKilocalories(Integer kilocalories) {
        this.kilocalories = kilocalories;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
