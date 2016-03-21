package io.github.kermit95.demo.baserecycler.model;

import io.github.kermit95.baserecycler.ItemViewModel;

/**
 * Created by kermit on 16/3/21.
 */
public class Person implements ItemViewModel{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final int VIEW_TYPE = 0;

    @Override
    public int getViewType() {
        return VIEW_TYPE;
    }
}
