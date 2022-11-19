package uz.crud.healthline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import uz.crud.balance.R;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private Adapter adapter;
    private List<ModelObject> models;
//    Integer [] colors=null;
//    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 1000;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 2700; // time in milliseconds between successive task executions.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models=new ArrayList<>();
        models.add(new ModelObject(R.drawable.pager1,"Title","Description"));
        models.add(new ModelObject(R.drawable.pager1,"Title","Description"));
        models.add(new ModelObject(R.drawable.pager1,"Title","Description"));
        models.add(new ModelObject(R.drawable.pager1,"Title","Description"));
        models.add(new ModelObject(R.drawable.pager1,"Title","Description"));
        models.add(new ModelObject(R.drawable.pager1,"Title","Description"));

        adapter=new Adapter(models,this);
        viewPager=findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);


        viewPager.setAdapter(adapter);
//        viewPager.setPadding(100,0,100,0);

        Integer [] colors_temp={getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

//        colors=colors_temp;

//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(position<(adapter.getCount()-1) && position<(colors.length-1))
//                {
//                    viewPager.setBackgroundColor(
//
//                            (Integer) argbEvaluator.evaluate(
//                                    positionOffset,
//                                    colors[position],
//                                    colors[position+1]
//                            )
//                    );
//
//                }else
//                {
////                    getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),colors[colors.length-1]));
//                    viewPager.setBackgroundColor(colors[colors.length-1]);
//                }
//            }

//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == models.size()-1) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage++, true);
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}