package com.swigatto.swigatto.transformer;

import com.swigatto.swigatto.dto.request.MenuRequest;
import com.swigatto.swigatto.dto.response.MenuResponse;
import com.swigatto.swigatto.model.MenuItem;
import java.util.List;

public class MenuTransformer {
    public static MenuItem MenuRequestToMenuItem(MenuRequest menuRequest) {
        return MenuItem.builder()
                .dishName(menuRequest.getDishName())
                .price(menuRequest.getPrice())
                .foodCategory(menuRequest.getFoodCategory())
                .veg(menuRequest.isVeg())
                .available(menuRequest.isAvailable())
                .build();
    }
    public static MenuResponse MenuToMenuResponse(MenuItem menuItem) {
        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .price(menuItem.getPrice())
                .foodCategory(menuItem.getFoodCategory())
                .veg(menuItem.isVeg())
                .build();
    }

    public static List<MenuResponse> MenuItemsToMenuResponseList(List<MenuItem> menuItemList) {
        return menuItemList.stream().map(MenuTransformer::MenuToMenuResponse).toList();
    }
}
