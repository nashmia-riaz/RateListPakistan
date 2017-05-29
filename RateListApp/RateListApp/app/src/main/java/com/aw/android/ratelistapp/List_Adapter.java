package com.aw.android.ratelistapp;

/**
 * Created by Taha-PC on 5/28/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aw.android.ratelistapp.model.item;

import java.util.List;

public class List_Adapter extends BaseAdapter implements OnClickListener {
    private Context context;

    private List<item> listItem;

    public List_Adapter(Context context, List<item> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    public int getCount() {
        return listItem.size();
    }

    public Object getItem(int position) {
        return listItem.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        item entry = listItem.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        TextView itemprice = (TextView) convertView.findViewById(R.id.itemprice);
        itemprice.setText(entry.getRate());

        TextView itemname = (TextView) convertView.findViewById(R.id.itemname);
        itemname.setText(entry.getName());



//        // Set the onClick Listener on this button
//        Button btnRemove = (Button) convertView.findViewById(R.id.btnRemove);
//        btnRemove.setFocusableInTouchMode(false);
//        btnRemove.setFocusable(false);
//        btnRemove.setOnClickListener(this);
//        // Set the entry, so that you can capture which item was clicked and
//        // then remove it
//        // As an alternative, you can use the id/position of the item to capture
//        // the item
//        // that was clicked.
//        btnRemove.setTag(entry);

        // btnRemove.setId(position);


        return convertView;
    }

    @Override
    public void onClick(View view) {
        item entry = (item) view.getTag();
        listItem.remove(entry);
        // listPhonebook.remove(view.getId());
        notifyDataSetChanged();

    }

    private void showDialog(item entry) {
        // Create and show your dialog
        // Depending on the Dialogs button clicks delete it or do nothing
    }

}
