package khewitt.history;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;

import android.widget.TextView;

import javax.swing.text.View;

public class DetailFragment extends Fragment {
    public static final String ARG_POSITION = "position";
    private int mPos =-1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mPos = savedInstanceState.getInt(ARG_POSITION);
        }

        return inflater.inflate(R.layout.fragment_details, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateDetails(args.getInt(ARG_POSITION));
        } else if (mPos != -1) {

            updateDetails(mPos);
        }
    }

    public void updateDetails(int pos) {
        TextView text = (TextView) getActivity().findViewById(R.id.detail_text);
        text.setText(ListAndDetails.YEARS[pos] + ":\n\n" + ListAndDetails.DETAILS[pos]);
        text.setMovementMethod(new ScrollingMovementMethod());
        mPos = pos;
    }
}
