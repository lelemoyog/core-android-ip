package com.issah.myrecipes.util;

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
