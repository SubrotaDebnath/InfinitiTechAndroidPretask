package uk.infiniti.tech.infinititechandroidpretask.view.dashboard;

import java.util.HashMap;
import java.util.List;

public interface MainCommunicator {
    public interface MainView{
        public void actOnNavigationItem(List<String> items, HashMap<String, List<String>> subItems);
    }

    public interface MainPresenter{
        public void handelNavigationItems(List<String> items, HashMap<String, List<String>> subItems );
    }
}
