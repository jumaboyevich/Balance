package uz.crud.balance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<ModelObject> models;
    private LayoutInflater inflater;
    private Context context;

    public Adapter(List<ModelObject> models, Context context) {
        this.models = models;
        this.context = context;
    }


    @Override
    public int getCount() {


        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater=LayoutInflater.from(context);

        View view=inflater.inflate(R.layout.item, container,false);
//        TextView title=view.findViewById(R.id.txtTitle);
//        TextView description=view.findViewById(R.id.txtDescription);
//        title.setText(models.get(position).getTitle());
//        description.setText(models.get(position).getDesk());
        container.addView(view,0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
         container.removeView((View)object);
    }

}
