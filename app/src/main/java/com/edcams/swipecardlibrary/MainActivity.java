package com.edcams.swipecardlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.edcams.swipecard.SwipeAdapterView;
import com.edcams.swipecardlibrary.adapter.SwipeCardAdapter;
import com.edcams.swipecardlibrary.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeCardAdapter swipeCardAdapter;
    private List<Cars> carsList;
    private SwipeAdapterView swipeAdapterView;
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeAdapterView = (SwipeAdapterView) findViewById(R.id.swipeView);

        carsList = new ArrayList<>();
        //populating list;
        populateCars();

        swipeCardAdapter = new SwipeCardAdapter(carsList, this);

        swipeAdapterView.setAdapter(swipeCardAdapter);
        swipeAdapterView.setMaxVisible(6);
        swipeAdapterView.setFlingListener(new SwipeAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                carsList.remove(0);
                swipeCardAdapter.notifyDataSetChanged();
                Log.d(MainActivity.class.getSimpleName(), "Cards in view: " + swipeAdapterView.getChildCount());
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                Toast.makeText(getApplicationContext(), "Left!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRightCardExit(Object dataObject) {

                Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                Log.d(MainActivity.class.getSimpleName(), "Adding more cards");
                populateCars();
                swipeCardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = swipeAdapterView.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        swipeAdapterView.setOnItemClickListener(new SwipeAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Log.d(MainActivity.class.getSimpleName(), "Clicked item position: " + itemPosition);
            }
        });
    }

    private void populateCars() {

        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/88/74/Tu63AP.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://eskipaper.com/images/black-ferrari-background-1.jpg", "Test Desc"));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/4/6/fb2M6I.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/88/74/Tu63AP.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://eskipaper.com/images/black-ferrari-background-1.jpg", "Test Desc"));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/4/6/fb2M6I.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/88/74/Tu63AP.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://eskipaper.com/images/black-ferrari-background-1.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/4/6/fb2M6I.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/88/74/Tu63AP.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://eskipaper.com/images/black-ferrari-background-1.jpg", "Test Desc "));
        carsList.add(new Cars("Car " + (counter++), "http://cdn.wallpapersafari.com/4/6/fb2M6I.jpg", "Test Desc "));


    }
}
