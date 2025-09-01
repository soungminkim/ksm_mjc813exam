package com.mjc813.food_web.food_file.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.IFood;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodFileDto implements IFoodFile {
    private Long id;
    private String name;
    private Long size;
    private String ext;
    private String realName;
    private String dir;
    private Long foodId;

    @JsonIgnore
    private FoodDto food;

    public IFood getFood() {
        return this.food;
    }

    public void setFood(IFood food) {
        if( this.food == null ) {
            this.food = new FoodDto();
        }
        this.food.copyMembersFood(food);
    }

    @Override
    public void setFoodId(Long foodId) {
        if (this.food == null) {
            this.food = new FoodDto();
        }
        this.food.setId(foodId);
        this.foodId = foodId;
    }
}
