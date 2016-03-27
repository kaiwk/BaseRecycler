package io.github.kermit95.demo.baserecycler.model;

import io.github.kermit95.baserecycler.ItemViewModel;
import io.github.kermit95.demo.Constant;

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
    public static final int SOME_THING_DIFFERENT = 1;

    @Override
    public int getViewType() {
        if (name.equals(Constant.datas[4])){
            return SOME_THING_DIFFERENT;
        }
        return VIEW_TYPE;
    }
}
