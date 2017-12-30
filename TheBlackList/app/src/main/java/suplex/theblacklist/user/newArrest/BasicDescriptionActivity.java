package suplex.theblacklist.user.newArrest;

import android.os.Bundle;
import android.widget.EditText;

import suplex.theblacklist.R;
import suplex.theblacklist.objects.Arrest;

public class BasicDescriptionActivity extends NewArrestTask {

    private EditText mAliasEditText;
    private EditText mHeightEditText;
    private EditText mWeightEditText;
    private EditText mEyeColorEditText;
    private EditText mHairColorEditText;
    private EditText mSkinColorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_description);

        newArrest = new Arrest();


    }
}
