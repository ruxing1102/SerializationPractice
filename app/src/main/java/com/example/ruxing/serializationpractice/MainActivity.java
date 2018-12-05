package com.example.ruxing.serializationpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ruxing.serializationpractice.entity.OuterEntity;
import com.example.ruxing.serializationpractice.entity.ParcelableEntity;
import com.example.ruxing.serializationpractice.entity.ParcelableSubclassEntity;
import com.example.ruxing.serializationpractice.entity.SerializableParentEntity;
import com.example.ruxing.serializationpractice.entity.SerializableSubclassEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private TextView mTvJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvJump = findViewById(R.id.tv_jump);
        mTvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump1();
                //jump2();
                //jump3();
            }
        });
    }

    private void jump1() {

        //基本数据
        ParcelableEntity parcelableEntity = new ParcelableEntity();
        parcelableEntity.setByteData((byte) 1);
        parcelableEntity.setShortData((short) 2);
        parcelableEntity.setIntData(3);
        parcelableEntity.setLongData(4);
        parcelableEntity.setFloatData(1.2f);
        parcelableEntity.setDoubleData(1.3);
        parcelableEntity.setCharData('c');
        parcelableEntity.setBooleanData(true);
        parcelableEntity.setStringData("string");
        parcelableEntity.setBigDecimalData(new BigDecimal(10));

        //外部类实体
        OuterEntity outerEntity = new OuterEntity();
        outerEntity.setAge(10);
        outerEntity.setName("outer-name");
        parcelableEntity.setOuterEntity(outerEntity);
        //外部类集合
        List<OuterEntity> outerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OuterEntity entity = new OuterEntity();
            entity.setAge(i);
            entity.setName("outer-name" + i);
            outerList.add(entity);
        }
        parcelableEntity.setOuterList(outerList);

        //内部类实体
        ParcelableEntity.InnerEntity innerEntity = new ParcelableEntity.InnerEntity();
        innerEntity.setAge(10);
        innerEntity.setName("inner-name");
        parcelableEntity.setInnerEntity(innerEntity);
        //内部类对象
        List<ParcelableEntity.InnerEntity> innerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ParcelableEntity.InnerEntity entity = new ParcelableEntity.InnerEntity();
            entity.setAge(i);
            entity.setName("inner-name" + i);
            innerList.add(entity);
        }
        parcelableEntity.setInnerList(innerList);

        //实体map
        Map<String, OuterEntity> map1 = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            OuterEntity entity = new OuterEntity();
            entity.setAge(i);
            entity.setName("map-entity-name" + i);
            map1.put(i + "", entity);
        }
        parcelableEntity.setMap1(map1);
        //集合map
        Map<Integer, List<OuterEntity>> map2 = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            List<OuterEntity> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                OuterEntity entity = new OuterEntity();
                entity.setAge(i);
                entity.setName("map-list-name" + i + "   " + j);
                list.add(entity);
            }
            map2.put(i, list);
        }
        parcelableEntity.setMap2(map2);

        SecondActivity.startSecondActivity(this, parcelableEntity);
    }

    private void jump2() {
        ParcelableSubclassEntity entity = new ParcelableSubclassEntity();
        entity.setParentAge(1);
        entity.setParentName("parentName");
        entity.setSubclassAge(2);
        entity.setSubclassName("subclassName");

        SecondActivity.startSecondActivity(this, entity);
    }

    private void jump3() {
        SerializableSubclassEntity entity = new SerializableSubclassEntity();
        entity.setParentAge(1);
        entity.setParentName("parentName");
        entity.setSubclassAge(2);
        entity.setSubclassName("subclassName");

        SecondActivity.startSecondActivity(this, entity);
    }

}
