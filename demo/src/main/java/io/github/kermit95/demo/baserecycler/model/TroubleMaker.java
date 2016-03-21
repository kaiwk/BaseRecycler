package io.github.kermit95.demo.baserecycler.model;

import io.github.kermit95.baserecycler.ItemViewModel;

/**
 * Created by kermit on 16/3/21.
 */
public class TroubleMaker implements ItemViewModel {


    public static final int VIEW_TYPE = 1;

    @Override
    public int getViewType() {
        return VIEW_TYPE;
    }
}
