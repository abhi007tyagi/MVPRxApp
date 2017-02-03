package com.tyagiabhinav.mvprxapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.tyagiabhinav.mvprxapp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        EditText et = (EditText) findViewById(R.id.inputText);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.getText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void updateView(String data) {
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText(data);
    }
}
