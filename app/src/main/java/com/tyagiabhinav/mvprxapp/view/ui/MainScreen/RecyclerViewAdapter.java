package com.tyagiabhinav.mvprxapp.view.ui.MainScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tyagiabhinav.mvprxapp.MVPRxAPP;
import com.tyagiabhinav.mvprxapp.R;
import com.tyagiabhinav.mvprxapp.model.pojo.Restaurant;
import com.tyagiabhinav.mvprxapp.util.Constants;
import com.tyagiabhinav.mvprxapp.view.ui.DetailScreen.RestaurantDetailActivity;
import com.tyagiabhinav.mvprxapp.view.ui.DetailScreen.RestaurantDetailFragment;

import java.text.DecimalFormat;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by abhinavtyagi on 14/02/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private  Context mContext;
    private boolean mTwoPane;
    private final List<Restaurant> mRestaurants;

    @Inject
    Picasso picasso;

    public RecyclerViewAdapter(Context context, boolean twoPane, List<Restaurant> restaurants) {
        mContext = context;
        mTwoPane = twoPane;
        mRestaurants = restaurants;
        MVPRxAPP.getAppComponent().inject(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Restaurant restaurant = mRestaurants.get(position);
        holder.mItem = restaurant;

        // set auto select for first restaurant in case of two pane mode
        if (mTwoPane && position == 0) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(Constants.SELECTED_RESTAURANT, holder.mItem);
            arguments.putBoolean(Constants.TWO_PANE, false);

            RestaurantDetailFragment fragment = new RestaurantDetailFragment();
            fragment.setArguments(arguments);
            ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.restaurant_detail_container, fragment)
                    .commit();
        }


        // bind ui views with data
        picasso.load(restaurant.getIconUrl())
                .into(holder.icon);

        if (restaurant.isOpen())
            holder.isOpen.setImageResource(R.drawable.green_dot);
        else
            holder.isOpen.setImageResource(R.drawable.yellow_dot);

        DecimalFormat df = new DecimalFormat("#.##");
        holder.distance.setText(Float.valueOf(df.format(restaurant.getDistance())) + "km");
        holder.name.setText(restaurant.getName());

        if (restaurant.getPhone() != null && !TextUtils.isEmpty(restaurant.getPhone())) {
            holder.phone.setText(restaurant.getPhone());
        } else {
            holder.phone.setVisibility(View.INVISIBLE);
        }

        holder.rating.setText(restaurant.getRating() + "/10");

        int price = restaurant.getPrice();

        StringBuilder priceIcons = new StringBuilder();
        for (int i = 0; i < price; i++) {
            priceIcons.append("$");
        }
        holder.priceTier.setText(priceIcons.toString());

        // grid item click listener
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putParcelable(Constants.SELECTED_RESTAURANT, holder.mItem);
                if (mTwoPane) {
                    RestaurantDetailFragment fragment = new RestaurantDetailFragment();
                    arguments.putBoolean(Constants.TWO_PANE, true);
                    fragment.setArguments(arguments);
                    ((AppCompatActivity) mContext).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.restaurant_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, RestaurantDetailActivity.class);
                    arguments.putBoolean(Constants.TWO_PANE, false);
                    intent.putExtras(arguments);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        @BindView(R.id.icon)
        ImageView icon;

        @BindView(R.id.isOpen)
        ImageView isOpen;

        @BindView(R.id.distance)
        TextView distance;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.phone)
        TextView phone;

        @BindView(R.id.rating)
        TextView rating;

        @BindView(R.id.priceTier)
        TextView priceTier;

        public Restaurant mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }
    }
}