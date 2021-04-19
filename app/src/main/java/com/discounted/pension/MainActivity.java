package com.discounted.pension;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout[] layouts;
    private int step, yearToPension, year, exp, chooseFood, chooseHouse, chooseFamily, chooseTravel,
            chooseHobbi, answer2, answer1, yearBeforePension;
    private boolean isWoman, isMan;
    private float insurancePension, fundedPension, ipc, sIpc, storage, IPC, fixedPay = 5686.25f;
    private String result1, result2;
    private int[] foodCost, houseCost, familyCost, travelCost, hobbiCost;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        final EditText editData = findViewById(R.id.editData);
        final RadioGroup radioGroup = findViewById(R.id.radioGroupSex);
        final RadioButton radioButHe = findViewById(R.id.radioButtonHe);
        final RadioButton radioButShe = findViewById(R.id.radioButtonShe);
        final EditText editInsurer = findViewById(R.id.editInsurer);
        final EditText editExperience = findViewById(R.id.editExperience);
        final EditText editIpc = findViewById(R.id.editIpc);
        final EditText editStorage = findViewById(R.id.editStorage);
        final EditText editYearBeforePension = findViewById(R.id.editYears);


        final RadioGroup radioFood = findViewById(R.id.radioGroupFood);
        final RadioButton radioButFood1 = findViewById(R.id.radioButtonFood1);
        final RadioButton radioButFood2 = findViewById(R.id.radioButtonFood2);
        final RadioButton radioButFood3 = findViewById(R.id.radioButtonFood3);
        final RadioButton radioButFood4 = findViewById(R.id.radioButtonFood4);
        final RadioButton radioButFood5 = findViewById(R.id.radioButtonFood5);

        final RadioGroup radioHouse = findViewById(R.id.radioGroupHouse);
        final RadioButton radioButHouse1 = findViewById(R.id.radioButtonHouse1);
        final RadioButton radioButHouse2 = findViewById(R.id.radioButtonHouse2);
        final RadioButton radioButHouse3 = findViewById(R.id.radioButtonHouse3);
        final RadioButton radioButHouse4 = findViewById(R.id.radioButtonHouse4);
        final RadioButton radioButHouse5 = findViewById(R.id.radioButtonHouse5);

        final RadioGroup radioFamily = findViewById(R.id.radioGroupFamily);
        final RadioButton radioButFamily11 = findViewById(R.id.radioButtonFamily1);
        final RadioButton radioButFamily12 = findViewById(R.id.radioButtonFamily2);
        final RadioButton radioButFamily13 = findViewById(R.id.radioButtonFamily3);
        final RadioButton radioButFamily14 = findViewById(R.id.radioButtonFamily4);
        final RadioButton radioButFamily15 = findViewById(R.id.radioButtonFamily5);

        final RadioGroup radioTravel = findViewById(R.id.radioGroupTravel);
        final RadioButton radioButTravel1 = findViewById(R.id.radioButtonTravel1);
        final RadioButton radioButTravel2 = findViewById(R.id.radioButtonTrave2);
        final RadioButton radioButTravel3 = findViewById(R.id.radioButtonTravel3);
        final RadioButton radioButTravel4 = findViewById(R.id.radioButtonTravel4);
        final RadioButton radioButTravel5 = findViewById(R.id.radioButtonTravel5);

        final RadioGroup radioHobbi = findViewById(R.id.radioGroupHobbi);
        final RadioButton radioButHobbi1 = findViewById(R.id.radioButtonHobbi1);
        final RadioButton radioButHobbi2 = findViewById(R.id.radioButtonHobbi2);
        final RadioButton radioButHobbi3 = findViewById(R.id.radioButtonHobbi3);
        final RadioButton radioButHobbi4 = findViewById(R.id.radioButtonHobbi4);
        final RadioButton radioButHobbi5 = findViewById(R.id.radioButtonHobbi5);

        final TextView resLast1 = findViewById(R.id.resLast1);
        final TextView resLast2 = findViewById(R.id.resLast2);


        View.OnClickListener listen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (step == 1) {
                    isMan = radioButHe.isChecked();
                    isWoman = radioButShe.isChecked();
                    if (!isMan & !isWoman) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, выберите пол", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editData.setText("");
                }
                else if (step == 2) {
                    String data = editData.getText().toString();
                    if (data.equals("")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, укажите возраст", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    year = Integer.parseInt(data);
                    if (year < 14) {
                        Toast.makeText(MainActivity.this, "Вы еще не можете претендовать на пенсионный доход", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if ((isWoman & year >= 60) | (isMan & year >= 65)) {
                        Toast.makeText(MainActivity.this, "Вы уже имеете право обратиться за назначением пенсии", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editInsurer.setText("");
                }
                else if (step == 3) {
                    String nameComp = editInsurer.getText().toString();
                    if (nameComp.equals("")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, укажите Вашу страховую компанию", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editExperience.setText("");
                }
                else if (step == 4) {
                    String experience = editExperience.getText().toString();
                    if (experience.equals("")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, укажите Ваш стаховой опыт", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    exp = Integer.parseInt(experience);
                    editIpc.setText("");
                }
                else if (step == 5) {
                    String i = editIpc.getText().toString();
                    if (i.equals("")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, укажите Ваш ИПК", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (i.equals(".")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ipc = Float.parseFloat(i);
                    editStorage.setText("");
                }
                else if (step == 6) {
                    String str = editStorage.getText().toString();
                    if (str.equals("")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, укажите Ваши пенсионные баллы", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.equals(".")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, введите число", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    storage = Float.parseFloat(str);

                    editYearBeforePension.setText("");
                }
                else if (step == 7) {
                    String years = editYearBeforePension.getText().toString();

                    if (years.equals("")) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, укажите годы до выхода на пенсию", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    yearBeforePension = Integer.parseInt(years);

                    if (yearBeforePension > 100) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, введите корректные данные", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (isWoman) yearToPension = 60 - year;
                    else if (isMan) yearToPension = 65 - year;
                    IPC = (ipc / exp) * yearBeforePension;
                    sIpc = 93;
                    insurancePension = fixedPay + IPC * sIpc;
                    fundedPension = storage / 252;
                    answer1 = (int) (insurancePension + fundedPension);
                    result1 = Integer.toString(answer1);
                    radioGroup.clearCheck();
                }
                else if (step == 8) {

                    if (radioButFood1.isChecked()) chooseFood = 1;
                    else if (radioButFood2.isChecked()) chooseFood = 2;
                    else if (radioButFood3.isChecked()) chooseFood = 3;
                    else if (radioButFood4.isChecked()) chooseFood = 4;
                    else if (radioButFood5.isChecked()) chooseFood = 5;

                    if (chooseFood == 0) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, выберите позицию", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else if (step == 9) {
                    if (radioButHouse1.isChecked()) chooseHouse = 1;
                    else if (radioButHouse2.isChecked()) chooseHouse = 2;
                    else if (radioButHouse3.isChecked()) chooseHouse = 3;
                    else if (radioButHouse4.isChecked()) chooseHouse = 4;
                    else if (radioButHouse5.isChecked()) chooseHouse = 5;

                    if (chooseHouse == 0) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, выберите позицию", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else if (step == 10) {
                    if (radioButFamily11.isChecked()) chooseFamily = 1;
                    else if (radioButFamily12.isChecked()) chooseFamily = 2;
                    else if (radioButFamily13.isChecked()) chooseFamily = 3;
                    else if (radioButFamily14.isChecked()) chooseFamily = 4;
                    else if (radioButFamily15.isChecked()) chooseFamily = 5;

                    if (chooseFamily == 0) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, выберите позицию", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else if (step == 11) {
                    if (radioButTravel1.isChecked()) chooseTravel = 1;
                    else if (radioButTravel2.isChecked()) chooseTravel = 2;
                    else if (radioButTravel3.isChecked()) chooseTravel = 3;
                    else if (radioButTravel4.isChecked()) chooseTravel = 4;
                    else if (radioButTravel5.isChecked()) chooseTravel = 5;

                    if (chooseTravel == 0) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, выберите позицию", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else if (step == 12) {
                    if (radioButHobbi1.isChecked()) chooseHobbi = 1;
                    else if (radioButHobbi2.isChecked()) chooseHobbi = 2;
                    else if (radioButHobbi3.isChecked()) chooseHobbi = 3;
                    else if (radioButHobbi4.isChecked()) chooseHobbi = 4;
                    else if (radioButHobbi5.isChecked()) chooseHobbi = 5;

                    if (chooseHobbi == 0) {
                        Toast.makeText(MainActivity.this, "Пожалуйста, выберите позицию", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    answer2 = foodCost[chooseFood - 1] + houseCost[chooseHouse - 1] +
                            familyCost[chooseFamily - 1] + travelCost[chooseTravel - 1] + hobbiCost[chooseHobbi - 1];
                    result2 = Integer.toString(answer2);

                    resLast1.setText(result1);
                    resLast2.setText(result2);

                }

                step++;
                if (step == 15) {
                    step = 1;
                    radioFood.clearCheck();
                    radioHouse.clearCheck();
                    radioFamily.clearCheck();
                    radioTravel.clearCheck();
                    radioHobbi.clearCheck();
                }

                setLayout(step);

            }
        };

        findViewById(R.id.next).setOnClickListener(listen);
        findViewById(R.id.next1).setOnClickListener(listen);
        findViewById(R.id.next2).setOnClickListener(listen);
        findViewById(R.id.next3).setOnClickListener(listen);
        findViewById(R.id.next4).setOnClickListener(listen);
        findViewById(R.id.next5).setOnClickListener(listen);
        findViewById(R.id.next6).setOnClickListener(listen);
        findViewById(R.id.next16).setOnClickListener(listen);
        findViewById(R.id.next8).setOnClickListener(listen);
        findViewById(R.id.next9).setOnClickListener(listen);
        findViewById(R.id.next10).setOnClickListener(listen);
        findViewById(R.id.next11).setOnClickListener(listen);
        findViewById(R.id.next12).setOnClickListener(listen);
        findViewById(R.id.next14).setOnClickListener(listen);
        findViewById(R.id.next15).setOnClickListener(listen);


        layouts = new RelativeLayout[]{
                findViewById(R.id.layout1), findViewById(R.id.layout3),
                findViewById(R.id.layout2), findViewById(R.id.layout4),
                findViewById(R.id.layout5), findViewById(R.id.layout6),
                findViewById(R.id.layout7), findViewById(R.id.layout15),
                findViewById(R.id.layout8), findViewById(R.id.layout9),
                findViewById(R.id.layout10), findViewById(R.id.layout11),
                findViewById(R.id.layout12), findViewById(R.id.layout13),
                findViewById(R.id.layout14),

        };

        setLayout(0);

        foodCost = new int[]{2500, 3700, 4500, 5300, 8300};
        houseCost = new int[]{3500, 6500, 7300, 10000, 17300};
        familyCost = new int[]{1200, 3300, 3700, 5800, 15300};
        travelCost = new int[]{1300, 3000, 4000, 6000, 11300};
        hobbiCost = new int[]{250, 500, 600, 1000, 3000};
    }

    private void giveColor() {

        if (step == 13 | step == 14) {
            if (actionBar != null)
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorWindow)));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorStatLast));
            }
        }
        else if (step > 7 & step < 13) {

            if (actionBar != null)
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorState)));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorStatys));
            }
        }
        else {
            if (actionBar != null)
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }
    }


    private void setLayout(int index) {
        giveColor();
        for (int i = 0; i < layouts.length; i++) {
            layouts[i].setVisibility(i == index ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        if (step == 0) {
            finish();
        } else step--;
        setLayout(step);
    }
}



