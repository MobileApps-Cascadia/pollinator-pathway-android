package edu.cascadia.mobas.pollinatorpathway.ui.SetUp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SetUpViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SetUpViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}