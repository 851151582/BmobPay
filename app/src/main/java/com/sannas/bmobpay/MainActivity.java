package com.sannas.bmobpay;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_goodsName;
    private EditText et_goodsPrice;
    private EditText et_goodsNum;
    private Button bt_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        et_goodsName = (EditText)findViewById(R.id.et_goodsName);
        et_goodsPrice = (EditText)findViewById(R.id.et_goodsPrice);
        et_goodsNum = (EditText)findViewById(R.id.et_goodsNum);
        bt_pay = (Button) findViewById(R.id.bt_pay);
        bt_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将获取的带的商品信息，及需付款的金额传递给PayActivity
                String goodsName = et_goodsName.getText().toString().trim();
                double goodsPrice = Double.parseDouble(et_goodsPrice.getText().toString().trim());
                int goodsNum = Integer.parseInt(et_goodsNum.getText().toString().trim());
                double payMoney = goodsNum * goodsPrice;
                Log.i("MainActivity", "名称：" + goodsName + "总额：" + payMoney);
                //开启支付界面
                Intent intent = new Intent(getApplicationContext(),PayActivity.class);
                intent.putExtra("goodsName",goodsName);
                intent.putExtra("goodsDescription",goodsName + "*" + goodsNum);
                intent.putExtra("payMoney",payMoney);
                startActivity(intent);
            }
        });
    }
}
