package com.example.commoncontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2d12 extends AppCompatActivity {
    private String mRadioValue="";
    private List<String> mCheckBoxValue=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2d12);
        initWidget();
    }

    private void initWidget() {
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radiold=radioGroup.getCheckedRadioButtonId();
                switch (radiold){
                    case R.id.radio_male:
                        mRadioValue="男";
                        break;
                    case R.id.radio_female:
                        mRadioValue="女";
                        break;
                    default:
                        mRadioValue="男";
                        break;
                }
            }
        });
        CheckBox checkRun=(CheckBox) findViewById(R.id.checkbox_run);
        CheckBox checkReading=(CheckBox) findViewById(R.id.checkbox_reading);
        CheckBox checkSwim=(CheckBox) findViewById(R.id.checkbox_swim);
        checkRun.setOnCheckedChangeListener(checkedLister);
        checkReading.setOnCheckedChangeListener(checkedLister);
        checkSwim.setOnCheckedChangeListener(checkedLister);

    }
    CompoundButton.OnCheckedChangeListener checkedLister=new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            switch (compoundButton.getId()){
                case R.id.checkbox_run: {
                    if (isChecked) {
                        mCheckBoxValue.add("run");
                    } else {
                        mCheckBoxValue.remove("run");
                    }
                    break;
                }
                case R.id.checkbox_reading:{
                    if(isChecked){
                        mCheckBoxValue.add("reading");
                    }else {
                        mCheckBoxValue.remove("reading");
                    }
                    break;
                }
                case R.id.checkbox_swim:{
                    if(isChecked){
                        mCheckBoxValue.add("swimming");
                    }else {
                        mCheckBoxValue.remove("swimming");
                    }
                    break;
                }
                default:
                    break;
                }
            }
        };
}