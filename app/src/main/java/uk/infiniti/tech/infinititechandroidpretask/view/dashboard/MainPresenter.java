package uk.infiniti.tech.infinititechandroidpretask.view.dashboard;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainPresenter implements MainCommunicator.MainPresenter {
    private Context context;
    private MainCommunicator.MainView view;

    private List<String> items;
    private HashMap<String, List<String>> subItems;

    public MainPresenter(Context context, MainCommunicator.MainView view) {
        this.context = context;
        this.view = view;
        items = new ArrayList<>();
        subItems = new HashMap<>();
    }

    @Override
    public void handelNavigationItems(List<String> items, HashMap<String, List<String>> subItems ) {
        this.items = items;
        this.subItems = subItems;

        createExpandableItems();
        view.actOnNavigationItem(items, subItems);
    }

    private void createExpandableItems() {

        items.add("Item-1");
        items.add("Item-2");
        items.add("Item-3");

        List<String> item1 = new ArrayList<>();

        item1.add("SubItem-1");
        item1.add("SubItem-2");
        item1.add("SubItem-3");

        subItems.put("Item-1", item1);


        List<String> item2 = new ArrayList<>();
        item2.add("SubItem-1");
        item2.add("SubItem-2");

        subItems.put("Item-2", item2);
    }

}
