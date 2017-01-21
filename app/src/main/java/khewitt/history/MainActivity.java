package khewitt.history;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements ListOfFragments.OnFragmentInteractionListener {

    private int mCurrentPos;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DetailFragment.ARG_POSITION,mCurrentPos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInf= getMenuInflater();
        menuInf.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* if (savedInstanceState != null) {
            mCurrentPos = savedInstanceState.getInt(DetailFragment.ARG_POSITION,-1);
            DetailFragment detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_details, detailFragment).commit();
            if(mCurrentPos!=-1) {
                detailFragment.updateDetails(mCurrentPos);
            }
            return;
        }*/
        ListOfFragments fragmentList = new ListOfFragments();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_list, fragmentList).commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.back_button:
                goBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFragmentInteraction(int position){
        mCurrentPos = position;
        //DetailFragment detailFrag = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_details);
        DetailFragment detailFragment = new DetailFragment();

       /* if(isLandscape()){
            if(detailFrag!=null){
                detailFrag.updateDetails(position);
            }
           else {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_details, detailFragment).commit();
            }
        }
        else {
*/
            Bundle myBundle = new Bundle();
            myBundle.putInt(DetailFragment.ARG_POSITION, position);
            detailFragment.setArguments(myBundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_list, detailFragment).commit();
        //}

    }

    @Override
    public void onBackPressed() {
        goBack();
    }
/*
    public boolean isLandscape(){
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }
*/
    public void goBack(){
        ListOfFragments fragmentList = new ListOfFragments();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_list, fragmentList).commit();

    }

}
