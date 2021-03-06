package com.edu.ustc.ustcschedule.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import com.edu.ustc.ustcschedule.ClassPopUpMenu;
import com.edu.ustc.ustcschedule.MainActivity;
import com.edu.ustc.ustcschedule.R;
import com.edu.ustc.ustcschedule.ClassTextInit;
import com.edu.ustc.ustcschedule.databinding.FragmentScheduleWeekBinding;

public class WeekScheduleFragment extends Fragment {

    private FragmentScheduleWeekBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentScheduleWeekBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ClassTextInit textInit = new ClassTextInit();
        ClassPopUpMenu popUpMenu = new ClassPopUpMenu();
        ScrollView scrollView = view.findViewById(R.id.scroll);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        textInit.initText(view);
        scrollView.post(() -> scrollView.scrollTo(0, scrollView.getHeight() / 2));
        view.findViewById(R.id.week_mode).setOnClickListener(view1 -> Navigation.findNavController(
                requireView()).navigate(R.id.action_schedule_week_to_month));
        view.findViewById(R.id.side_bar).setOnClickListener(view2 -> MainActivity.result.openDrawer());
        view.findViewById(R.id.add_events).setOnClickListener(view3 -> popUpMenu.onAddEvent(view3, fragmentManager));
        view.findViewById(R.id.filter).setOnClickListener(popUpMenu::onFilter);
    }
}
