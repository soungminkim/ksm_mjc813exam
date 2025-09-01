package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto implements IIngredient {
    private Long id;
    private String name;

    private Long ingredientCategoryId;
    private String ingredientCategoryName;

//    @JsonIgnore
    private IngredientCategoryDto ingredientCategoryDto;    // Dto 는 객체를 사용하지 않습니다. IIngredient 인터페이스 때문에 등장

    @Override
    public IIdName getIngredientCategory() {
        return this.ingredientCategoryDto;
    }

    @Override
    public void setIngredientCategory(IIdName ingredientCategory) {
        if( this.ingredientCategoryDto == null ) {
            this.ingredientCategoryDto = new IngredientCategoryDto();
        }
        this.ingredientCategoryDto.copyMembersIdName(ingredientCategory);
    }

    @Override
    public Long getIngredientCategoryId() {
        // Long ingredientCategoryId 값과 IngredientCategoryDto ingredientCategoryDto.getId() 값이 항상 같도록 get 하는 기능
        if ( this.ingredientCategoryDto != null ) {
            return this.ingredientCategoryDto.getId();
        }
        return this.ingredientCategoryId;
    }

    @Override
    public void setIngredientCategoryId(Long ingredientCategoryId) {
        // Long ingredientCategoryId 값과 IngredientCategoryDto ingredientCategoryDto.getId() 값이 항상 같도록 set 하는 기능
        if (ingredientCategoryId == null) {
            if (this.ingredientCategoryDto != null && this.ingredientCategoryDto.getId() != null) {
                this.ingredientCategoryId = this.ingredientCategoryDto.getId();
            }
            return;
        }
        this.ingredientCategoryId = ingredientCategoryId;
        if (this.ingredientCategoryDto == null) {
            this.ingredientCategoryDto = new IngredientCategoryDto();
        }
        this.ingredientCategoryDto.setId(ingredientCategoryId);
    }
//
//    private Long checkId() {
//        if ( this.getIngredientCategoryDto() == null ) {
//            this.ingredientCategoryDto = new IngredientCategoryDto();
//            this.ingredientCategoryDto.setId(0L);
//        }
//        if ( this.ingredientCategoryId == null ) {
//            this.ingredientCategoryId = 0L;
//        }
//        if ( this.ingredientCategoryId.equals(this.getIngredientCategoryDto().getId()) ) {
//            return this.ingredientCategoryId;
//        } else {
//            return 0L;
//        }
//    }
}
