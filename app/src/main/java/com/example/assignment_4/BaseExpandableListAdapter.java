package com.example.assignment_4;

import android.view.View;
import android.view.ViewGroup;

public abstract class BaseExpandableListAdapter {
    public abstract int getGroupCount();

    public abstract int getChildrenCount(int groupPosition);

    public abstract Object getGroup(int groupPosition);

    public abstract Object getChild(int groupPosition, int childPosition);

    public abstract long getGroupId(int groupPosition);

    public abstract long getChildId(int groupPosition, int childPosition);

    public abstract boolean hasStableIds();

    public abstract View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent);

    public abstract View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent);

    public abstract boolean isChildSelectable(int groupPosition, int childPosition);
}
