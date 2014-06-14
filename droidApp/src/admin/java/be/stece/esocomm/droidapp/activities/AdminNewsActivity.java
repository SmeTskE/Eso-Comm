package be.stece.esocomm.droidapp.activities;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;

/**
 * Created by Stece on 9/06/2014.
 */
public class AdminNewsActivity extends ExpandableListActivity {

    private ExpandableListView listView;
    public static final int REQUEST_NEWS_ADD_EDIT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.expandable_list_content);
        listView = (ExpandableListView) getExpandableListView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin_news_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_add_news:
                addNewsItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addNewsItem(){
        Intent intent = new Intent(this, AdminNewsItemActivity.class);
        startActivityForResult(intent, REQUEST_NEWS_ADD_EDIT);
    }

    private void editNewsItem(){
        Intent intent = new Intent(this, AdminNewsItemActivity.class);
        // todo: add news item to edit as extra to intent
        startActivityForResult(intent, REQUEST_NEWS_ADD_EDIT);
    }
}
