package com.example.ruxing.serializationpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ruxing.serializationpractice.entity.OuterEntity;
import com.example.ruxing.serializationpractice.entity.ParcelableEntity;
import com.example.ruxing.serializationpractice.entity.ParcelableSubclassEntity;
import com.example.ruxing.serializationpractice.entity.SerializableSubclassEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by ruxing on 2018/12/3.
 */

public class SecondActivity extends Activity {

    public static final String PARAM_ENTITY_1 = "entity1";
    public static final String PARAM_ENTITY_2 = "entity2";
    public static final String PARAM_ENTITY_3 = "entity3";

    public static void startSecondActivity(Activity activity, ParcelableEntity entity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(PARAM_ENTITY_1, entity);
        activity.startActivity(intent);
    }

    public static void startSecondActivity(Activity activity, ParcelableSubclassEntity entity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(PARAM_ENTITY_2, entity);
        activity.startActivity(intent);
    }

    public static void startSecondActivity(Activity activity, SerializableSubclassEntity entity) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(PARAM_ENTITY_3, entity);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        log1();
        //log2();
        //log3();

    }

    private void log1() {
        ParcelableEntity entity = getIntent().getParcelableExtra(PARAM_ENTITY_1);
        Log.i("ruxing", "传递过来的byte类型数据是：" + entity.getByteData());
        Log.i("ruxing", "传递过来的short类型数据是：" + entity.getShortData());
        Log.i("ruxing", "传递过来的int类型数据是：" + entity.getIntData());
        Log.i("ruxing", "传递过来的long类型数据是：" + entity.getLongData());
        Log.i("ruxing", "传递过来的float类型数据是：" + entity.getFloatData());
        Log.i("ruxing", "传递过来的double类型数据是：" + entity.getDoubleData());
        Log.i("ruxing", "传递过来的char类型数据是：" + entity.getCharData());
        Log.i("ruxing", "传递过来的boolean类型数据是：" + entity.isBooleanData());
        Log.i("ruxing", "传递过来的string类型数据是：" + entity.getStringData());
        Log.i("ruxing", "传递过来的BigDecimal类型数据是：" + entity.getBigDecimalData());
        Log.i("ruxing", "外部实体类：" + entity.getOuterEntity().getAge() + "  " + entity.getOuterEntity().getName());
        for (int i = 0; i < entity.getOuterList().size(); i++) {
            Log.i("ruxing", "外部集合实体类：" + i + "   " + entity.getOuterList().get(i).getAge() + "  " + entity.getOuterList().get(i).getName());
        }
        Log.i("ruxing", "内部实体类：" + entity.getInnerEntity().getAge() + "  " + entity.getInnerEntity().getName());
        for (int i = 0; i < entity.getOuterList().size(); i++) {
            Log.i("ruxing", "内部集合实体类：" + i + "   " + entity.getInnerList().get(i).getAge() + "  " + entity.getInnerList().get(i).getName());
        }
        for(Map.Entry<String,OuterEntity> entry:entity.getMap1().entrySet()){
            Log.i("ruxing","map-entity"+entry.getKey()+"   "+entry.getValue().getAge()+"  "+entry.getValue().getName());
        }
        for(Map.Entry<Integer,List<OuterEntity>> entry:entity.getMap2().entrySet()){
            for(OuterEntity entity1:entry.getValue()){
                Log.i("ruxing","map-list"+entry.getKey()+"   "+entity1.getAge()+"  "+entity1.getName());
            }
        }
    }

    private void log2() {
        ParcelableSubclassEntity entity = getIntent().getParcelableExtra(PARAM_ENTITY_2);
        Log.i("ruxing", "Parcelable------parentAge=" + entity.getParentAge() + "  parentName=" + entity.getParentName() + "  subclassAge=" + entity.getSubclassAge() + "  subclassName=" + entity.getSubclassName());
    }

    private void log3() {
        SerializableSubclassEntity entity = (SerializableSubclassEntity) getIntent().getSerializableExtra(PARAM_ENTITY_3);
        Log.i("ruxing", "Serializable------parentAge=" + entity.getParentAge() + "  parentName=" + entity.getParentName() + "  subclassAge=" + entity.getSubclassAge() + "  subclassName=" + entity.getSubclassName());
    }
}
