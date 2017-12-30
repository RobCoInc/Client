package suplex.theblacklist.user.newArrest;

import android.os.Bundle;
import android.widget.EditText;

import suplex.theblacklist.R;
import suplex.theblacklist.objects.Arrest;

public class BasicDescriptionActivity extends NewArrestTask {

    private EditText mAliasEditText;
    private EditText mHeightEditText;
    private EditText mWeightEditText;

    private EditText mHairColorEditText;
    private EditText mHairStyleEditText;
    private EditText mEyeColorEditText;
    private EditText mSkinColorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_description);

        newArrest = new Arrest();

        mAliasEditText = (EditText) findViewById(R.id.edit_arrest_name);
        mHeightEditText = (EditText) findViewById(R.id.edit_arrest_height);
        mWeightEditText = (EditText) findViewById(R.id.edit_arrest_weight);

        mHairColorEditText = (EditText) findViewById(R.id.edit_arrest_hair_color);
        mHairStyleEditText = (EditText) findViewById(R.id.edit_arrest_hair_style);
        mEyeColorEditText = (EditText) findViewById(R.id.edit_arrest_eye_color);
        mSkinColorEditText = (EditText) findViewById(R.id.edit_arrest_skin_color);

    }
}
