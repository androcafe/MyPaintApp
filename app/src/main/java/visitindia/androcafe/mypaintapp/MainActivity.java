package visitindia.androcafe.mypaintapp;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.change_color:
                changeColorDialog();
                return true;
            case R.id.emboss:
                paintView.emboss();
                return true;
            case R.id.blur:
                paintView.blur();
                return true;
            case R.id.clear:
                paintView.clear();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeColorDialog() {

        final Dialog dialogChangeColor=new Dialog(MainActivity.this,R.style.ThemeOverlay_AppCompat);

        LayoutInflater layoutInflater=getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.dialog_change_color,null);

        dialogChangeColor.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialogChangeColor.setContentView(view);

        dialogChangeColor.setCancelable(true);

        LinearLayout llWhite=view.findViewById(R.id.ll_color_white);
        LinearLayout llBlack=view.findViewById(R.id.ll_color_black);
        LinearLayout llYellow=view.findViewById(R.id.ll_color_yellow);
        LinearLayout llRed=view.findViewById(R.id.ll_color_red);
        LinearLayout llBlue=view.findViewById(R.id.ll_color_blue);
        LinearLayout llGreen=view.findViewById(R.id.ll_color_green);
        LinearLayout llMagenta=view.findViewById(R.id.ll_color_magenta);
        LinearLayout llGray=view.findViewById(R.id.ll_color_gray);

        llBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.BLACK);
                dialogChangeColor.dismiss();
            }
        });

        llYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.YELLOW);
                dialogChangeColor.dismiss();
            }
        });

        llWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.WHITE);
                dialogChangeColor.dismiss();
            }
        });

        llRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.RED);
                dialogChangeColor.dismiss();
            }
        });

        llBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.BLUE);
                dialogChangeColor.dismiss();
            }
        });

        llGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.GREEN);
                dialogChangeColor.dismiss();
            }
        });

        llMagenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.MAGENTA);
                dialogChangeColor.dismiss();
            }
        });

        llGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setCurrentColor(Color.GRAY);
                dialogChangeColor.dismiss();
            }
        });
        dialogChangeColor.show();

    }
}
