package edu.nsu.ir.Cases;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CCaseDetailsActivity extends AppCompatActivity {

    private Button mShareButton;
    private RadioGroup mStatusGroup;
    private RadioButton mActiveButton, mClosedButton;
    private  CCase mCase;
    private String currentStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(edu.nsu.ir.R.layout.c_activity_case_details);
        mCase=getIntent().getParcelableExtra("case");
        if (mCase!=null){

        }
        init();
 //
//        Intent intent = new Intent(this, CCaseHomeActivity.//class);
//        intent.putExtra("radiobuttontext", currentS//t//atus);
//
//        mStatusGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedCha//ngeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, i//nt checkedId) {
//                if (mActiveButt//on.isChecked())
//                    currentStatus = mActiveButton.getTex//t().toString();
//                else
//                    currentStatus = mClosedButton.getTex//t().toString()//;
//            }
//        });

        // Start Share View
        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startShareView();
            }
        });
    }

    private void init() {
        mShareButton = (Button)findViewById(edu.nsu.ir.R.id.shareDetailsButton);
        mStatusGroup = (RadioGroup)findViewById(edu.nsu.ir.R.id.caseStatusRadioGroup);
        mActiveButton = (RadioButton)findViewById(edu.nsu.ir.R.id.activeRadioButton);
        mClosedButton = (RadioButton)findViewById(edu.nsu.ir.R.id.closedRadioButton);
    }

    private void startShareView(){
        Intent intent = new Intent(this, CShareCaseActivity.class);
        startActivity(intent);
    }



    /**
     * Check if radio button is checked
     * @param view
     */
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case edu.nsu.ir.R.id.activeRadioButton:
                if (checked)
                    Toast.makeText(CCaseDetailsActivity.this, "Case is Active", Toast.LENGTH_SHORT).show();
                break;
            case edu.nsu.ir.R.id.closedRadioButton:
                if (checked)
                    Toast.makeText(CCaseDetailsActivity.this, "Case is Closed", Toast.LENGTH_SHORT).show();
        }

//        Intent intent = new Intent(this, CCaseHomeActivity.class);
//        intent.putExtra()
    }
}
