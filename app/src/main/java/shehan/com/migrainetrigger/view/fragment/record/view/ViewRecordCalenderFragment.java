package shehan.com.migrainetrigger.view.fragment.record.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import shehan.com.migrainetrigger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRecordCalenderFragment extends Fragment {


    public ViewRecordCalenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_record_calender, container, false);
    }

}