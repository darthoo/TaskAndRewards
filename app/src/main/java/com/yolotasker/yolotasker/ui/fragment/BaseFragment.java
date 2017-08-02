package com.yolotasker.yolotasker.ui.fragment;


import android.support.v4.app.Fragment;
import com.yolotasker.yolotasker.ui.utils.HasComponent;

/**
 * Created by AndroidDev on 31.07.2017.
 */

public class BaseFragment extends Fragment {

    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }


}
