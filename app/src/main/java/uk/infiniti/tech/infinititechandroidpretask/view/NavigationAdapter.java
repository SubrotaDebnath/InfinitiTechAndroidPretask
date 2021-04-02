package uk.infiniti.tech.infinititechandroidpretask.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.infiniti.tech.infinititechandroidpretask.R;

public class NavigationAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> items;
    private HashMap<String, List<String>> subItems;

    private String TAG = "NavigationAdapter";

    public NavigationAdapter(Context context, List<String> items, HashMap<String, List<String>> subItems) {
        this.context = context;
        this.items = items;
        this.subItems = subItems;

//        Log.i(TAG, "Item Count: "+ items.size());
//        Log.i(TAG, "Sub Item Count: "+ subItems.get(items.get(1)).size());
    }

    @Override
    public int getGroupCount() {
        Log.i(TAG, "Group Count: " + items.size());
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Log.i(TAG, "child Count: " + subItems.get(items.get(groupPosition)).size());
        if (subItems.get(items.get(groupPosition)) != null && !subItems.get(items.get(groupPosition)).equals("")) {
            return subItems.get(items.get(groupPosition)).size();
        } else {
            return 0;
        }

    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return subItems.get(items.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //String item = getGroup(groupPosition).toString();
        String item = items.get(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, null);
        }

        TextView itemText = (TextView) convertView.findViewById(R.id.itemTV);
        itemText.setText(item);

        Log.i(TAG, "Item name: " + item);
        Log.i(TAG, "Item position: " + groupPosition);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String subItem = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sub_item_layout, null);
        }

        TextView subItemText = (TextView) convertView.findViewById(R.id.subItemTV);
        subItemText.setText(subItem);
        Log.i(TAG, "Sub Item name: " + subItem);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Sub Item name: " + subItem);
                Toast.makeText(v.getContext(), subItem + " Selected", Toast.LENGTH_SHORT).show();

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
