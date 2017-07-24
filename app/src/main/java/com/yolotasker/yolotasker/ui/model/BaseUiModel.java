package com.yolotasker.yolotasker.ui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AndroidDev on 15.07.2017.
 */

public class BaseUiModel {

    private Integer id;

    private String title;

    private int price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
