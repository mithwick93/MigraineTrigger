package shehan.com.migrainetrigger.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import shehan.com.migrainetrigger.R;
import shehan.com.migrainetrigger.view.fragment.faq.AlternativeFragment;
import shehan.com.migrainetrigger.view.fragment.faq.CausesFragment;
import shehan.com.migrainetrigger.view.fragment.faq.ComplicationsFragment;
import shehan.com.migrainetrigger.view.fragment.faq.DefinitionFragment;
import shehan.com.migrainetrigger.view.fragment.faq.DiagnosisFragment;
import shehan.com.migrainetrigger.view.fragment.faq.FAQTopicsFragment;
import shehan.com.migrainetrigger.view.fragment.faq.PreventionFragment;
import shehan.com.migrainetrigger.view.fragment.faq.RemediesFragment;
import shehan.com.migrainetrigger.view.fragment.faq.RiskFragment;
import shehan.com.migrainetrigger.view.fragment.faq.SymptomsFragment;
import shehan.com.migrainetrigger.view.fragment.faq.TreatmentsFragment;

public class FAQActivity
        extends AppCompatActivity
        implements FAQTopicsFragment.OnTopicSelectedListener {

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        Toolbar toolbar = (Toolbar) findViewById(R.id.faq_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.nav_f_a_q);
        }

        showFAQFragment();
    }

    private void showFAQFragment() {
        Fragment fragment = new FAQTopicsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.faq_container, fragment);
        fragmentTransaction.commit();
    }

    private void showToast(String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }

    /**
     * @param clickPosition clicked position of f.a.q topics
     */
    @Override
    public void onFragmentInteraction(int clickPosition) {
        Fragment sectionFragment = null;
        switch (clickPosition) {

            case 0:
                sectionFragment = new DefinitionFragment();
                Log.d("FAQ-FAQSelect", "DefinitionFragment");
                break;
            case 1:
                sectionFragment = new SymptomsFragment();
                Log.d("FAQ-FAQSelect", "SymptomsFragment");
                break;
            case 2:
                sectionFragment = new CausesFragment();
                Log.d("FAQ-FAQSelect", "CausesFragment");
                break;
            case 3:
                sectionFragment = new RiskFragment();
                Log.d("FAQ-FAQSelect", "RiskFragment");
                break;
            case 4:
                sectionFragment = new ComplicationsFragment();
                Log.d("FAQ-FAQSelect", "ComplicationsFragment");
                break;
            case 5:
                sectionFragment = new DiagnosisFragment();
                Log.d("FAQ-FAQSelect", "DiagnosisFragment");
                break;
            case 6:
                sectionFragment = new TreatmentsFragment();
                Log.d("FAQ-FAQSelect", "TreatmentsFragment");
                break;
            case 7:
                sectionFragment = new RemediesFragment();
                Log.d("FAQ-FAQSelect", "RemediesFragment");
                break;
            case 8:
                sectionFragment = new AlternativeFragment();
                Log.d("FAQ-FAQSelect", "AlternativeFragment");
                break;
            case 9:
                sectionFragment = new PreventionFragment();
                Log.d("FAQ-FAQSelect", "PreventionFragment");
                break;
        }

        if (sectionFragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            fragmentTransaction.replace(R.id.faq_container, sectionFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Log.d("FAQ-FAQSelect", "Section shown :" + fragmentManager.toString());
        }
    }
}