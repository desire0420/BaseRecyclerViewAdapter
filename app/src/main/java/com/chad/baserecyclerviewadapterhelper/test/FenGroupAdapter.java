package com.chad.baserecyclerviewadapterhelper.test;

import android.support.annotation.NonNull;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author : wang wei
 * date   : 2019-12-03
 * desc   :
 */
public class FenGroupAdapter extends BaseSectionQuickAdapter<FenGroupSection, BaseViewHolder> {

    public FenGroupAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);


    }

    @Override
    protected void convertHead(BaseViewHolder helper, FenGroupSection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, FenGroupSection item) {
        FenGroupBean video = (FenGroupBean) item.t;
        switch (helper.getLayoutPosition() % 2) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.girl);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;
            default:
                break;

        }
        helper.setText(R.id.tv, video.getName());
        helper.addOnClickListener(R.id.tv);
    }
}
