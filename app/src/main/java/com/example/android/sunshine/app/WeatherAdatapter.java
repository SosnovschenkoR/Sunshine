package com.example.android.sunshine.app;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 1 on 02.11.2014.
 */
public class WeatherAdatapter extends ArrayAdapter {
    private Context context;
    private ArrayList<String> list;
    @LayoutRes
    private int resource;

    public WeatherAdatapter(Context context, int resource, final ArrayList<String> list) {
        super(context, resource, list);
        this.context = context;
        this.list = list;
        this.resource = resource;
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Получение объекта inflater из контекста
        LayoutInflater inflater = LayoutInflater.from(context);
        //Если someView (View из ListView) вдруг оказался равен
        //null тогда мы загружаем его с помошью inflater
        if (view == null) {
            view = inflater.inflate(resource, viewGroup, false);
        }
        //Обявляем наши текствьюшки и связываем их с разметкой
        TextView textView = (TextView) view.findViewById(R.id.list_item_forecast_textview);
        TextView textNum = (TextView) view.findViewById(R.id.list_item_forecast_num);

        //Устанавливаем в каждую текствьюшку соответствующий текст
        // сначала заголовок
        textView.setText(list.get(i));
        // потом подзаголовок
        textNum.setText(String.valueOf(i));
        return view;
    }
}
