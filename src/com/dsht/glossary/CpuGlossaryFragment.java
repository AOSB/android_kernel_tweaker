package com.dsht.glossary;

import com.dsht.kerneltweaker.CustomArrayAdapter;
import com.dsht.kerneltweaker.GlossaryArrayAdapter;
import com.dsht.kerneltweaker.R;
import com.dsht.kerneltweaker.fragments.CpuPreferenceFragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class CpuGlossaryFragment extends Fragment implements OnItemClickListener {

	private Context mContext;
	private ListView list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.menu_list, container,false);
		
		list = (ListView) v.findViewById(R.id.navbarlist);
		GlossaryArrayAdapter mAdapter = new GlossaryArrayAdapter(
				mContext,
				R.layout.list_item,
				getResources().getStringArray(R.array.glo_cpu_titles), 
				getResources().getStringArray(R.array.glo_cpu_descs),
				getResources().getStringArray(R.array.menu_colors)[0]);
		list.setAdapter(mAdapter);
		
		list.setOnItemClickListener(this);
		return v;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View parent, int position, long id) {
		// TODO Auto-generated method stub
		View v = list.getChildAt(position);
		TextView tv = (TextView) v.findViewById(android.R.id.text1);
		if(tv.getText().toString().equalsIgnoreCase("governor")) {
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			GovernorGlossaryFragment glo = new GovernorGlossaryFragment();
			// This adds the newly created Preference fragment to my main layout, shown below
			ft.replace(R.id.menu_frame, glo);
			// By hiding the main fragment, transparency isn't an issue
			ft.addToBackStack("TAG");
			ft.commit();
		}
		
	}

}
