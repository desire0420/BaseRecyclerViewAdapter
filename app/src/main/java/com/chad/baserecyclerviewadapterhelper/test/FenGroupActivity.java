package com.chad.baserecyclerviewadapterhelper.test;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.baserecyclerviewadapterhelper.R;
import com.chad.baserecyclerviewadapterhelper.SectionUseActivity;
import com.chad.baserecyclerviewadapterhelper.adapter.SectionAdapter;
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.data.DataServer;
import com.chad.baserecyclerviewadapterhelper.decoration.GridSectionAverageGapItemDecoration;
import com.chad.baserecyclerviewadapterhelper.entity.MySection;
import com.chad.baserecyclerviewadapterhelper.entity.Video;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author : wang wei
 * date   : 2019-12-03
 * desc   :
 * <p>
 * <p>
 * 分组布局
 * 实体类必须继承SectionEntity
 */
public class FenGroupActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private List<FenGroupSection> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_uer);
        setBackBtn();
        setTitle("Section Use");
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));
        getSampleData();


        FenGroupAdapter mAdapter = new FenGroupAdapter(R.layout.item_section_content, R.layout.def_section_head, mData);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                FenGroupSection mySection = mData.get(position);
                if (mySection.isHeader) {
                    //头部点击
                    Toast.makeText(FenGroupActivity.this, "ha--" + mySection.header, Toast.LENGTH_LONG).show();
                } else {
                    //子布局点击
                    Toast.makeText(FenGroupActivity.this, "ddd--" + mySection.t.getName(), Toast.LENGTH_LONG).show();
                }
            }
        });

        //more  点击事件
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(FenGroupActivity.this, "onItemChildClick" + position, Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }


    public void getSampleData() {
        for (int i = 0; i < 10; i++) {
            mData.add(new FenGroupSection(true, "Section 1", true));//头部
            for (int j = 0; j < 6; j++) {
                //内容
                FenGroupBean bean = new FenGroupBean("http://pic38.nipic.com/20140225/2531170_214014788000_2.jpg", "我是内容--" + j);
                mData.add(new FenGroupSection(bean));
            }


        }

    }

}
