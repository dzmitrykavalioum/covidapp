package com.dzmitrykavalioum.covidapp.ui.countryitem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dzmitrykavalioum.covidapp.R;
import com.dzmitrykavalioum.covidapp.model.Country;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CountryItemActivity extends AppCompatActivity {

    private TextView tv_item_country;
    private ListView lv_specifications;
    private List<String> specifications;
    private Country country;
    private ArrayAdapter<String> arrayAdapter;

    public CountryItemActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_item);
        initViews();
        Bundle arguments = getIntent().getExtras();
        if (arguments!=null){
            country = (Country)arguments.getSerializable(Country.class.getSimpleName());
            tv_item_country.setText(country.getCountry());
        }

        Method[] methods = country.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if ((m.getName().startsWith("get") || m.getName().startsWith("is"))
                    && m.getParameterCount() == 0 && !m.getReturnType().equals(void.class)) {
                try {
                    Object f = m.invoke(country);
                    if (f != null) {
                        //Log.d("field",m.getName().substring(3)+" = "+ f.toString());
                        specifications.add(m.getName().substring(3)+"\t\t\t\t\t\t"+ f.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        arrayAdapter.notifyDataSetChanged();

    }

    private void initViews (){
        tv_item_country = findViewById(R.id.tv_item_country);
        lv_specifications = findViewById(R.id.lv_item_specifications);
        specifications = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,specifications);
        lv_specifications.setAdapter(arrayAdapter);

    }
}
