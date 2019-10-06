package com.practice.joshua.storycards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;


public class ItemFragment extends Fragment {

    private Story mStory;
    private static final String STORY_KEY = "story_key";


    public ItemFragment() {
    }

    public static ItemFragment newInstance(Story story) {

        Bundle args = new Bundle();
        args.putParcelable(STORY_KEY, story);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_item, container, false);

        Bundle args = getArguments();
        if (args == null) throw new AssertionError();

        mStory = args.getParcelable(STORY_KEY);
        if (mStory == null) throw new AssertionError();

//      display text and image
        TextView nameText = (TextView) rootView.findViewById(R.id.nameText);
        nameText.setText(mStory.getName());

        TextView descriptionText = (TextView) rootView.findViewById(R.id.descriptionText);
        descriptionText.setText(mStory.getDescription());

        NumberFormat formatter = NumberFormat.getInstance();
        String pageNum = formatter.format(mStory.getPage());
        TextView pageNumText = (TextView) rootView.findViewById(R.id.pageNumText);
        pageNumText.setText("Page : "+pageNum);

        String productId = mStory.getStoryId();
        int imageResource = getActivity().getResources()
                .getIdentifier(productId, "drawable", getActivity().getPackageName());
        ImageView iv = (ImageView) rootView.findViewById(R.id.imageView);
        iv.setImageResource(imageResource);

        return rootView;
    }
}
