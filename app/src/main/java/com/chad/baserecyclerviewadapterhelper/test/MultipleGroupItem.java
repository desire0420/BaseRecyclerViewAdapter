package com.chad.baserecyclerviewadapterhelper.test;

import com.chad.baserecyclerviewadapterhelper.entity.Video;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleGroupItem extends SectionMultiEntity<FenGroupBean> implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int GIRD = 2;
    public static final int IMG_TEXT = 3;


    private int itemType;
    private boolean isMore;
    private FenGroupBean video;

    public MultipleGroupItem(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }

    public MultipleGroupItem(int itemType, FenGroupBean video) {
        super(video);
        this.video = video;
        this.itemType = itemType;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public FenGroupBean getVideo() {
        return video;
    }

    public void setVideo(FenGroupBean video) {
        this.video = video;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
