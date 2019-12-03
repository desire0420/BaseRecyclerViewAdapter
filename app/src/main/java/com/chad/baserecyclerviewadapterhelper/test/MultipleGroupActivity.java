package com.chad.baserecyclerviewadapterhelper.test;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.SectionMultipleItemUseActivity;
import com.chad.baserecyclerviewadapterhelper.adapter.SectionMultipleItemAdapter;
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.data.DataServer;
import com.chad.baserecyclerviewadapterhelper.entity.SectionMultipleItem;
import com.chad.baserecyclerviewadapterhelper.entity.Video;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author : wang wei
 * date   : 2019-12-03
 * desc   :
 */
public class MultipleGroupActivity extends BaseActivity {
    List<MultipleGroupItem> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_uer);
        setBackBtn();
        setTitle("SectionMultiple Use");
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSectionMultiData();
        MultipleGroupAdapter mAdapter = new MultipleGroupAdapter(R.layout.def_section_head, mData);
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.addHeaderView(top);


        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleGroupItem item = (MultipleGroupItem) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.card_view:
                        // 获取主体item相应数据给后期使用
                        if (item.getVideo() != null) {
                            Toast.makeText(MultipleGroupActivity.this, item.getVideo().getName(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.tv:
                        Toast.makeText(MultipleGroupActivity.this, "文字点击了", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(MultipleGroupActivity.this, "OnItemChildClickListener " + position, Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }


    public void getSectionMultiData() {
        FenGroupBean main = new FenGroupBean("http://pic38.nipic.com/20140225/2531170_214014788000_2.jpg", "首页");

      //  mData.add(SectionMultipleItem(MultipleGroupItem.GIRD, main));


        for (int i = 0; i < 3; i++) {
            mData.add(new MultipleGroupItem(true, "Section 1", true));//头部
            //内容
            FenGroupBean bean = new FenGroupBean("http://pic38.nipic.com/20140225/2531170_214014788000_2.jpg", "我是内容--");
            mData.add(new MultipleGroupItem(MultipleGroupItem.TEXT, bean));
            mData.add(new MultipleGroupItem(MultipleGroupItem.TEXT, bean));
            mData.add(new MultipleGroupItem(MultipleGroupItem.IMG_TEXT, bean));


        }

    }


}
