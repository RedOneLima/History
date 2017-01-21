package khewitt.history;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOfFragments extends ListFragment {
    private OnFragmentInteractionListener mListener;

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(int id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null) {
            ArrayAdapter<String> fillList = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1, ListAndDetails.YEARS);
            setListAdapter(fillList);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        //if(getFragmentManager().findFragmentById(R.id.fragment_details)!=null){
          //  getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
       // }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mListener.onFragmentInteraction(position);
        getListView().setItemChecked(position,true);
    }

}
