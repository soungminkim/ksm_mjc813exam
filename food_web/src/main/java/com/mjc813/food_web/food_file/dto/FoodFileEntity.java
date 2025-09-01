package com.mjc813.food_web.food_file.dto;

import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.IFood;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "FoodFileEntity")
@Table(name = "food_file_tbl")
public class FoodFileEntity implements IFoodFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Column(length = 10, nullable = false)
    private String ext;

    @Column(length = 200, nullable = false)
    private String realName;

    @Column(length = 20, nullable = false)
    private String dir;

    @Transient  // create table 컬럼을 만들지 마세요
    private Long foodId;

    @JoinColumn(name = "food_id", nullable = false)
    @ManyToOne
    private FoodEntity foodEntity;

    @Override
    public IFood getFood() {
        return this.foodEntity;
    }

    @Override
    public Long getFoodId() {
        if ( this.foodEntity == null ) {
            this.foodEntity = new FoodEntity();
        }
        return this.foodEntity.getId();
    }

    @Override
    public void setFoodId(Long foodId) {
        if (this.foodEntity == null) {
            this.foodEntity = new FoodEntity();
        }
        this.foodEntity.setId(foodId);
        this.foodId = foodId;
    }

    @Override
    public void setFood(IFood food) {
        if ( this.foodEntity == null ) {
            this.foodEntity = new FoodEntity();
        }
        this.foodEntity.copyMembersFood(food);
    }
}
