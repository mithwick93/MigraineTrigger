package shehan.com.migrainetrigger.view.fragment.record.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;

import shehan.com.migrainetrigger.R;
import shehan.com.migrainetrigger.controller.RecordController;
import shehan.com.migrainetrigger.data.model.Record;
import shehan.com.migrainetrigger.utility.AppUtil;
import shehan.com.migrainetrigger.view.adapter.RecordViewAdapter;
import shehan.com.migrainetrigger.view.model.RecordViewData;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRecordListFragment extends Fragment {

    private Toast mToast;
    private RecordListListener mCallback;
    public ViewRecordListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_record_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.record_list_recycler_view);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // 3. create an adapter
        RecordViewAdapter severityViewAdapter = new RecordViewAdapter(getRecordViewData());

        // 4. set adapter
        recyclerView.setAdapter(severityViewAdapter);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (RecordListListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement RecordListListener");
        }
    }

    private void showToast(String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(getContext(), message, Toast.LENGTH_SHORT);
        mToast.show();
    }

    private RecordViewData[] getRecordViewData() {
        ArrayList<Record> recordArrayList = RecordController.getAllRecords();

        RecordViewData recordViewData[] = new RecordViewData[recordArrayList.size()];

        for (int i = 0; i < recordArrayList.size(); i++) {
            Record record = recordArrayList.get(i);
            String start = "-";
            String duration = "-";
            int intensity;

            if (record.getStartTime() != null) {
                start = AppUtil.getFriendlyStringDate(record.getStartTime());

                if (record.getEndTime() != null) {
                    Timestamp startTime = record.getStartTime();
                    Timestamp endTime = record.getEndTime();

                    if (startTime != null) {
                        if (endTime != null) {
                            long difference = endTime.getTime() - startTime.getTime();
                            long differenceInSeconds = difference / DateUtils.SECOND_IN_MILLIS;
                            duration = AppUtil.getFriendlyDuration(differenceInSeconds);
                        }
                    }
                }
            }


            switch (record.getIntensity()) {
                case 1:
                    intensity = R.drawable.num_1;
                    break;
                case 2:
                    intensity = R.drawable.num_2;
                    break;
                case 3:
                    intensity = R.drawable.num_3;
                    break;
                case 4:
                    intensity = R.drawable.num_4;
                    break;
                case 5:
                    intensity = R.drawable.num_5;
                    break;
                case 6:
                    intensity = R.drawable.num_6;
                    break;
                case 7:
                    intensity = R.drawable.num_7;
                    break;
                case 8:
                    intensity = R.drawable.num_8;
                    break;
                case 9:
                    intensity = R.drawable.num_9;
                    break;
                case 10:
                    intensity = R.drawable.num_10;
                    break;
                default:
                    intensity = 0;
                    break;
            }

            recordViewData[i] = new RecordViewData(start, duration, intensity);
        }

        return recordViewData;
    }

    //Parent activity must implement this interface to communicate
    public interface RecordListListener {
        void onRecordListCallBack();
    }

}
