package eg.emad.horoscope365.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import eg.emad.horoscope365.R;

/**
 * Created by emad on 2/10/19.
 */

public class CustomSpinnnerAdapter {
    public ArrayAdapter<String> getSpinnerAdapter(Context context, String[] abraj)
    {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_item, abraj){
            @Override
            public boolean isEnabled(int position) {
                if (position == 0){
                    return false;
                }else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = (TextView) view;
                if (position == 0)
                {
                    textView.setTextColor(Color.GRAY);
                }else {
                    textView.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
        return spinnerAdapter;
    }
}

