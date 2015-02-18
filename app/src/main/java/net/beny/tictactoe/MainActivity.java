package net.beny.tictactoe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int ruch = 1;

    public void klik(View view) {
        // Do something in response to button click
        // Log.i("TAG", zx.toString());
        Button button = (Button) view;

        if ( ruch%2 != 0 ) {
            button.setText(R.string.x);
            button.setEnabled(false);
            ruch++;

        } else {
            button.setText(R.string.o);
            button.setEnabled(false);
            ruch++;
        }
    }

    }
