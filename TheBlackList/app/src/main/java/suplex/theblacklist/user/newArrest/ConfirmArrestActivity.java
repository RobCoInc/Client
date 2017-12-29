package suplex.theblacklist.user.newArrest;

import android.os.Bundle;

import suplex.theblacklist.R;

public class ConfirmArrestActivity extends NewArrestTask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_arrest);

        // Final confirmation of arrest, possible overview of entered data.
    }
}
