package com.seniordesign.appmd;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
/**
 * Created by lindsayherron on 8/8/16.
 */
public class HIPAAActivity extends AppCompatActivity{

    private EditText nameView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_hipaa);
        nameView = (EditText) findViewById(R.id.name_consent);
        //this.setFinishOnTouchOutside(false);
        nameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.name_consent || id == EditorInfo.IME_NULL) {
                    setTheme(R.style.myDialog);
                    showLocationDialog();
                    return true;
                }
                return false;
            }
        });
    }

    private void showLocationDialog() {
        Calendar cal = Calendar.getInstance();
        String month = Integer.toString(cal.get(Calendar.MONTH)+1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String year = Integer.toString(cal.get(Calendar.YEAR));

        //nameView = (EditText) findViewById(R.id.name_consent);
        String nameValue = nameView.getText().toString();
        String date = month + "/" + day + "/" + year;

        AlertDialog.Builder builder = new AlertDialog.Builder(HIPAAActivity.this);
        builder.setTitle("HIPAA ");


        builder.setMessage("\n" +
                "The privacy law, Health Insurance Portability & Accountability Act (HIPAA), protects my health information.  I am being asked to sign this agreement so that researchers may use or make known my protected health information for research purposes in the study called “Optimizing a Mobile-Application Approach to Improving Medication Adherence in Patients with Hypertension” by Drs. Kendra Manigault, Maria Thurston, Sweta Patel, Lydia Newsom, Kevin Murnane, and Ayman Akil. Taking part in the research is voluntary.  If I choose to take part in the research, I must sign this form so that my health information may be used for the research. My decision to release or not to release this information will not affect the current or future services I receive from this institution.  If I do not agree to this, I will not be able to participate in this study.\n" +
                " \n" +
                "I authorize the disclosure of my refill history for my blood pressure medications three months before my study enrollment, during my study enrollment, and three months after my study enrollment as well as my blood pressure values during the study period. The researchers will protect this information by using it only as allowed by me in this Authorization and as directed by state and federal law.  If I have any questions and/or wish to cancel this Authorization in writing at any time, I can contact Dr. Kendra Manigault at the Department of Pharmacy Practice, Mercer University College of Pharmacy, Atlanta GA 30341, 678-547-6216. This Authorization expires three months after the end of the research study.  I have a right to request to see my health information.  However, to ensure the scientific integrity of the research, I will not be able to review the research information until after the research protocol has been completed.\n" +
                " \n" +
                "I, " + nameValue + ", give permission for this institution to release my refill history for my blood pressure medications three months before my study enrollment, during my study enrollment, and three months after my study enrollment as well as my blood pressure values during the study period to Drs. Kendra Manigault, Maria Thurston, Sweta Patel, Lydia Newsom, Kevin Murnane, and Ayman Akil for the above-titled research project.  I understand that I am agreeing by my signature on this form to allow the release of the information stated above \n"
                + "\nPrinted of Participant: " + " \n" + "Date: " +date+ " \n \n"+
                "Participant Address and Phone: From Profile"+
                "\nPrinted of Investigator: " + " \n" + "Date: "+date + " \n \n");






        builder.setPositiveButton("Agree",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(HIPAAActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                });

        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }
}
