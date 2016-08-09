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
public class InformedConsentActivity extends AppCompatActivity{

    private EditText nameView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_informed_consent);
        nameView = (EditText) findViewById(R.id.name_consent);
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

        //this.setFinishOnTouchOutside(false);

    }

    private void showLocationDialog() {
        Calendar cal = Calendar.getInstance();
        String month = Integer.toString(cal.get(Calendar.MONTH)+1);
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String year = Integer.toString(cal.get(Calendar.YEAR));

        //nameView = (EditText) findViewById(R.id.name_consent);
        String nameValue = nameView.getText().toString();

        String date = month+"/"+day+"/"+year;

        AlertDialog.Builder builder = new AlertDialog.Builder(InformedConsentActivity.this);
        builder.setTitle("Informed Consent");


        builder.setMessage("I, " +nameValue+" , agree to take part in a research study called “Optimizing a Mobile-Application Approach to Improving Medication Adherence in Patients with Hypertension.” This study is being conducted by Drs. Kendra Manigault, Maria Thurston, Sweta Patel, Lydia Newsom, Kevin Murnane, and Ayman Akil. \n My participation in this study is completely voluntary. This means I do not have to be in this study if I do not want to. I know that I can choose if I take part in this study or not.   I can stop taking part at any time. If I stop, I can still get my same care through this institution.  I can ask to have all of the information about me given back to me. I can also ask to have all of my information taken out of the study or destroyed. If I choose to participate, I will be given $25 Walmart gift card to compensate for my time, parking, and data use on my cell phone at the end of this study if I complete the study as I am told. \n The goal of this study is to figure out if using a mobile application will increase the amount of time that I take my blood pressure medication and to figure out what predicts which patients take their medications more often. Sets of questions will be used by the researchers to help figure this out. \n This study asks different sets of questions about how I take my medications. There are also questions that will ask about my lifestyle habits, blood pressure medications, personal information (age, gender, race, marital status, insurance status, medical conditions, and annual income) and how well I can read, understand, and apply information about my health. These questions will be asked at the first appointment. If I choose to participate, I agree to download a mobile application on my cell phone and use my cellular data to use the application. I also agree to have my blood pressure taken by a clinic staff member or trained study professional two separate times.  It should take about 20 minutes to complete the initial appointment. \n There are two different groups of patients for this study. Patients in group A (intervention group) will complete questions about how they take their medications and lifestyle habits at the end of months 1 and 2 of the study in the mobile application. These patients will also receive education and calendar reminders about getting refills and taking their medications. The blood pressure medication regimen for patients in group A will be entered at the time of study enrollment. If patient’s blood pressure medications change, patients may receive incorrect application reminders and notifications unless the patient asks a study personnel to update the application. Patients in group B (control group) will not complete any questions during months 1 and 2 of the study in the mobile application, have their blood pressure medication regimen entered, or receive education or calendar reminders about getting refills and taking their medication. Patients in groups A and B will be able to enter their blood pressure levels into the mobile application. It should take patients in group A 10 minutes to complete survey questions asked each month. \n If I choose to participate, I agree to return to the clinic three months after my initial appointment to complete the study. At that time, I will be asked about lifestyle habits and how I take my medications. I also agree to have my blood pressure re-taken by a clinic staff member or trained study professional. It should take about 20 minutes to complete the final appointment.\nIf I agree to participate in this study I will be asked to do the following:\n\n •	Sign an authorization to use and disclose my protected health information\n •	Download a mobile application and use my personal cellular data to operate the application\n•	Complete four surveys if assigned to group A\n•	Complete two survey if assigned to group B\n•	Return to the clinic three months after the initial appointment to complete the study \n \n My name will be stored away from my answers.  In all other ways, privacy will be protected to the point allowed by law.  Only my answers without my name with them will be studied.  No information that identifies me, or information that I gave during the research, will be shared with other people without my written approval.  I will be given a special number. This number will be used on all of the sets of questions I fill out.  The master list linking my number and my name will be destroyed after review of all of the answers is complete.\n My answers may be published. This means that the researchers can write about my answers and other people can read what is written. But my answers will only be written about on a group basis. This means that there is no way to tell what answers are mine or what answers belong to someone else in the study.\n There might be some scientific benefit from this research. But I may not get any personal benefit from my choosing to take part.  The researchers think my taking part in this study will not cause any risk or discomfort to me, but if I feel any discomfort while completing any part of this study, I can stop at any time.  The researches will do all in their power to make sure no one but them have access to my information, but there is a very small chance it may not be possible to keep all information about me private.\n The investigator will answer any more questions about the research, now or during the course of the study.  I understand that when I sign my name below, I am agreeing by my signature to take part in this research project.\n\n Participant Signature: " +nameValue+" \n Date: "+date+"\n \n Researcher Obtaining Consent: Reasearcher Name  \n Date: "+date+"\n\n This project has been reviewed and approved by Mercer University’s IRB.  If you believe there is any infringement upon your rights as a research subject, you may contact the Chair, at (478) 301-4101.");




        builder.setPositiveButton("Agree",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(InformedConsentActivity.this, HIPAAActivity.class);
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
