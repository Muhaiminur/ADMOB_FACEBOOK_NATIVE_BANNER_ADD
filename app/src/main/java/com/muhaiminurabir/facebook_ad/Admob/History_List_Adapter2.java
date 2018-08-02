package com.muhaiminurabir.facebook_ad.Admob;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.muhaiminurabir.facebook_ad.R;

import java.util.ArrayList;
import java.util.List;
public class History_List_Adapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // A menu item view type.
    private static final int MENU_ITEM_VIEW_TYPE = 0;

    private static final int UNIFIED_NATIVE_AD_VIEW_TYPE = 1;

    // An Activity's Context.
    private final Context mContext;
    List<Object> stringList;
    Context context1;
    public History_List_Adapter2(Context context, List<Object> list) {
        this.mContext = context;
        stringList=list;
        context1 = context;
    }


    public class History_List_Adapter3 extends RecyclerView.ViewHolder {
        public TextView history_name,history_count;
        public ImageView history_app_icon;
        public History_List_Adapter3(View view) {
            super(view);
            history_name = view.findViewById(R.id.history_name);
            history_count=view.findViewById(R.id.history_number);
            history_app_icon = view.findViewById(R.id.history_app_icon);
        }
    }
    @Override
    public int getItemCount() {
        return stringList.size();
    }
    @Override
    public int getItemViewType(int position) {

        Object recyclerViewItem = stringList.get(position);
        if (recyclerViewItem instanceof UnifiedNativeAd) {
            return UNIFIED_NATIVE_AD_VIEW_TYPE;
        }
        return MENU_ITEM_VIEW_TYPE;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case UNIFIED_NATIVE_AD_VIEW_TYPE:
                View unifiedNativeLayoutView = LayoutInflater.from(
                        viewGroup.getContext()).inflate(R.layout.ad_unified,
                        viewGroup, false);
                return new UnifiedNativeAdViewHolder(unifiedNativeLayoutView);
            case MENU_ITEM_VIEW_TYPE:
                // Fall through.
            default:
                View itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.history_list, viewGroup, false);
                return new History_List_Adapter3(itemView);
                //return new MenuItemViewHolder(menuItemLayoutView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case UNIFIED_NATIVE_AD_VIEW_TYPE:
                UnifiedNativeAd nativeAd = (UnifiedNativeAd) stringList.get(position);
                populateNativeAdView(nativeAd, ((UnifiedNativeAdViewHolder) holder).getAdView());
                break;
            case MENU_ITEM_VIEW_TYPE:
                // fall through
            default:
                History_List_Adapter3 menuItemHolder = (History_List_Adapter3) holder;
                ApkInfoExtractor apkInfoExtractor = new ApkInfoExtractor(context1);


                final String ApplicationPackageName = (String) stringList.get(position);
                final String ApplicationLabelName = apkInfoExtractor.GetAppName(ApplicationPackageName);
                Drawable drawable = apkInfoExtractor.getAppIconByPackageName(ApplicationPackageName);

                menuItemHolder.history_name.setText(ApplicationLabelName);

                //viewHolder.textView_App_Package_Name.setText(ApplicationPackageName);

                /*Notification_History history=realm.where(Notification_History.class).equalTo("apkname",ApplicationPackageName).findFirst();
                if (history!=null){
                    menuItemHolder.history_count.setText(history.getNotification_count());
                }else {
                    menuItemHolder.history_count.setText("0");
                }*/

                menuItemHolder.history_count.setText("0");

                menuItemHolder.history_app_icon.setImageDrawable(drawable);
        }
    }
    private void populateNativeAdView(UnifiedNativeAd nativeAd,
                                      UnifiedNativeAdView adView) {
        // Some assets are guaranteed to be in every UnifiedNativeAd.
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        NativeAd.Image icon = nativeAd.getIcon();

        if (icon == null) {
            adView.getIconView().setVisibility(View.INVISIBLE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(icon.getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        // Assign native ad object to the native view.
        adView.setNativeAd(nativeAd);
    }
}
