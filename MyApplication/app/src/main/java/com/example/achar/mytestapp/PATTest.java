package com.example.achar.mytestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.LoginFilter;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PATTest extends AppCompatActivity {

    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv_pat)
    TextView tv_pat;


    int n = 0;
    int num = 0;

    /**
     * 卡拉兹(Callatz)猜想：
     * <p>
     * 对任何一个自然数n，如果它是偶数，那么把它砍掉一半；如果它是奇数，那么把(3n+1)
     * 砍掉一半。这样一直反复砍下去，最后一定在某一步得到n=1。卡拉兹在1950年的世界数学家大会上公布了这个猜想，传说当时耶鲁大学师生齐动员，拼命想证明这个貌似很傻很天真的命题，结果闹得学生们无心学业，一心只证(3n+1)
     * ，以至于有人说这是一个阴谋，卡拉兹是在蓄意延缓美国数学界教学与科研的进展……
     * <p>
     * 我们今天的题目不是证明卡拉兹猜想，而是对给定的任一不超过1000的正整数n，简单地数一下，需要多少步（砍几下）才能得到n=1？
     * <p>
     * 输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。
     * <p>
     * 输出格式：输出从n计算到1需要的步数。
     * <p>
     * 输入样例：
     * 3
     * 输出样例：
     * 5
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattest);
        ButterKnife.bind(this);
        //OK，我现在还缺少就是：
        //1.规定这个数不超过1000
        //2.规定这个数是正整数
        //3.约束输入的内容


        //这里可以约束这个edittext输入限制的内容，想要什么就在MyInputFilter的参数中传入，不包含在这里面即使输入了也不会被接收和显示
        //这样的话，就是说我现在只能输入这些个数字了，但是还是有0在前面的情况，因此我要排除它
//        InputFilter[] filters = new InputFilter[1];
//        filters[0] = new MyInputFilter("0123456789");
//        et.setFilters(filters);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                int len = s.toString().length();
                if (len == 1 && text.equals("0")) {
                    s.clear();

                }
                if (s.toString().length() > 3) {
                    s.delete(3, 4);
                    Toast toast = Toast.makeText(PATTest.this, "不能超过1000", Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new MyInputFilter("0123456789");
        et.setFilters(filters);
    }


    public class MyInputFilter extends LoginFilter.UsernameFilterGeneric {
        private String mAllowedDigits;

        public MyInputFilter(String digits) {
            mAllowedDigits = digits;
        }

        @Override
        public boolean isAllowed(char c) {
            if (mAllowedDigits.indexOf(c) != -1) {
                return true;
            }
            return false;
        }
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        if (et.getText() != null) {
            int i = Integer.parseInt(et.getText().toString());
            if (i != 0) {
                while (i != 1) {
                    if (i % 2 == 0) {
                        i = i / 2;
                    } else {
                        i = (3 * i + 1) / 2;
                    }
                    num++;
                }
                tv_pat.setText("计算结果是：" + num);
                num = 0;
            }
        }

    }
}
