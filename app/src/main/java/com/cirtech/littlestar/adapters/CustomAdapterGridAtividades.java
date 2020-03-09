package com.cirtech.littlestar.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.cirtech.littlestar.R;

public class CustomAdapterGridAtividades extends BaseAdapter {
    private Context context;
    private String[] fruitname;
    private int[] images;

    public CustomAdapterGridAtividades(Context context, String[] fruitname, int[] images) {

        this.context = context;
        this.fruitname = fruitname;
        this.images = images;
//            super(context,R.layout.component_list_style,images);
    }

    @Override
    public int getCount() {
        return this.images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {

            view = LayoutInflater.from(this.context).inflate(R.layout.component_grid_style, parent, false);
            ViewHolder holder = new ViewHolder(view);
        } else {
            view = convertView;
        }
//            View view = getLayoutInflater().inflate(R.layout.component_list_style,null);
        ImageView image = view.findViewById(R.id.idImagemToGrid);
        TextView text = view.findViewById(R.id.idTextToGrid);

        image.setImageResource(images[position]);
        text.setText(fruitname[position]);

        return view;
    }

    public class ViewHolder {

        final ImageView image;
        final TextView texto;

        public ViewHolder(View view) {
            image = view.findViewById(R.id.idImagemToGrid);
            texto = view.findViewById(R.id.idTextToGrid);
        }
    }
}